package ru.progwards.java1.lessons.maps;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class SalesInfo {
     private final List<String[]> LIST_PURCHASES = new ArrayList<>();

    public int loadOrders(String fileName) {
        File file = new File(fileName);
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] dataPurchase = line.split(", "); // делю строку по запятым

                if (dataPurchase.length == 4 && isNumeric(dataPurchase[2]) && isNumeric(dataPurchase[3])) {
                    LIST_PURCHASES.add(dataPurchase);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return LIST_PURCHASES.size();
    }

    public static boolean isNumeric(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public Map<String, Double> getGoods() {
        Map<String, Double> productNameAndSum = new TreeMap<>();
        Set<String> setProductName = new HashSet<>(); //создаю множество из наименований товаров
        for (String[] element : LIST_PURCHASES) {
           setProductName.add(element[1]);
        }

        for (String name : setProductName) { // вычисляю общую сумму проданного товара по его наименованию
            double count = 0d;
            for (String[] element : LIST_PURCHASES) {
                if (element[1].contains(name)) {
                   count += Double.parseDouble(element[3]);
                }
            }
                productNameAndSum.put(name, count); // заполняю productNameAndSum
        }
        return productNameAndSum;
    }

    public Map<String, AbstractMap.SimpleEntry<Double, Integer>> getCustomers() {
        Map<String, AbstractMap.SimpleEntry<Double, Integer>> customerAndSumAndQuantity  = new TreeMap<>();

        Set<String> setCustomers = new HashSet<>(); // создаю множество покупателей
        for (String[] element : LIST_PURCHASES) {
            setCustomers.add(element[0]);
        }

        for (String name : setCustomers) {
            double sumCount = 0d;
            int buyCount = 0;
            for (String[] element : LIST_PURCHASES) {
                if (element[0].contains(name)) {
                    sumCount += Double.parseDouble(element[3]);
                    buyCount += Integer.parseInt(element[2]);
                }
            }
            customerAndSumAndQuantity.put(name, new AbstractMap.SimpleEntry<>(sumCount, buyCount));
        }
        return customerAndSumAndQuantity;
    }
    // test
    public static void main(String[] args) {
        SalesInfo test = new SalesInfo();
        System.out.println(test.loadOrders("src/ru/progwards/java1/lessons/maps/shoppingList.CSV"));
        System.out.println(test.getGoods());
        System.out.println(test.getCustomers());
    }
}

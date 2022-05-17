package ru.progwards.java1.lessons.sets;

import java.util.*;

public class ProductAnalytics {
    private final List<Shop> shops;
    private final List<Product> products;

    public ProductAnalytics(List<Product> products, List<Shop> shops) {
        this.products = products;
        this.shops = shops;
    }

    public Set<Product> existInAll() {                                           //товары из products, которые имеются во всех магазинах (пересечение множеств)
        Set<Product> meetOfProducts = new HashSet<>(shops.get(0).getProducts()); // список продуктов в первом магазине
        for (int i = 1; i < shops.size(); i++) {
            meetOfProducts.retainAll(shops.get(i).getProducts());                //определяю совпадающие эл-ты
        }
        return meetOfProducts;
    }

    public Set<Product> existAtListInOne() {                                      // товары из products, которые имеются хотя бы в одном магазине (объединение множеств)
        Set<Product> unionOfProducts = new HashSet<>(shops.get(0).getProducts()); // список продуктов в первом магазине
        for (int i = 1; i < shops.size(); i++) {
            unionOfProducts.addAll(shops.get(i).getProducts());                   // добавляю эл-ты, которых нет в первом списке из последующих списков
        }
        return unionOfProducts;
    }

    public Set<Product> notExistInShops() {                // товары из products, которых нет ни в одном магазине
        Set<Product> noProducts = new HashSet<>(products); // копия полного ассортимента продуктов products
        Set<Product> unionProducts = existAtListInOne();   // полный список продуктов, имеющихся во всех магазинах
        noProducts.removeAll(unionProducts);               // удаляю совпадающие эл-ты из списка noProduct
        return noProducts;                                // список продуктов, которых нет в магазинах
    }

    public Set<Product> existOnlyInOne() {                                       // товары из products, которые есть только в одном магазине
        Set<Product> existOnlyInOneSet = new HashSet<>(existAtListInOne());      // полный список продуктов, имеющихся во всех магазинах
        Set<Product> overlapSum = new HashSet<>();                               // множество для всех совпадений товаров во всех магазинах

        for (int i = 0; i < shops.size() - 1; i++) {
            Set<Product> tempList = new HashSet<>(shops.get(i).getProducts()); // список продуктов в каком-то магазине
            Set<Product> overlap = new HashSet<>(tempList);                    // копия tempList
            for (int j = i + 1; j < shops.size(); j++) {
                overlap.retainAll(new HashSet<>(shops.get(j).getProducts()));  //определяю совпадающие эл-ты в итерации цикла
                overlapSum.addAll(overlap);                                    // добавляю полученные совпадения в множество
                overlap.clear();
                overlap = new HashSet<>(tempList);
            }
        }
        existOnlyInOneSet.removeAll(overlapSum);                              // получаю множество с товарами которые есть, только в одном магазине
        return existOnlyInOneSet;
    }

    public static void main(String[] args) {

        Product soap = new Product("art-1");
        Product washingPowder = new Product("art-2");
        Product pasta = new Product("art-3");
        Product shampoo = new Product("art-4");
        Product shavingGel = new Product("art-5");
        Product shavingFoam = new Product("art-6");
        Product lotion = new Product("art-7");
        Product razor = new Product("art-8");
        Product brush = new Product("art-9");
        Product scissors = new Product("art-10");

        List<Product> products = new ArrayList<>();
        products.add(soap);
        products.add(washingPowder);
        products.add(pasta);
        products.add(shampoo);
        products.add(shavingGel);
        products.add(shavingFoam);
        products.add(lotion);
        products.add(razor);
        products.add(brush);
        products.add(scissors);

        List<Product> list1 = new ArrayList<>();
        list1.add(soap);
        list1.add(washingPowder);
        list1.add(razor);
        list1.add(brush);

        List<Product> list2 = new ArrayList<>();
        list2.add(pasta);
        list2.add(shavingGel);

        List<Product> list3 = new ArrayList<>();
        list3.add(soap);
        list3.add(shavingGel);
        list3.add(brush);
        list3.add(razor);

        Shop shop1 = new Shop(list1);
        Shop shop2 = new Shop(list2);
        Shop shop3 = new Shop(list3);

        List<Shop> shops = new ArrayList<>();
        shops.add(shop1);
        shops.add(shop2);
        shops.add(shop3);

        ProductAnalytics analytics1 = new ProductAnalytics(products, shops);
        System.out.println("Товары, которые есть во всех магазинах : " + analytics1.existInAll());
        System.out.println();
        System.out.println("Товары, которые имеются хотя бы в одном магазине : " + analytics1.existAtListInOne());
        System.out.println();
        System.out.println("Товары, которых нет ни в одном магазине : " + analytics1.notExistInShops());
        System.out.println();
        System.out.println("Товары, которые есть только в одном магазине : " + analytics1.existOnlyInOne());

    }
}

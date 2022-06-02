package ru.progwards.java1.lessons.queues;

public class Order {
    private final double sum;
    private final int num;
    private static int countNum = 1;

    public Order(double sum) {
        this.sum = sum;
        this.num = countNum++;
    }

    public double getSum() {
        return sum;
    }

    public int getNum() {
        return num;
    }

    public static void main(String[] args) {
        Order order1 = new Order(10_500);
        Order order2 = new Order(9_800);
        Order order3 = new Order(4_300);
        Order order4 = new Order(2_200);
        System.out.println(order1.getSum());
        System.out.println(order1.getNum());
        System.out.println(order2.getNum());
        System.out.println(order3.getNum());
        System.out.println(order4.getNum());
    }
}

package ru.progwards.java1.lessons.queues;


import java.util.Comparator;
import java.util.PriorityQueue;

public class OrderQueue {
    Comparator<Order> cmp = new Comparator<>() { // сортировка очереди внутри каждого класса-заказов - по номеру заказа.
        @Override
        public int compare(Order o1, Order o2) {
            Integer num1 = o1.getNum();
            Integer num2 = o2.getNum();
            return num1.compareTo(num2);
        }
    };
    private final PriorityQueue<Order> orderClass_1 = new PriorityQueue<>(cmp);
    private final PriorityQueue<Order> orderClass_2 = new PriorityQueue<>(cmp);
    private final PriorityQueue<Order> orderClass_3 = new PriorityQueue<>(cmp);

    public void add(Order order) { //фильтрую заказы по классам
        if (order.getSum() <= 10_000d) {
            orderClass_3.offer(order);
        } else if ((order.getSum() >= 10_000d) && (order.getSum() <= 20_000d)) {
            orderClass_2.offer(order);
        } else {
            orderClass_1.offer(order);
        }
    }

    public Order get() { // создаю очередность обслуживания заказов
        if (!orderClass_1.isEmpty()) {
            return orderClass_1.poll();
        } else if (!orderClass_2.isEmpty()) {
            return orderClass_2.poll();
        } else if (!orderClass_3.isEmpty()) {
            return orderClass_3.poll();
        } else
            return null;
    }
}

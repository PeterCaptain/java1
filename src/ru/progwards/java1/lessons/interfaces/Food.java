package ru.progwards.java1.lessons.interfaces;

public class Food implements CompareWeight {
    private final int weight;

    public Food(int weight) {
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public CompareResult compareWeight(CompareWeight smthHasWeigt) {
        Food food = (Food) smthHasWeigt;
        switch (Integer.compare(this.weight, food.getWeight())) {
            case 0:
                return CompareResult.EQUAL;
            case -1:
                return CompareResult.LESS;
            case 1:
                return CompareResult.GREATER;
        }
        return null;
    }

    public static void sort(CompareWeight[] a) {
        CompareWeight temp;
        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (a[i].compareWeight(a[j]) == CompareResult.GREATER) {
                    temp = a[j];
                    a[j] = a[i];
                    a[i] = temp;
                }
            }
        }
    }

    // test
    public static void main(String[] args) {

        Food a = new Food(5);
        Food b = new Food(1);
        Food c = new Food(7);
        Food d = new Food(10);
        Food e = new Food(3);
        Food f = new Food(3);
        Food g = new Food(3);
        Food l = new Food(9);

        Food[] foods = {a, b, c, d, e, f, g, l};
        for (var food : foods) {
            System.out.print(food.getWeight() + "; ");
        }
        System.out.println();
        System.out.println("**************************");

        Food.sort(foods);
        for (var food : foods) {
            System.out.print(food.getWeight() + "; ");
        }
    }
}


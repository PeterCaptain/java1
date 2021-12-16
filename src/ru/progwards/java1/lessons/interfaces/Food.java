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

    //     test
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

        CompareWeight.sort(foods);
        for (var food : foods) {
            System.out.print(food.getWeight() + "; ");
        }

    }
}

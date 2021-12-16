package ru.progwards.java1.lessons.interfaces;


public class Animal implements FoodCompare, CompareWeight {

    enum AnimalKind {ANIMAL, COW, HAMSTER, DUCK}

    enum FoodKind {UNKNOWN, HAY, CORN}

    private final double weight;

    @Override
    public CompareResult compareWeight(CompareWeight smthHasWeigt) {
        Animal animal = (Animal) smthHasWeigt;

        switch (Double.compare(this.getWeight(), animal.getWeight())) {
            case 0:
                return CompareResult.EQUAL;
            case -1:
                return CompareResult.LESS;
            case 1:
                return CompareResult.GREATER;
        }
        return null;
    }

    @Override
    public int compareFoodPrice(Animal aminal) {
        return Double.compare(this.getFoodPrice(), aminal.getFoodPrice());
    }

    public Animal(double weight) {
        this.weight = weight;
    }

    public AnimalKind getKind() {
        return AnimalKind.ANIMAL;
    }

    public FoodKind getFoodKind() {
        return Animal.FoodKind.UNKNOWN;
    }

    @Override
    public String toString() {
        return "I am " + getKind() + ", eat " + getFoodKind();
    }

    public double getWeight() {
        return weight;
    }

    public double getFoodCoeff() {
        return 0.02;
    }

    public double calculateFoodWeight() {
        return getWeight() * getFoodCoeff();
    }

    public String toStringFull() {
        return "I am " + getKind() + ", eat " + getFoodKind() + " " + calculateFoodWeight();
    }

    @Override
    public boolean equals(Object anObject) {
        if (this == anObject) {
            return true;
        }
        if (anObject == null || getClass() != anObject.getClass()) {
            return false;
        }
        Animal that = (Animal) anObject;
        return Double.compare(this.getWeight(), that.getWeight()) == 0;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    public double getFood1kgPrice() {
        switch (getFoodKind()) {
            case HAY:
                return 20d;
            case CORN:
                return 50d;
        }
        return 0;
    }

    public double getFoodPrice() {
        return calculateFoodWeight() * getFood1kgPrice();
    }

    // test
    public static void main(String[] args) {
        Duck duck = new Duck(5);
        Duck duck1 = new Duck(3);
        Duck duck2 = new Duck(5);
        Hamster hamster = new Hamster(3);
        Food food = new Food(5);
        Hamster hamster1 = new Hamster(3);

        System.out.println(duck.equals(duck2));
        System.out.println(duck1.equals(duck2));
        System.out.println(hamster.equals(duck1));
        System.out.println(duck1.equals(hamster));
        System.out.println(duck.equals(food));
        System.out.println(hamster.equals(hamster1));
    }
}

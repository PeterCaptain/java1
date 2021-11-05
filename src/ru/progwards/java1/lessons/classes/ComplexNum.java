package ru.progwards.java1.lessons.classes;

public class ComplexNum {
     int a;
     int b;

    public ComplexNum(int a, int b) {
        this.a = a; //действ. часть
        this.b = b; // мним. часть
    }

    @Override
    public String toString() {
        return a  + "+" + b + "i";
    }

    public ComplexNum add(ComplexNum num) {
        int c = num.a;
        int d = num.b;
        return new ComplexNum(a + c, b + d);
    }

    public ComplexNum sub(ComplexNum num) {
        int c = num.a;
        int d = num.b;
        return new ComplexNum(a - c, b - d);
    }

    public ComplexNum mul(ComplexNum num) {
        int c = num.a;
        int d = num.b;
        return new ComplexNum(a * c - b * d, b * c + a * d);
    }

    public ComplexNum div(ComplexNum num) {
        int c = num.a;
        int d = num.b;
        return new ComplexNum((a * c + b * d) / (c * c + d * d), (b * c - a * d) / (c * c + d * d));
    }

    public static void main(String[] args) {
        ComplexNum x = new ComplexNum(1, 24);
        ComplexNum y = new ComplexNum(3, 6);
        System.out.println(x.add(y));
        System.out.println(x.div(y));
        System.out.println(x.sub(y));
        System.out.println(x.mul(y));
    }
}

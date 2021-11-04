package ru.progwards.java1.lessons.classes;

public class ComplexNum {
     private int a;
     private int b;

    public ComplexNum(int a, int b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public String toString() {
        return a  + "+" + b + "i";
    }

    public ComplexNum add(ComplexNum number1, ComplexNum number2) {
        int a = number1.a;
        int b = number1.b;
        int c = number2.a;
        int d = number2.b;
       return new ComplexNum( a + c, b + d);
    }

    public ComplexNum sub(ComplexNum number1, ComplexNum number2) {
        int a = number1.a;
        int b = number1.b;
        int c = number2.a;
        int d = number2.b;
        return new ComplexNum(a - c, b - d);
    }

    public ComplexNum mul(ComplexNum number1, ComplexNum number2) {
        int a = number1.a;
        int b = number1.b;
        int c = number2.a;
        int d = number2.b;
        return new ComplexNum(a * c - b * d, b * c + a * d);
    }

    public ComplexNum div(ComplexNum number1, ComplexNum number2) {
        int a = number1.a;
        int b = number1.b;
        int c = number2.a;
        int d = number2.b;
        return new ComplexNum((a * c + b * d) / (c * c + d * d), (b * c - a * d) / (c * c + d * d));
    }
}

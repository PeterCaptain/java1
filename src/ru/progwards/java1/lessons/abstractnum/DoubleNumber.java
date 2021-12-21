package ru.progwards.java1.lessons.abstractnum;

public class DoubleNumber extends Number {
    public double num;

    public DoubleNumber(double num) {
        this.num = num;
    }

    @Override
    public Number mul(Number num) {
        DoubleNumber temp = (DoubleNumber)num;
        return new DoubleNumber(this.num * temp.num);
    }

    @Override
    public Number div(Number num) {
        DoubleNumber temp = (DoubleNumber)num;
        return new DoubleNumber(this.num / temp.num);
    }

    @Override
    public Number newNumber(String strNum) {
        num = Double.parseDouble(strNum);
        return new DoubleNumber(num);
    }

    @Override
    public String toString() {
        return Double.toString(num);
    }
}

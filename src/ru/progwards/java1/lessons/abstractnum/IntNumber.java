package ru.progwards.java1.lessons.abstractnum;

public class IntNumber extends Number {
    public int num;

    public IntNumber(int num) {
        this.num = num;
    }

    @Override
    public Number mul(Number num) {
        IntNumber temp = (IntNumber)(num);
        return new IntNumber(this.num * temp.num);
    }

    @Override
    public Number div(Number num) {
        IntNumber temp = (IntNumber) (num);
        return new IntNumber(this.num / temp.num);
    }

    @Override
    public Number newNumber(String strNum) {
        num = Integer.parseInt(strNum);
        return new IntNumber(num);
    }

    @Override
    public String toString() {
        return Integer.toString(num);
    }
}

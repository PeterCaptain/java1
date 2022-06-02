package ru.progwards.java1.lessons.queues;


import java.util.ArrayDeque;

public class StackCalc {
    ArrayDeque<Double> stack = new ArrayDeque<>();

    public void push(double value) {
        stack.push(value);
    }

    public double pop() {
        return stack.pop();
    }

    public void add() {
       push(pop() + pop());
    }

    public void sub() {
        push(-pop() + pop());
    }

    public void mul() {
        push(pop() * pop());
    }

    public void div() {
        double num1 = pop();
        double num2 = pop();
        push(num2 / num1); // сначала был такой вариант push(1 / pop() * pop);, но происходит потеря точности и робот ответ не пропускает
    }

    public static void main(String[] args) {
        StackCalc stackCalc =  new StackCalc();
        stackCalc.stack.push(5d);
        stackCalc.stack.push(7d);
        stackCalc.stack.push(5d);
        stackCalc.stack.push(7d);
        stackCalc.stack.push(5d);

//        System.out.println(stackCalc.stack);
//        stackCalc.add();
//        System.out.println(stackCalc.stack);
//        stackCalc.sub();
//        System.out.println(stackCalc.stack);
//        stackCalc.mul();
//        System.out.println(stackCalc.stack);
        stackCalc.div();
        System.out.println(stackCalc.stack);
    }
}

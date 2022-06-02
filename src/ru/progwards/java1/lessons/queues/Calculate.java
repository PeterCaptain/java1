package ru.progwards.java1.lessons.queues;

public class Calculate  {

    public static double calculation1() {
//  2.2*(3+12.1) == 33.22
       StackCalc stackCalc = new StackCalc();
       stackCalc.push(2.2);
       stackCalc.push(3d);
       stackCalc.push(12.1);
       stackCalc.add();
       stackCalc.mul();
       return stackCalc.pop();
    }

    public static double calculation2() {
//  (737.22+24)/(55.6-12.1)+(19-3.33)*(87+2*(13.001-9.2)) == 1499.9126503448276
        StackCalc stackCalc = new StackCalc();
        stackCalc.push(13.001);
        stackCalc.push(9.2);
        stackCalc.sub();
        stackCalc.push(2d);
        stackCalc.mul();
        stackCalc.push(87d);
        stackCalc.add();
        stackCalc.push(19d);
        stackCalc.push(3.33);
        stackCalc.sub();
        stackCalc.mul();
        stackCalc.push(737.22);
        stackCalc.push(24d);
        stackCalc.add();
        stackCalc.push(55.6);
        stackCalc.push(12.1);
        stackCalc.sub();
        stackCalc.div();
        stackCalc.add();
        return stackCalc.pop();
    }

    public static void main(String[] args) {
        System.out.println(calculation1());
        System.out.println(calculation2());
    }
}

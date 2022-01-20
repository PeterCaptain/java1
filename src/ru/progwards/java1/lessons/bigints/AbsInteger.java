package ru.progwards.java1.lessons.bigints;

public class AbsInteger {
    /* Метод "static AbsInteger add(AbsInteger num1, AbsInteger num2)" вычисляет сумму num1 + num2
       (из условий задачи num1 и num2 могут быть разных типов (byte, short, int))
        Примечание:
        - с числами возвращаемыми классами потомками ByteInteger и ShortInteger проблем нет. Максимальные значения
        этих чисел легко укладываются в диапазон чисел типа int. Соответственно и любая сумма получаемая от этих
        значений, так же не выходит за этот диапазон.
        - с числами возвращаемыми классом потомком IntInteger - есть проблема. Сумма этих чисел, при определенных
        значениях будет превышать диапазон int. Соответственно, значение будет обрезаться по диапазону типа int.
        В итоге может получиться не верный результат.
     */

    static AbsInteger add(AbsInteger num1, AbsInteger num2) {

        long sum = (long) num1.getInt() + num2.getInt(); // long - чтобы сумма чисел типа int считалась правильно

        if (sum >= Byte.MIN_VALUE && sum <= Byte.MAX_VALUE) {
            return new ByteInteger((byte) sum);
        } else if (sum >= Short.MIN_VALUE && sum <= Short.MAX_VALUE) {
            return new ShortInteger((short) sum);
        }
        return new IntInteger((int) sum); // здесь сумма приводится к типу int (результат обрезается)
    }

    public int getInt() {
        return 0;
    }
}

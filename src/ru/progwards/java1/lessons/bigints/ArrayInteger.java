package ru.progwards.java1.lessons.bigints;

import java.math.BigInteger;
import java.util.Arrays;

public class ArrayInteger {
    private final int n;
    private byte[] digits;

    ArrayInteger(int n) {
        this.n = n;
        digits = new byte[n];
    }

    public void fromInt(BigInteger value) {
        // вариант 1
 /*       if (value.compareTo(BigInteger.ZERO) < 0) {
            System.out.println("Число не должно быть отрицательным\n");
        } else {
            String tempStr = value.toString();
            int length = tempStr.length();
        // проверка на переполнение
            if (length <= n) {
                for (int i = 0, j = length - 1; i < length; i++, j--) {
                    digits[i] = Byte.parseByte(String.valueOf(tempStr.charAt(j)));
                }
            } else {
                printError();
            }
       }
*/
        // вариант 2
        if (value.compareTo(BigInteger.ZERO) < 0) {
            System.out.println("Число не должно быть отрицательным\n");
        } else {
            BigInteger[] temp;
            int i = 0;
            int length = value.toString().length();
            // проверка на переполнение
            if (length > n) {
                printError();
            } else {
                temp = value.divideAndRemainder(BigInteger.TEN);
                digits[i] = temp[1].byteValue();
                while (temp[0].compareTo(BigInteger.ZERO) > 0) {
                    temp = temp[0].divideAndRemainder(BigInteger.TEN);
                    i++;
                    digits[i] = temp[1].byteValue();
                }
            }
        }
    }

    public void printError() {
        System.out.println("Количество цифр в числе превышает размер массива");
        System.out.println("Число должно содержать не более " + n + " цифр\n");
    }


    public BigInteger toInt() {
        BigInteger newNumber = new BigInteger("0");

        for (int j = digits.length - 1; j >= 0; j--) {
            BigInteger pow = BigInteger.TEN.pow(j);
            BigInteger summed = new BigInteger(String.valueOf(digits[j]));
            summed = summed.multiply(pow);
            newNumber = newNumber.add(summed);
        }
        return newNumber;
    }

    public boolean add(ArrayInteger num) {
// определим кол-во значимых цифр во втором слагаемом
        int numLength = num.toInt().toString().length();
// Определим условие сложения чисел. Если второе слагаемое сможет уложиться в массив первого слагаемого - можно
// производить сложение. (при этом производим запись новых значений в массив экземпляра класса из которого
// был вызван метод add)
        if (numLength <= digits.length) {
            for (int i = 0; i <= numLength - 1; i++) {
                digits[i] = (byte) (digits[i] + num.digits[i]);
// если при сложении цифр в одноименных разрядах массивов получаем число больше 9, производим перенос десятка от
// полученного числа на разряд выше, а остаток числа оставляем в разряде на котором находимся.
                if (digits[i] > 9) {
// перенос десятка с первого по предпоследнее значимое число
                    if (i < numLength - 1) {
                        digits[i] = (byte) (digits[i] % 10);
                        digits[i + 1] = (byte) (digits[i + 1] + 1);
                    }
// проверка возможности переноса десятка в следующий разряд для старшего (последнего значимого числа), если это
// позволяет длина меньшего массива
                     else if (i == numLength - 1 && digits.length > numLength) {
                        digits[i] = (byte) (digits[i] % 10);
                        digits[i + 1] = (byte) (digits[i + 1] + 1);
                    }
                }
            }
// если условие longNum <= ArrayLengthMin не выполняется обнуляем экземпляр класса из которого был вызван метод add и
// возвращаем false
        } else {
            ArrayInteger zero = new ArrayInteger(this.n);
            this.digits = zero.digits;
            return false;
        }
// при выполнении всех условий сложения выводим полученную сумму и возвращаем true
        return true;
    }

    //test
    public void printFromInt () {
        System.out.println(Arrays.toString(digits) + "\n");
    }

    public void printToInt() {
        System.out.println(this.toInt());
    }

    public static void main(String[] args) {
        System.out.println();
        System.out.println("Тест метода \"fromInt(BigInteger value)\"\n");
        ArrayInteger arrayInteger_4 = new ArrayInteger(8);
        arrayInteger_4.fromInt(new BigInteger("2345"));
        arrayInteger_4.printFromInt();
        ArrayInteger arrayInteger = new ArrayInteger(10);
        arrayInteger.fromInt(new BigInteger("92345677"));
        ArrayInteger arrayInteger_2 = new ArrayInteger(6);
        arrayInteger_2.fromInt(new BigInteger("189045"));
        arrayInteger_2.printFromInt();
        ArrayInteger arrayInteger_3 = new ArrayInteger(9);
        arrayInteger_3.fromInt(new BigInteger("2345543210"));
        System.out.println("*******************************************\n");

        System.out.println("Тест метода \"BigInteger toInt()\"\n");
        arrayInteger_4.printToInt();
        ArrayInteger zero = new ArrayInteger(8);
        zero.printToInt();
        arrayInteger = zero;
        arrayInteger.printToInt();
        System.out.println("*******************************************\n");

        System.out.println("Тест метода \"boolean add(ArrayInteger num)\"\n");
        System.out.println(arrayInteger_2.add(arrayInteger_4));
        System.out.println();
        System.out.println(arrayInteger_4.add(arrayInteger_2));
        ArrayInteger a = new ArrayInteger(3);
        ArrayInteger b = new ArrayInteger(8);
        a.fromInt(new BigInteger("234"));
        a.printToInt();
        b.fromInt(new BigInteger("8261"));
        b.printToInt();
        a.add(b);
        a.printToInt();
        System.out.println(a.add(b));
    }
}

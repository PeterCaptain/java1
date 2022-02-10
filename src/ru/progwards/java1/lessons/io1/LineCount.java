package ru.progwards.java1.lessons.io1;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class LineCount {

    public static int calcEmpty(String fileName) {
        int countEmpty = 0;

        try {
            FileReader fileReader = new FileReader(fileName);
            Scanner scanner = new Scanner(fileReader);
            try {
                while (scanner.hasNextLine()) {
                    String str = scanner.nextLine();
                    if (str.length() == 0) {
                        countEmpty++;
                    }
                }
            } finally {
                try {
                    fileReader.close();
                } catch (Throwable ignored) {

                }
                try {
                    scanner.close();
                } catch (Throwable ignore) {

                }
            }

        } catch (IOException e) {
            e.printStackTrace();
            return -1;
        }
        return countEmpty;
    }
}

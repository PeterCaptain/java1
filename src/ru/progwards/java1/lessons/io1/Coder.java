package ru.progwards.java1.lessons.io1;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Coder {

    public static void codeFile(String inFileName, String outFileName, char[] code, String logName) {
        try {
            FileReader fileReader = new FileReader(inFileName);
            FileWriter fileWriter = new FileWriter(outFileName);
            try {
                for (int symbol; (symbol = fileReader.read()) >= 0; ) {
                    fileWriter.write(code[symbol]);
                }
            } finally {
                try {
                    fileReader.close();
                } catch (Throwable ignored) {

                }
                try {
                    fileWriter.close();
                } catch (Throwable ignored) {

                }
            }

        } catch (IOException | IndexOutOfBoundsException e) {
            try {
                FileWriter logWriter = new FileWriter(logName);
                logWriter.write(e.getMessage());
                logWriter.close();
            } catch (Throwable ignored) {
            }
        }
    }
}

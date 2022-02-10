package ru.progwards.java1.lessons.io1;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CharFilter {

    public static void filterFile(String inFileName, String outFileName, String filter) throws IOException {
        FileReader fileReader = new FileReader(inFileName);
        FileWriter fileWriter = new FileWriter(outFileName);
        char[] stringFilter = filter.toCharArray();
        try {
            for (int ch; (ch = fileReader.read()) >= 0; ) {
                for (char c : stringFilter) {
                    if (ch != c - '0') {
                        fileWriter.write(ch);
                    }
                }
            }
        } finally {
            fileReader.close();
            fileWriter.close();
        }
    }
}

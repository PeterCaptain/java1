package ru.progwards.java1.lessons.io1;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CharFilter {

    public static void filterFile(String inFileName, String outFileName, String filter) throws IOException {
        FileReader fileReader = new FileReader(inFileName);
        FileReader filterReader = new FileReader(filter);
        FileWriter fileWriter = new FileWriter(outFileName);
        try {
            for (int ch; (ch = fileReader.read()) >= 0; ) {
                for (int fil; (fil = filterReader.read()) >= 0; ) {
                    if (ch != fil) {
                        fileWriter.write(ch);
                    }
                }
            }
        } finally {
            fileReader.close();
            filterReader.close();
            fileWriter.close();
        }
    }
}

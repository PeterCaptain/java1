package ru.progwards.java1.lessons.io1;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class CharFilter {

    public static void filterFile(String inFileName, String outFileName, String filter) throws IOException {
        FileReader fileReader = new FileReader(inFileName);
        FileWriter fileWriter = new FileWriter(outFileName);

        try {
            Scanner scanner = new Scanner(fileReader);
            String result = "";
            while (scanner.hasNextLine()) {
                String fileText = scanner.nextLine();
                for (int i = 0; i < fileText.length(); i++) {
                    String temp = String.valueOf(fileText.charAt(i));
                    for (int j = 0; j < filter.length(); j++) {
                        if (fileText.charAt(i) == filter.charAt(j)) {
                            temp = "";
                        }
                    }
                    result += temp;
                }
            }
            fileWriter.write(result);
            scanner.close();
        } catch (IOException e) {
           throw new IOException("Файл не найден");
        } finally {
            fileReader.close();
            fileWriter.close();
        }
    }
}

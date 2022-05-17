package ru.progwards.java1.lessons.sets;

import java.io.FileReader;
import java.io.IOException;
import java.util.Set;
import java.util.TreeSet;

public class LettersInFile {

    public static String process(String fileName) throws IOException {
        Set<Character> processSet = new TreeSet<>();
        FileReader fileReader = new FileReader(fileName);
        for (int ch; (ch = fileReader.read()) >= 0; ) {
            if (Character.isAlphabetic((char) ch)) {
                processSet.add((char) ch);
            }
        }
        fileReader.close();
        return toString(processSet);
    }


    public static String toString(Set<Character> characters) {
        StringBuilder strResult = new StringBuilder();
        for (Character ch : characters) {
            strResult.append(ch);
        }
        return strResult.toString();
    }
}

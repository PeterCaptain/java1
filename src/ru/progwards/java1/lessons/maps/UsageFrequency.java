package ru.progwards.java1.lessons.maps;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class UsageFrequency {
    private final StringBuilder textFile = new StringBuilder(); // здесь будет храниться загруженный файл

    public void processFile(String fileName) {
        File file = new File(fileName);
        try {
            Scanner sc = new Scanner(file);
            while (sc.hasNextLine()) {
                textFile.append(sc.nextLine());
            }
            sc.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Character> prepareListLetters(StringBuilder textFile) {
        String letters = textFile.toString().replaceAll("[^\\da-zA-Zа-яёА-ЯЁ]", ""); // фильтрую содержание файла, оставляя только буквы, цифры, без разделителей и преобразую к строке
        char[] result = letters.toCharArray(); // преобразую words в массив char

        List<Character> list = new ArrayList<>(); // создаю список list и заполняю его элементами char[] result
        for (char ch : result) {
            list.add(ch);
        }
        return list;
    }

    public Map<String, Integer> getLetters() {
        List<Character> listLettersAndDigits = prepareListLetters(textFile);
        HashSet<Character> setKeyOfLettersAndDigits = new HashSet<>(listLettersAndDigits); // создаю множество из listWordsAndDigits (определение ключей для map)
        HashMap<String, Integer> mapLettersAndDigits = new HashMap<>();

        for (Character ch : setKeyOfLettersAndDigits) { // создаю key и value и заполняю mapLettersAndDigits
            String key = String.valueOf(ch);
            int value = Collections.frequency(listLettersAndDigits, ch);
            mapLettersAndDigits.put(key, value);
        }
        return  mapLettersAndDigits;
    }

    public List<String> prepareListWords(StringBuilder textFile) { //
        String words = textFile.toString().replaceAll("[^\\da-zA-Zа-яёА-ЯЁ ]", " "); // преобразую к строке, оставляя только буквы, цифры и пробелы, так же пробелами заменяю все фильтруемые эл-ты.
        List<String> listWordsOfText = new ArrayList<>(List.of(words.split(" "))); // получаю коллекцию со списком слов и цифр, теперь разделителем явл-ся только пробел
        listWordsOfText.removeAll(Collections.singleton("")); //удаляю все пустые элементы коллекции
        return listWordsOfText;
    }

    public Map<String, Integer> getWords() {
        List<String> listWords = prepareListWords(textFile);
        Set<String> setKeyOfWords =(new HashSet<>(listWords)); //получаю множество setKeyOfWords из listWords (это будущие ключи для map)
        HashMap<String, Integer> mapWords = new HashMap<>();

        for (String key : setKeyOfWords) {
            int value = Collections.frequency(listWords, key); // определяю кол-во повторов в тексте
            mapWords.put(key, value); // заполняю mapWords
        }
        return mapWords;
    }
// test
    public static void main(String[] args) {
        UsageFrequency test = new UsageFrequency();
        test.processFile("src/ru/progwards/java1/lessons/maps/wiki.train.tokens");
        System.out.println(test.getWords());
        System.out.println(test.getLetters());

    }
}


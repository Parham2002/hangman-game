package org.example;

import java.util.ArrayList;
import java.util.Random;

public class HangmanUtils {
    static ArrayList<String> listOfWords = new ArrayList<>();

    public static String pickAWord(ArrayList<String> word) {
        Random random = new Random();
        String targetWord = word.get(random.nextInt(word.size()));
        return targetWord;
    }


    static {
        listOfWords.add("pizza");
        listOfWords.add("computer");
        listOfWords.add("soda");
        listOfWords.add("hamburger");
        listOfWords.add("sandwich");
        listOfWords.add("knowledge");

    }
    public static String wordToDashes(String targetWord) {
        String dashWord = "";
        for (int i = 0; i < targetWord.length(); i++) {
            dashWord += "_";
        }
        return dashWord;
    }
    public static boolean checkGuess(String guessLetter, String targetWord) {
        if (targetWord.contains(guessLetter)) {
            return true;
        }
        return false;
    }

}

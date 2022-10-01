package org.example;

import java.util.ArrayList;
import java.util.Random;

public class HangmanUtils {
    static ArrayList<String> listOfWords = new ArrayList<>();
    private static int lives = 3;

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
    public static String wordToDashes(String[] targetWord) {
        String dashWord = "";
        for (int i = 0; i < targetWord.length; i++) {
            dashWord += "_";
        }
        return dashWord;
    }
    public static boolean checkGuess(String guessLetter, String[] targetWord) {
        for ( String letter : targetWord) {
            if (letter.equals(guessLetter)) {
                return true;
            }
        }
        lives--;
        return false;

    }

    public static String updateDashWord(String guessLetter, String[] targetWord){
        String updatedDashWord = "";
        for (int i = 0; i < targetWord.length; i++) {
            if (targetWord[i].equals(guessLetter)) {
                updatedDashWord += guessLetter;
            }
            updatedDashWord += "_";
        }
        return updatedDashWord;
    }

    public static int getLives() {
        return lives;
    }
}

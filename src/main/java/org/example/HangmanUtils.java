package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

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

    public static void showDashWord(String[] dashWord) {
        for (String dash : dashWord) {
            System.out.print(dash);
        }
    }
    public static boolean checkGuess(String guessLetter, String[] targetWord) {
        for ( String letter : targetWord) {
            if (letter.equalsIgnoreCase(guessLetter)) {
                return true;
            }
        }
        lives--;
        return false;

    }

    public static String[] updateDashWord(String guessLetter, String[] targetWord, String[] dashWord){
        for (int i = 0; i < targetWord.length; i++) {

            if (targetWord[i].equalsIgnoreCase(guessLetter)) {
                dashWord[i] = targetWord[i];
            }
            System.out.print(dashWord[i]);

        }
        return dashWord;
    }

    public static boolean hasWon(String[] targetWord, String[] dashWord) {
        if (Arrays.equals(targetWord, dashWord)) {
            return true;
        }
        return false;
    }

    public static void tryAgain() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Would you like to try again? Y/N: ");
        String reply = scanner.nextLine();
        if (reply.equalsIgnoreCase("Y")) {
            System.out.print("Enter number of lives you would like to have: ");
            int tryAgainLives = scanner.nextInt();
            HangmanGame.hangManGame(HangmanUtils.setLives(tryAgainLives));
        } else if(reply.equalsIgnoreCase("N")) {
            System.out.println("You have quit the game.");
        } else {
            System.out.println("wrong input.");
            tryAgain();
        }
    }

    public static int getLives() {
        return lives;
    }

    public static int setLives(int lives) {
        HangmanUtils.lives = lives;
        return lives;
    }


}

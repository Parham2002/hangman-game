package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean gameStart = true;
        while(gameStart) {
            System.out.println("Welcome to Hangman!");
            String targetWord = HangmanUtils.pickAWord(HangmanUtils.listOfWords);
            String dashWord = HangmanUtils.wordToDashes(targetWord);
            System.out.println(dashWord);
            Scanner scanner = new Scanner(System.in);
            System.out.println("Please type a letter: ");
            String guessLetter = scanner.nextLine();
            System.out.println("You have guessed the letter: "+guessLetter);
            boolean isCorrect = HangmanUtils.checkGuess(guessLetter, targetWord);
            System.out.println(isCorrect);

            gameStart = false;

        }

    }
}
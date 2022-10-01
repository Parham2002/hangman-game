package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean gameStart = true;
        while(gameStart) {
            System.out.println("Welcome to Hangman!");
            String[] targetWord = HangmanUtils.pickAWord(HangmanUtils.listOfWords).split("");
            String dashWord = HangmanUtils.wordToDashes(targetWord);
            System.out.println(dashWord);
            Scanner scanner = new Scanner(System.in);
            if (HangmanUtils.getLives() > 0) {
                System.out.println("Lives left: " + HangmanUtils.getLives());
                System.out.println("Please type a letter: ");
                String guessLetter = scanner.nextLine();
                System.out.println("You have guessed the letter: " + guessLetter);
                boolean isCorrect = HangmanUtils.checkGuess(guessLetter, targetWord);
                System.out.println(isCorrect);
                String updatedDashWord = HangmanUtils.updateDashWord(guessLetter, targetWord);
                System.out.println(updatedDashWord);
            } else {
                System.out.println("You ran out of lives. Game over.");
                gameStart = false;
            }



        }

    }
}
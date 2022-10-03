package org.example;

import java.util.Scanner;

public class HangmanGame {
    public static void hangManGame(int lives) {
        HangmanUtils.setLives(lives);
        boolean gameStart = true;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Hangman!");
        String[] targetWord = HangmanUtils.pickAWord(HangmanUtils.listOfWords).split("");
        String[] dashWord = HangmanUtils.wordToDashes(targetWord).split("");
        System.out.println("------------");
        HangmanUtils.showDashWord(dashWord);
        System.out.println();
        System.out.println("------------");
        System.out.println();
        while(gameStart) {
            if (HangmanUtils.hasWon(targetWord, dashWord)) {
                System.out.println("You have won!");
                HangmanUtils.tryAgain();
                break;
            }
            if (HangmanUtils.getLives() > 0) {
                System.out.println("Lives left: " + HangmanUtils.getLives());
                System.out.print("Please type a letter: ");
                String guessLetter = scanner.nextLine();
                System.out.println("You have guessed the letter: " + guessLetter);
                boolean isCorrect = HangmanUtils.checkGuess(guessLetter, targetWord);
                System.out.println(isCorrect);
                System.out.println("------------");
                HangmanUtils.updateDashWord(guessLetter, targetWord, dashWord);
                System.out.println();
                System.out.println("------------");
                System.out.println();
            } else {
                System.out.println("You ran out of lives. Game over.");
                gameStart = false;
                HangmanUtils.tryAgain();
            }
        }
    }

}

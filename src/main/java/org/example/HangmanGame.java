package org.example;

import java.util.Scanner;

public class HangmanGame {

    private int lives;

    public HangmanGame(int lives) {
        this.lives = lives;
    }


    public static void hangManGame() {
        boolean gameStart = true;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Hangman!");
        String[] targetWord = HangmanUtils.pickAWord(HangmanUtils.listOfWords).split("");
        String dashWord = HangmanUtils.wordToDashes(targetWord);
        System.out.println(dashWord);
        while(gameStart) {
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
    public static void tryAgain() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Would you like to try again? Y/N");
        String reply = scanner.nextLine();
        if (reply.equalsIgnoreCase("Y")) {
            hangManGame();
        } else if(reply.equalsIgnoreCase("N")) {

        } else {
            System.out.println("wrong input.");
            tryAgain();
        }
    }

}

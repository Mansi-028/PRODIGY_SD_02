// Task 02 - Guessing Game (Console version)
// Prodigy InfoTech Software Development Internship
// Made by Mansi - B.Tech Student
//
// Program generates a random number between 1 and 100,
// asks the user to guess, gives "too high"/"too low" hints
// and shows the total attempts when they win.
//
// How to run:
//   javac GuessingGame.java
//   java GuessingGame

import java.util.Random;
import java.util.Scanner;

public class GuessingGame {

    // range of the secret number
    static final int MIN_NUM = 1;
    static final int MAX_NUM = 100;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        System.out.println("==============================================");
        System.out.println("       GUESSING GAME  -  Task 02 (Mansi)      ");
        System.out.println("==============================================");

        boolean playAgain = true;

        while (playAgain) {
            // pick a new random number for each game
            int target = rand.nextInt(MAX_NUM - MIN_NUM + 1) + MIN_NUM;
            int attempts = 0;
            boolean won = false;

            System.out.println("\nI picked a number between " + MIN_NUM + " and " + MAX_NUM + ".");
            System.out.println("Try to guess it!\n");

            while (!won) {
                System.out.print("Your guess: ");
                String input = sc.nextLine().trim();

                // basic input validation
                if (input.isEmpty()) {
                    System.out.println("Please enter something.");
                    continue;
                }

                int guess;
                try {
                    guess = Integer.parseInt(input);
                } catch (NumberFormatException e) {
                    System.out.println("That's not a valid whole number, try again.");
                    continue;
                }

                if (guess < MIN_NUM || guess > MAX_NUM) {
                    System.out.println("Number must be between " + MIN_NUM + " and " + MAX_NUM + ".");
                    continue;
                }

                attempts++;

                if (guess == target) {
                    System.out.println("Correct! You got it in " + attempts
                            + " attempt" + (attempts == 1 ? "" : "s") + ". 🎉");
                    won = true;
                } else if (guess < target) {
                    System.out.println("Too low! Try a bigger number.");
                } else {
                    System.out.println("Too high! Try a smaller number.");
                }
            }

            // ask if they wanna play again
            System.out.print("\nPlay again? (y/n): ");
            String again = sc.nextLine().trim().toLowerCase();
            playAgain = again.equals("y") || again.equals("yes");
        }

        System.out.println("\nThanks for playing! - Mansi");
        sc.close();
    }
}

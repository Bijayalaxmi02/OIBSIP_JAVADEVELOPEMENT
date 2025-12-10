import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        int score = 0;
        boolean playAgain = true;

        System.out.println("🎮 Welcome to the Number Guessing Game!");

        while (playAgain) {

            int numberToGuess = random.nextInt(100) + 1; // generates number 1-100
            int attempts = 0;
            int maxAttempts = 5;
            boolean guessedCorrect = false;

            System.out.println("\n🤔 I have selected a number between 1 and 100.");
            System.out.println("You have " + maxAttempts + " attempts!");

            while (attempts < maxAttempts) {
                System.out.print("\n➡ Enter your guess: ");
                int userGuess = sc.nextInt();
                attempts++;

                if (userGuess == numberToGuess) {
                    System.out.println("🎉 Correct! You guessed the number in " + attempts + " attempts.");

                    // Score logic
                    int points = (maxAttempts - attempts + 1) * 10;
                    score += points;
                    System.out.println("🏆 You earned " + points + " points!");
                    guessedCorrect = true;
                    break;
                } else if (userGuess > numberToGuess) {
                    System.out.println("⬇ Too high, try again!");
                } else {
                    System.out.println("⬆ Too low, try again!");
                }
            }

            if (!guessedCorrect) {
                System.out.println("\n❌ Out of attempts!");
                System.out.println("The correct number was: " + numberToGuess);
            }

            System.out.println("\n⭐ Your Total Score: " + score);

            System.out.print("\n🔁 Do you want to play again? (yes/no): ");
            String choice = sc.next().toLowerCase();

            if (!choice.equals("yes")) {
                playAgain = false;
            }
        }

        System.out.println("\n🎯 Game Over! Final Score: " + score);
        System.out.println("👋 Thanks for playing!");
        sc.close();
    }
}
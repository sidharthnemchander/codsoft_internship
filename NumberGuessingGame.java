import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Random random = new Random();
        int randomNumber = random.nextInt(100)+1;

        int userGuess;
        int attempts = 0;

        Scanner scanner = new Scanner(System.in);
        System.out.println();
        System.out.println();
        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("Try to guess the number between 1 and 100.");

        do {
            System.out.print("Enter your guess: ");
            userGuess = scanner.nextInt();

            attempts++;

            if (userGuess == randomNumber) {
                System.out.println("Congratulations! You guessed the correct number in " + attempts + " attempts.");
            } else if (Math.abs(userGuess - randomNumber) <= 15) {
                if (userGuess < randomNumber) {
                    System.out.println("A little low! Try again.");
                } else {
                    System.out.println("A little high! Try again.");
                }
            } else if (userGuess < randomNumber) {
                System.out.println("Too low! Try again.");
            } else {
                System.out.println("Too high! Try again.");
            }
        } while (userGuess != randomNumber);
        scanner.close();
    }
}

import java.util.Random;
import java.util.Scanner;

public class GuessingNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int minRange = 1;
        int maxRange = 100;
        int attemptsLimit = 5;
        int score = 0;

        boolean playAgain = true;
        while (playAgain) {
            int randomNumber = random.nextInt(maxRange - minRange + 1) + minRange;
            System.out.println("Welcome to Guess the Number Game!");
            System.out.println("I have selected a number between " + minRange + " and " + maxRange + ". Can you guess it?");
            int attempts = 0;
            int guess = 0;
            while (guess != randomNumber && attempts < attemptsLimit) {
                System.out.print("Enter your guess: ");
                guess = scanner.nextInt();
                attempts++;
                if (guess == randomNumber) {
                    System.out.println("Congratulations! You guessed the correct number in " + attempts + " attempts.");
                    score++;
                } else if (guess < randomNumber) {
                    System.out.println("Too low! Try again.");
                } else {
                    System.out.println("Too high! Try again.");
                }
            }
            if (guess != randomNumber) {
                System.out.println("Sorry, you've reached the maximum number of attempts. The correct number was: " + randomNumber);
            }

            System.out.print("Your score: " + score + "\nWould you like to play again? (yes/no): ");
            String playAgainResponse = scanner.next();
            if (!playAgainResponse.equalsIgnoreCase("yes")) {
                playAgain = false;
            }
        }
        System.out.println("Thank you for playing Guess the Number!");
    }
}
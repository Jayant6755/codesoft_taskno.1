import java.util.Scanner;
import java.util.Random;

public class numbergame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int maxAttempts = 10;
        boolean playAgain = true;
        int totalRounds = 0;
        int totalScore = 0;

        while (playAgain) {
            int randomNumber = random.nextInt(100) + 1;
            int attempts = 0;
            boolean correctGuess = false;

            System.out.println("Guess the number between 1 and 100.");

            while (attempts < maxAttempts && !correctGuess) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();
                attempts++;

                if (userGuess == randomNumber) {
                    System.out.println("Congratulations! You guessed the correct number.");
                    correctGuess = true;
                } else if (userGuess > randomNumber) {
                    System.out.println("Your guess is too high.");
                } else {
                    System.out.println("Your guess is too low.");
                }
            }

            if (!correctGuess) {
                System.out.println("You've used all your attempts. The correct number was: " + randomNumber);
            }

            totalRounds++;
            totalScore += (correctGuess ? maxAttempts - attempts + 1 : 0);

            System.out.println("Do you want to play again? (yes/no)");
            playAgain = scanner.next().equalsIgnoreCase("yes");
        }

        System.out.println("Game Over. You played " + totalRounds + " rounds.");
        System.out.println("Your total score is: " + totalScore);
        scanner.close();
    }
}
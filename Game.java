import java.util.Scanner;

public class Game {
    private String secretWord;
    private char[] currentGuess;
    private int maxAttempts;
    private int attemptsLeft;

    public Game(String word, int maxAttempts) {
        this.secretWord = word.toLowerCase();
        this.maxAttempts = maxAttempts;
        this.attemptsLeft = maxAttempts;
        this.currentGuess = new char[secretWord.length()];

        for (int i = 0; i < currentGuess.length; i++) {
            currentGuess[i] = '_';
        }
    }

    public void play() {
        Scanner scanner = new Scanner(System.in);

        while (attemptsLeft > 0 && !isWordGuessed()) {
            System.out.println("InCurrent: " + getCurrentGuess());
            System.out.println("Attempts left: " + attemptsLeft);
            System.out.print("Enter a letter: ");

            char guess = scanner.nextLine().toLowerCase().charAt(0);

            if (processGuess(guess)) {
                System.out.println("Correct:)");
            } else {
                System.out.println("Incorrect:(");
                attemptsLeft--;
            }
        }

        if (isWordGuessed()) {
            System.out.println("Congratulations! You guessed the word: "
                    + secretWord + " ^_^");
        } else {
            System.out.println("Game over! The word was: "
                    + secretWord + " -_-");
        }

        scanner.close();
    }

    private boolean processGuess(char guess) {
        boolean correct = false;

        for (int i = 0; i < secretWord.length(); i++) {
            if (secretWord.charAt(i) == guess && currentGuess[i] == '_') {
                currentGuess[i] = guess;
                correct = true;
            }
        }

        return correct;
    }

    private boolean isWordGuessed() {
        return secretWord.equals(new String(currentGuess));
    }

    private String getCurrentGuess() {
        StringBuilder sb = new StringBuilder();

        for (char c : currentGuess) {
            sb.append(c).append(' ');
        }

        return sb.toString().trim();
    }
}
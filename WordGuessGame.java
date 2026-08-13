public class WordGuessGame {
    public static void main(String[] args) {
        WordBank wordBank = new WordBank();
        String randomWord = wordBank.getRandomWord();

        Game game = new Game(randomWord, randomWord.length() + 1);

        game.play();
    }
}
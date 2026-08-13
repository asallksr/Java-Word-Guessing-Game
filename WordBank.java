import java.util.ArrayList;
import java.util.Random;

public class WordBank {
    private ArrayList<String> wordList;

    public WordBank() {
        wordList = new ArrayList<>();

        wordList.add("computer");
        wordList.add("program");
        wordList.add("keyboard");
        wordList.add("notebook");
        wordList.add("project");
        wordList.add("debug");
    }

    public String getRandomWord() {
        Random random = new Random();
        int index = random.nextInt(wordList.size());

        return wordList.get(index);
    }
}
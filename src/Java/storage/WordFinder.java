package storage;

import java.util.ArrayList;
import java.util.List;

public interface WordFinder {
    void getWords(ArrayList<String> wordList);

    List<Character> charactersToInclude();
}

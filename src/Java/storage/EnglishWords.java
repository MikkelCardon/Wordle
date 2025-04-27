package storage;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EnglishWords implements WordFinder{
    @Override
    public void getWords(ArrayList<String> wordList) {
        File file = new File("src/Java/storage/5letterWords");

        try {
            Scanner input = new Scanner(file);

            while(input.hasNext()){
                wordList.add(input.next());
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Character> charactersToInclude() {
        return List.of();
    }
}

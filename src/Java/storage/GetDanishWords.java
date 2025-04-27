package storage;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GetDanishWords implements WordFinder{
    @Override
    public void getWords(ArrayList<String> words) {
        File file = new File("src/Java/storage/DanishWords");
        try {
            Scanner input = new Scanner(file);

            while(input.hasNext()){
                String[] stringInput = input.next().split(",");
                String word = stringInput[0];

                if (word.length() == 5){
                    words.add(word.toUpperCase());
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Character> charactersToInclude() {
        return List.of('Æ', 'Ø', 'Å');
    }
}

package storage;

import gui.customElement.Block;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Storage {
    private static HashMap<Integer, Block> blocks = new HashMap<>();
    private static ArrayList<String> words = new ArrayList<>();

    public static HashMap<Integer,Block> getBlocks() {
        return blocks;
    }

    public static void addBlock(Block block){
        blocks.put(block.getBlockID(), block);
        System.out.println(block);
    }

    public static Block returnBlockByID(int id){
        return blocks.get(id);
    }


    public static String getRandomWord() {
        Random random = new Random();
        return words.get(random.nextInt(words.size()));
    }

    public static void initWords() {
        try {
            Scanner scanner = new Scanner(new File("src/Java/storage/5letterWords"));
            while (scanner.hasNext()){
                words.add(scanner.next().toUpperCase());
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static ArrayList<String> getWords() {
        return words;
    }
}

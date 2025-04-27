package storage;

import gui.customElement.Block;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Storage {
    private static HashMap<Integer, Block> blocks = new HashMap<>();
    private static ArrayList<String> words = new ArrayList<>();
    private static WordFinder wordFinder = new GetDanishWords();

    public static HashMap<Integer,Block> getBlocks() {
        return blocks;
    }

    public static void addBlock(Block block){
        blocks.put(block.getBlockID(), block);
        //System.out.println(block);
    }

    public static Block returnBlockByID(int id){
        return blocks.get(id);
    }


    public static String getRandomWord() {
        Random random = new Random();
        return words.get(random.nextInt(words.size()));
    }

    public static void initWords() {
            wordFinder.getWords(words);
    }

    public static ArrayList<String> getWords() {
        return words;
    }
}

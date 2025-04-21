package storage;

import gui.cutomElement.Block;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Storage {
    private static HashMap<Integer, Block> blocks = new HashMap<>();

    public static HashMap<Integer,Block> getBlocks() {
        return blocks;
    }

    public static Block returnBlockByID(int id){
        return blocks.get(id);
    }


}

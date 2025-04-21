package controller;

import gui.cutomElement.Block;
import storage.Storage;

import java.util.ArrayList;

public class Controller {
    private int blockID;
    private String wordToGuess;

    public Controller() {
        blockID = 1;
        wordToGuess = Storage.getRandomWord();
    }

    public void keyPressed(){
        Block block = Storage.returnBlockByID(blockID);
        if(checkValidInput()){
            block.setText(block.getText().toUpperCase());
        }else{
            block.clear();
            return;
        }


        if (blockID % 5 == 0){
            lastCellInRow();
            nextCell();
        }else{
            nextCell();
        }
    }

    private static boolean checkValidInput() {
        String text = Storage.returnBlockByID(blockID).getText();

        if (text == null || text.length() != 1) {
            return false;
        }

        char input = text.charAt(0);

        return Character.isLetter(input);
    }

    private void lastCellInRow() {
        int wordToGuessIndex = 0;

        for (int index = blockID-4; index <= blockID; index++) {
            Block block = Storage.returnBlockByID(index);
            char text = block.getText().toCharArray()[0];

            if (wordToGuess.charAt(wordToGuessIndex++) == text){
                block.correctPosition();
            }else if (wordToGuess.contains(block.getText())){
                block.doesContainLetter();
            }else{
                block.doesNotContainLetter();
            }
        }

        if (blockID >= 30){
            new GameOutput(getCurrentRow(), true);
        }
    }

    private static void nextCell() {
        Block block = Storage.returnBlockByID(++blockID);
        block.requestFocus();
    }

    public String getWordToGuess() {
        return wordToGuess;
    }

    public ArrayList<Block> getCurrentRow(){
        ArrayList<Block> currentRow = new ArrayList<>();

        for (int index = blockID-4; index <= blockID; index++) {
            currentRow.add(Storage.returnBlockByID(index));
        }
        return currentRow;
    }
}

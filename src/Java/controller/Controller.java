package controller;

import gui.cutomElement.Block;
import javafx.event.Event;
import storage.Storage;

public class Controller {
    private static int blockID = 1;
    private static String wordToGuess = "HELLO";

    public static void keyPressed(){
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

    private static void lastCellInRow() {
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
            nextCell();
        }
    }

    private static void nextCell() {
        Block block = Storage.returnBlockByID(++blockID);
        block.requestFocus();
    }
}

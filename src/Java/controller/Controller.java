package controller;

import gui.GameElements;
import gui.customElement.Block;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.StackPane;
import storage.Storage;

public class Controller {
    private int blockID = 0;
    private String wordToGuess;
    private StackPane stackPane;

    public Controller(StackPane stackPane) {
        this.stackPane = stackPane;
    }

    public void newGame(){
        stackPane.getChildren().clear();
        blockID = 0;
        Block.resetCount();
        Storage.getBlocks().clear();
        wordToGuess = Storage.getRandomWord();
        new GameElements(this);

        nextCell();
        System.out.println("New game:" + wordToGuess);
    }

    public void keyPressed(KeyCode keyCode, String input){
        if (keyCode == KeyCode.BACK_SPACE){
            previousCell();
            return;
        }

        Block block = Storage.returnBlockByID(blockID);
        if (!block.getText().isEmpty()){
            return;
        }

        if(checkValidInput(input)){
            block.setText(input.toUpperCase());
        }else{
            block.clear();
            return;
        }


        if (blockID % 5 == 0){
            lastCellInRow();
        }else{
            nextCell();
        }
    }

    private boolean checkValidInput(String text) {

        if (text == null || text.length() != 1) {
            return false;
        }

        char input = text.charAt(0);

        return Character.isLetter(input) || Storage.getWordFinder().charactersToInclude().contains(input);
    }

    private void lastCellInRow() {
        if (!Storage.getWords().contains(gussedWord())){
            System.out.println("WORD NOT FOUND");
            return;
        }

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
            new GameOutput(gussedWord(), true, wordToGuess);
        }else {
            new GameOutput(gussedWord(), false, wordToGuess);
            nextCell();
        }
    }

    private void nextCell() {
        Block block = Storage.returnBlockByID(++blockID);
        block.requestFocus();
    }

    private void previousCell() {
        if ((blockID-1) % 5 == 0){ //Kan ikke gå tilbage efter man har afsluttet en række
            return;
        }
        Block block = Storage.returnBlockByID(blockID);
        if (block.getText().isEmpty()){
            block = Storage.returnBlockByID(--blockID);;
        }

        block.clear();
        block.requestFocus();
    }

    public String getWordToGuess() {
        return wordToGuess;
    }

    public String gussedWord(){
        String text = "";

        for (int index = blockID-4; index <= blockID; index++) {
            text += Storage.returnBlockByID(index).getText();
        }
        return text;
    }
}

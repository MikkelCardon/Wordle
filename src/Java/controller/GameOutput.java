package controller;

import gui.cutomElement.Block;
import javafx.scene.control.Alert;

import java.util.ArrayList;

public class GameOutput {
    private ArrayList<Block> row = new ArrayList<>();

    public GameOutput(ArrayList<Block> row, boolean isLastRow) {
        this.row = row;

        isGameWon();

        if (isLastRow){
            isGameLost();
        }
    }

    public void isGameWon(){
        StringBuilder rowWord = new StringBuilder();
        for (Block block : row) {
            rowWord.append(block.getText());
        }

        if (rowWord.equals(Controller.getWordToGuess())){

        }
    }

    public void isGameLost(){

    }
}

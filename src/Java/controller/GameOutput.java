package controller;

import gui.cutomElement.Block;
import javafx.scene.control.Alert;

import java.util.ArrayList;

public class GameOutput {
    private String gussedWord;
    private String wordToGuess;

    public GameOutput(String gussedWord, boolean isLastRow, String wordToGuess) {
        this.gussedWord = gussedWord;
        this.wordToGuess = wordToGuess;

        isGameWon();

        if (isLastRow){
            isGameLost();
        }
    }

    public void isGameWon(){
        if (gussedWord.equals(wordToGuess)){
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("YOU WON");
            System.out.println("You won");
        }
    }

    public void isGameLost(){
        System.out.println("You lost");
    }
}

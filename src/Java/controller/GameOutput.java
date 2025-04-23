package controller;

import gui.customElement.LosePopUp;
import gui.customElement.WinPopUp;

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
            new WinPopUp();
            System.out.println("You won");
        }
    }

    public void isGameLost(){
        new LosePopUp();
        System.out.println("You lost");
    }
}

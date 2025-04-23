package gui.customElement;

import gui.PrimaryWindow;

public class LosePopUp extends PopUp{
    public LosePopUp() {
        super("You Lost", "The word was: " + PrimaryWindow.getController().getWordToGuess());
    }
}

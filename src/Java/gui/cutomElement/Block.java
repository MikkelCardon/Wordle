package gui.cutomElement;

import javafx.scene.control.TextField;
import storage.Storage;

public class Block extends TextField {
    private final int size = 50;

    public Block() {
        this.setMinSize(size, size);
        this.setMaxSize(size, size);
        this.setStyle("-fx-border-color: black; -fx-border-width: 1.5;");
        Storage.getBlocks().add(this);
    }

    public void doesNotContainLetter(){
        this.setStyle("-fx-border-color: red; -fx-border-width: 1.5;");
    }

    public void doesContainLetter(){
        this.setStyle("-fx-border-color: yellow; -fx-border-width: 1.5;");
    }

    public void correctPosition(){
        this.setStyle("-fx-border-color: green; -fx-border-width: 1.5;");
    }


}

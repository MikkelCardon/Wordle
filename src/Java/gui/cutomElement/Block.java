package gui.cutomElement;

import javafx.scene.control.TextField;

public class Block extends TextField {
    public Block() {
        this.setMinSize(25, 25);
        this.setMaxSize(25, 25);
        this.setStyle("-fx-border-color: black; -fx-border-width: 2;");
    }
}

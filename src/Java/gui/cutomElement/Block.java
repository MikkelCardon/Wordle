package gui.cutomElement;

import javafx.geometry.Pos;
import javafx.scene.control.TextField;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import storage.Storage;

public class Block extends TextField {
    private final int size = 50;
    private static int count = 1;
    private int id;

    public Block() {
        this.setMinSize(size, size);
        this.setMaxSize(size, size);
        this.setStyle("-fx-border-color: black; -fx-border-width: 1.5;");
        this.setAlignment(Pos.CENTER);
        this.setFont(Font.font("System", FontWeight.BOLD, 16));

        this.setEditable(false);
        this.setFocusTraversable(false);

        id = count++;
        Storage.addBlock(this);
    }

    public void doesNotContainLetter(){
        //this.setStyle("-fx-border-color: red; -fx-border-width: 1.5;");
        this.setStyle("-fx-background-color: red; -fx-text-fill: white; -fx-font-weight: bold;");

    }

    public void doesContainLetter(){
        //this.setStyle("-fx-border-color: orange; -fx-border-width: 1.5;");
        this.setStyle("-fx-background-color: orange; -fx-text-fill: white; -fx-font-weight: bold;");
    }

    public void correctPosition(){
        //this.setStyle("-fx-border-color: green; -fx-border-width: 1.5;");
        this.setStyle("-fx-background-color: green; -fx-text-fill: white; -fx-font-weight: bold;");
    }

    public int getBlockID() {
        return id;
    }

    @Override
    public String toString() {
        return "Block{" +
                "id=" + id +
                '}';
    }


}

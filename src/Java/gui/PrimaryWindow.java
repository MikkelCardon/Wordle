package gui;

import controller.Controller;
import gui.cutomElement.Block;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;


public class PrimaryWindow extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Wordle by Cardon");
        VBox root = new VBox();
        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(15));
        initLayout(root);
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    private void initLayout(VBox root) {
        root.setOnKeyReleased(event -> Controller.keyPressed());

        Label titel = new Label("WORDLE by Cardon");
        titel.setFont(Font.font("Impact", FontWeight.BOLD, 24));

        root.getChildren().add(titel);

        initTextFields(root);
    }

    private void initTextFields(VBox root){
        GridPane boxGridPane = new GridPane();
        boxGridPane.setVgap(5);
        boxGridPane.setHgap(5);

        for (int outer = 0; outer < 6; outer++) {
            for (int inner = 0; inner < 5; inner++) {
                boxGridPane.add(new Block(), inner, outer+1);
            }
        }
        root.getChildren().add(boxGridPane);
    }


}

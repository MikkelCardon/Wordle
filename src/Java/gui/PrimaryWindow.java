package gui;

import controller.Controller;
import gui.cutomElement.Block;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class PrimaryWindow extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Wordle by Cardon");
        GridPane gridPane = new GridPane();
        initLayout(gridPane);
        Scene scene = new Scene(gridPane);
        stage.setScene(scene);
        stage.show();
    }

    private void initLayout(GridPane gridPane) {
        gridPane.setHgap(10);
        gridPane.setVgap(10);

        gridPane.setOnKeyReleased(event -> Controller.keyPressed(event));

        initTextFields(gridPane);
    }

    private void initTextFields(GridPane gridPane){
        for (int outer = 0; outer < 6; outer++) {
            for (int inner = 0; inner < 5; inner++) {
                gridPane.add(new Block(), inner, outer+1);
            }
        }
    }


}

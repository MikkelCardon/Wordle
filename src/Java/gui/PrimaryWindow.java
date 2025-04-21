package gui;

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

        initTextFields(gridPane);
    }

    private void initTextFields(GridPane gridPane){
        gridPane.add(new Block(), 0, 0);
    }
}

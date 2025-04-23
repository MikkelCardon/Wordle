package gui;

import controller.Controller;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


public class PrimaryWindow extends Application {
    private static StackPane stackPane = new StackPane();
    private static Controller controller;

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Wordle by Cardon");
        Scene scene = new Scene(stackPane);
        controller = new Controller(stackPane);
        controller.newGame();

        scene.getStylesheets().add(getClass().getResource("customElement/styles.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
    }

    public static StackPane getStackPane(){
        return stackPane;
    }

    public static Controller getController(){
        return controller;
    }


}

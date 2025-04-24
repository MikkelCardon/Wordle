package gui.customElement;

import gui.PrimaryWindow;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

public class PopUp extends GridPane {
    private String titel;
    private String message;

    public PopUp(String titel, String message) {
        super();
        this.setHgap(15);
        this.setVgap(15);
        this.setMaxSize(200, 100);
        this.titel = titel;
        this.message = message;
        styling();
        showPopUp();
    }

    private void styling() {
        this.setAlignment(Pos.CENTER);
        this.getStyleClass().add("popup-gridpane");
        //this.setBackground(Background.fill(Color.GRAY));

        Label titelLabel = new Label(titel);
        titelLabel.setStyle("-fx-font-size: 28px; -fx-font-weight: bold; -fx-text-fill: #2c3e50;");

        Label messageLabel = new Label(message);
        messageLabel.setStyle("-fx-font-size: 16px; -fx-text-fill: #555;");

        Button newGameButton = new Button("New Game");
        newGameButton.setOnAction(event -> PrimaryWindow.getController().newGame());

        this.add(titelLabel, 0, 0);
        this.add(messageLabel, 0, 1);
        this.add(newGameButton, 0, 2);
    }

    private void showPopUp() {
        PrimaryWindow.getStackPane().getChildren().add(this);
    }
}

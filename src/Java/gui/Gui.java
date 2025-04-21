package gui;

import javafx.application.Application;
import storage.Storage;

public class Gui {
    public static void main(String[] args) {
        Storage.initWords();

        Application.launch(PrimaryWindow.class);

    }
}

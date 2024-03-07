package org.openjfx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import org.openjfx.layouts.MenuPane;

import static org.openjfx.utils.PathUtil.getFilePath;

/**
 * This class on JDK with built in JAVA_FX (Java 8, 9)
 */
public class MainApp extends Application {

    @Override
    public void start(Stage stage) {
        MenuPane pane = new MenuPane().setup(stage);
        Scene scene = new Scene(pane);

        stage.setTitle("Java Solitaire");
        stage.setScene(scene);
        stage.getIcons().add(new Image(getFilePath("cards", "hearts/1.png")));
        stage.setResizable(false);
        stage.setMaximized(false);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
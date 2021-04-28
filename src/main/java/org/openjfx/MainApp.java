package org.openjfx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import org.openjfx.game.Game;
import org.openjfx.game.Pane;

import java.io.File;

public class MainApp extends Application {

    private static final Media media = new Media(new File("src/assets/jazz.mp3").toURI().toString());
    private static final MediaPlayer player = new MediaPlayer(media);

    @Override
    public void start(Stage stage) {
        final Pane pane = new Game().setup();
        Scene scene = new Scene(pane);

        stage.setTitle("Java Solitaire");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.setMaximized(false);
        stage.show();

        player.setVolume(0.1);
        player.setAutoPlay(true);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
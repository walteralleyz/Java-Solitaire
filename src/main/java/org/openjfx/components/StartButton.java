package org.openjfx.components;

import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import javafx.util.Duration;
import org.openjfx.layouts.Pane;

import static org.openjfx.enums.Dir.ICONS;
import static org.openjfx.enums.Dir.SOUNDS;
import static org.openjfx.utils.PathUtil.getFilePath;

public class StartButton {
    private final Stage stage;

    public StartButton(Stage stage) {
        this.stage = stage;
    }

    public ImageView setup() {
        Media effect = new Media(getFilePath(SOUNDS.dir, "start_button_effect.mp3"));
        MediaPlayer player = new MediaPlayer(effect);
        Image image = new Image(getFilePath(ICONS.dir, "start_button.png"));
        ImageView button = new ImageView(image);

        button.setOnMouseClicked(event -> {
            Pane pane = new Game().setup();
            Scene scene = new Scene(pane);

            player.play();
            player.seek(Duration.ZERO);
            button.setStyle("-fx-opacity: 0.8");
            stage.setScene(scene);
        });

        return button;
    }
}

package org.openjfx.game;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;
import org.openjfx.enums.Dir;

import java.io.File;

import static org.openjfx.enums.Dir.*;
import static org.openjfx.utils.Path.getFilePath;

public class MusicPlayer {
    private final Media media = new Media(new File(getFilePath(SOUNDS.dir, "jazz.mp3")).toURI().toString());
    private final MediaPlayer player = new MediaPlayer(media);
    private boolean isPlaying = true;

    public ImageView setup() {
        Image image = new Image(new File(getFilePath(ICONS.dir, "note.png")).toURI().toString());
        ImageView speaker = new ImageView(image);

        speaker.setFitWidth(25);
        speaker.setFitHeight(30);

        speaker.setOnMouseClicked(event -> {
            if(isPlaying) {
                isPlaying = false;
                player.setVolume(0.0);
                speaker.setStyle("-fx-opacity: 0.3;");
            }
            else {
                isPlaying = true;
                player.setVolume(1);
                speaker.setStyle("-fx-opacity: 1");
            }
        });

        player.setAutoPlay(true);
        player.setOnEndOfMedia(() -> {
            player.seek(Duration.ZERO);
            player.play();
        });

        return speaker;
    }
}

package org.openjfx.components;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

import static org.openjfx.enums.Dir.ICONS;
import static org.openjfx.enums.Dir.SOUNDS;
import static org.openjfx.utils.PathUtil.getFilePath;

public class MusicPlayer {
    private final Media media = new Media(getFilePath(SOUNDS.dir, "jazz.mp3"));
    private final MediaPlayer player = new MediaPlayer(media);
    private boolean isPlaying = true;

    public ImageView setup() {
        Image image = new Image(getFilePath(ICONS.dir, "note.png"));
        ImageView speaker = new ImageView(image);

        speaker.setFitWidth(25);
        speaker.setFitHeight(30);

        speaker.setOnMouseClicked(event -> {
            if (isPlaying) {
                isPlaying = false;
                player.pause();
                speaker.setStyle("-fx-opacity: 0.3;");
            } else {
                isPlaying = true;
                player.play();
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

    public void stop() {
        player.stop();
    }
}

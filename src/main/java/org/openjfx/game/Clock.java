package org.openjfx.game;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.util.Duration;
import org.openjfx.enums.ColumnWidth;

import static org.openjfx.utils.Pad.padLeftZeros;
import static org.openjfx.utils.Path.loadFont;

public class Clock {
    public static Text text = new Text();
    private int seconds = 0;
    private Timeline clock;

    public Group setup() {
        Font font = loadFont();

        text.setFont(font);
        text.setFill(Color.WHITE);
        text.setWrappingWidth(ColumnWidth.MIDDLE.width);

        return new Group(text);
    }

    @FXML
    public void initialize() {
        clock = new Timeline(new KeyFrame(Duration.ZERO, e -> {
            text.setText(String.format("Time %s", calcTime(seconds)));
            seconds++;
        }),
            new KeyFrame(Duration.seconds(1))
        );
        clock.setCycleCount(Animation.INDEFINITE);
        clock.play();
    }

    public void stop() {
        clock.stop();
    }

    public String calcTime(int seconds) {
        String time;

        if(seconds > 59) time = String.format(
            "%s %s",
            seconds / 60,
            padLeftZeros(Integer.toString(seconds % 60), 2)
        );

        else
            time = "0 " + padLeftZeros(Integer.toString(seconds), 2);

        return time;
    }
}

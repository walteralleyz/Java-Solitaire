package org.openjfx.components;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import org.openjfx.enums.ColumnWidth;
import org.openjfx.enums.Dir;

import java.io.File;

import static org.openjfx.utils.Path.getFilePath;
import static org.openjfx.utils.Path.loadFont;

public class Attempts {
    private static Attempts instance;
    private int life = 5;

    private Attempts() {}

    public static void tookDamage() {
        if(instance.life > 0) --instance.life;
    }

    public static Text attemptText() {
        if(instance == null) instance = new Attempts();

        Font font = loadFont(40);
        Text text = new Text("try " + instance.life);

        text.setFont(font);
        text.setFill(Color.WHITE);
        text.setWrappingWidth(ColumnWidth.FIRST.width);

        return text;
    }

    public static boolean isAlive() {
        return instance.life >= 1;
    }

    public static Text gameOverText() {
        Font font = loadFont(40);
        Text text = new Text("Game Over");

        text.setFont(font);
        text.setFill(Color.WHITE);
        text.setWrappingWidth(ColumnWidth.MIDDLE.width);

        return text;
    }

    public static Text winnerText(Color color) {
        Media effect = new Media(new File(getFilePath(Dir.SOUNDS.dir, "win.mp3")).toURI().toString());
        MediaPlayer player = new MediaPlayer(effect);
        Font font = loadFont(74);
        Text text = new Text("You Win");

        text.setFont(font);
        text.setFill(color);

        player.setAutoPlay(true);

        return text;
    }
}

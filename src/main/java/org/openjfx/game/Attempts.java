package org.openjfx.game;

import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import org.openjfx.enums.ColumnWidth;

import static org.openjfx.utils.Path.loadFont;

public class Attempts {
    private static Attempts instance;
    private int life = 3;

    private Attempts() {}

    public static void tookDamage() {
        if(instance.life > 0) --instance.life;
    }

    public static Text attemptText() {
        if(instance == null) instance = new Attempts();

        Font font = loadFont();
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
        Font font = loadFont();
        Text text = new Text("Game Over");

        text.setFont(font);
        text.setFill(Color.WHITE);
        text.setWrappingWidth(ColumnWidth.MIDDLE.width);

        return text;
    }

    public static Text winnerText() {
        Font font = loadFont();
        Text text = new Text("You Win");

        text.setFont(font);
        text.setFill(Color.WHITE);
        text.setWrappingWidth(ColumnWidth.MIDDLE.width);

        return text;
    }
}

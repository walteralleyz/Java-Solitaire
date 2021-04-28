package org.openjfx.game;

import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import org.openjfx.enums.ColumnWidth;

import static javafx.scene.text.FontPosture.REGULAR;
import static javafx.scene.text.FontWeight.BOLD;

public class Attempts {
    private static Attempts instance;
    private int life = 3;

    private Attempts() {}

    public static void tookDamage() {
        if(instance.life > 0) --instance.life;
    }

    public static Text attemptText() {
        if(instance == null) instance = new Attempts();

        String symbol = Character.toString('\u2665');
        Text text = new Text(String.format("%s%d", symbol, instance.life));

        text.setFont(Font.font("verdana", BOLD, REGULAR, 24));
        text.setFill(Color.WHITE);
        text.setWrappingWidth(ColumnWidth.FIRST.width);

        return text;
    }

    public static boolean isAlive() {
        return instance.life > 1;
    }

    public static Text gameOverText() {
        Text text = new Text("Game Over!");

        text.setFont(Font.font("verdana", BOLD, REGULAR, 24));
        text.setFill(Color.WHITE);
        text.setWrappingWidth(ColumnWidth.FIRST.width);

        return text;
    }
}

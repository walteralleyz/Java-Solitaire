package org.openjfx.components;

import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import static org.openjfx.utils.Path.loadFont;

public class Moves {
    private int moves = 0;
    private Text text;

    public Text setup() {
        Font font = loadFont(40);
        text = new Text();

        text.setFont(font);
        text.setText(String.format("Moves %d", moves));
        text.setFill(Color.WHITE);

        return text;
    }

    public void incrementMoves() {
        text.setText(String.format("Moves %d", ++moves));
    }
}

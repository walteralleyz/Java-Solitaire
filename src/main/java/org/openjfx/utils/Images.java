package org.openjfx.utils;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import org.openjfx.enums.ColumnWidth;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Images {
    public static ImageView createCardImage(String type, int number, double scale) {
        String url = String.format("src/%s/%s/%d.png", Dir.ASSETS, type, number);

        try {
            FileInputStream inputStream = new FileInputStream(url);
            Image image = new Image(inputStream);
            ImageView view = new ImageView(image);

            view.setFitHeight(92 * scale);
            view.setFitWidth((ColumnWidth.BOTH.width / 13d) * scale);

            return view;
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Image not found!");
        }
    }
}

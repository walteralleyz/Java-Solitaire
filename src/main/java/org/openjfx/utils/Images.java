package org.openjfx.utils;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import org.openjfx.enums.ColumnWidth;

public class Images {
    public static ImageView createCardImage(String type, int number, double scale) {
        String url = PathUtil.getFilePath("cards", type + '/' + number + ".png");
        Image image = new Image(url);
        ImageView view = new ImageView(image);

        view.setFitHeight(92 * scale);
        view.setFitWidth((ColumnWidth.BOTH.width / 13d) * scale);

        return view;
    }
}

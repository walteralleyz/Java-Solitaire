package org.openjfx.layouts;

import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import org.openjfx.components.StartButton;
import org.openjfx.enums.ColumnWidth;

import java.io.File;

import static org.openjfx.enums.Dir.*;
import static org.openjfx.utils.Path.getFilePath;

public class MenuPane extends GridPane {

    public MenuPane setup(Stage stage) {
        MenuPane menu = new MenuPane();
        Image image = new Image(new File(getFilePath(ICONS.dir, "menu_bg.png")).toURI().toString());
        BackgroundImage backgroundImage = new BackgroundImage(image, null, null, null, null);
        Background bg = new Background(backgroundImage);

        menu.setBackground(bg);
        menu.add(new StartButton(stage).setup(), 0, 0);
        menu.setAlignment(Pos.CENTER);
        menu.setMinSize(ColumnWidth.BOTH.width, 768d);

        return menu;
    }
}

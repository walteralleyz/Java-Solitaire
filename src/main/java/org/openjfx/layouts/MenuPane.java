package org.openjfx.layouts;

import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.openjfx.components.StartButton;
import org.openjfx.enums.ColumnWidth;

import static org.openjfx.enums.Dir.ICONS;
import static org.openjfx.utils.PathUtil.getFilePath;

public class MenuPane extends GridPane {

    public MenuPane setup(Stage stage) {
        MenuPane menu = new MenuPane();
        Image image = new Image(getFilePath(ICONS.dir, "menu_bg.png"));
        BackgroundImage backgroundImage = new BackgroundImage(image, null, null, null, null);
        Background bg = new Background(backgroundImage);

        menu.setBackground(bg);
        menu.add(new StartButton(stage).setup(), 0, 0);
        Text copyright = new Text("(c) 2021 WalterAlleyz. https://github.com/walteralleyz/Java-Solitaire");
        copyright.setFont(new Font(14.0));
        copyright.setFill(Color.WHITE);
        menu.add(copyright, 0, 90);
        menu.setAlignment(Pos.CENTER);
        menu.setMinSize(ColumnWidth.BOTH.width, 768d);

        return menu;
    }
}

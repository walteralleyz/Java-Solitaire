package org.openjfx.utils;

import javafx.scene.text.Font;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import static javafx.scene.text.FontPosture.REGULAR;
import static javafx.scene.text.FontWeight.BOLD;
import static org.openjfx.enums.Dir.*;

public class Path {
    public static String getFilePath(String dir, String file) {
        return String.format("%s/%s/%s/%s", ROOT.dir, ASSETS.dir, dir, file);
    }

    public static Font loadFont() {
        File file = new File(getFilePath(FONTS.dir, "8bitin.ttf"));
        Font font;

        try {
            InputStream in = new FileInputStream(file);
            font = Font.loadFont(in, 40);
        } catch (Exception e) { font = Font.font("verdana", BOLD, REGULAR, 24); }

        return font;
    }
}

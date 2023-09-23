package org.openjfx.utils;

import javafx.scene.text.Font;

import static javafx.scene.text.FontPosture.REGULAR;
import static javafx.scene.text.FontWeight.BOLD;
import static org.openjfx.enums.Dir.ASSETS;
import static org.openjfx.enums.Dir.FONTS;

public class PathUtil {
    /**
     * Get the URL of the specified file in relative directory inside "assets/" folder
     *
     * @param dir  relative dir to assets
     * @param file file name
     * @return URL in string form
     */
    public static String getFilePath(String dir, String file) {
        return PathUtil.class.getClassLoader().getResource(ASSETS.dir + '/' + dir + '/' + file).toString();
    }

    public static Font loadFont(int customSize) {
        Font font;
        try {
            font = Font.loadFont(getFilePath(FONTS.dir, "8bitin.ttf"), customSize);
        } catch (Exception e) {
            System.err.println(e.getMessage());
            font = Font.font("Arial", BOLD, REGULAR, 24);
        }

        return font;
    }
}

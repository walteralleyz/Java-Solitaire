package org.openjfx.enums;

public enum Dir {
    ROOT("./"),
    ASSETS("assets"),
    SOUNDS("sounds"),
    ICONS("icons"),
    FONTS("fonts");

    public final String dir;

    Dir(String dir) {
        this.dir = dir;
    }
}

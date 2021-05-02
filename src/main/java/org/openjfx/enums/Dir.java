package org.openjfx.enums;

public enum Dir {
    ROOT("src"),
    ASSETS("assets"),
    SOUNDS("sounds"),
    ICONS("icons"),
    FONTS("fonts");

    public String dir;

    Dir(String dir) {
        this.dir = dir;
    }
}

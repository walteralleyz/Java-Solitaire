package org.openjfx.enums;

public enum ColumnWidth {
    FIRST(250d),
    SECOND(550d);

    public double width;

    ColumnWidth(double width) {
        this.width = width;
    }
}

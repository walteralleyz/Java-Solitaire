package org.openjfx.enums;

public enum ColumnWidth {
    FIRST(150d),
    MIDDLE(200d),
    BOTH(1024d);

    public final double width;

    ColumnWidth(double width) {
        this.width = width;
    }
}

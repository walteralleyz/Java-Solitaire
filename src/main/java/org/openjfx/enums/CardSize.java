package org.openjfx.enums;

public enum CardSize {
    SMALL(1.5),
    MEDIUM(2.0),
    BIG(2.5);

    public final double size;

    CardSize(double size) {
        this.size = size;
    }
}

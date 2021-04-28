package org.openjfx.enums;

public enum CardNumber {
    ACE(1),
    JACK(11),
    QUEEN(12),
    KING(13);

    public int number;

    CardNumber(int number) {
        this.number = number;
    }
}

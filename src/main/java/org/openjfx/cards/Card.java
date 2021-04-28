package org.openjfx.cards;

public class Card {
    private final String type;
    private final Integer number;

    public Card(String type, Integer number) {
        this.type = type;
        this.number = number;
    }

    public String getType() {
        return type;
    }

    public Integer getNumber() {
        return number;
    }
}

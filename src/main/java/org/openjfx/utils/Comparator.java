package org.openjfx.utils;

import org.openjfx.cards.Card;

public class Comparator {
    public static boolean isCardValid(Card previous, Card selected) {
        return (previous.getNumber() + 1) == selected.getNumber()
            && deckTypeComparator(previous.getType(), selected.getType());
    }

    public static boolean deckTypeComparator(String previous, String selected) {
        if(selected.equals("tiles") || selected.equals("clovers"))
            return previous.equals("pikes") || previous.equals("hearts");

        else
            return previous.equals("tiles") || previous.equals("clovers");
    }

    public static boolean isTypeCardValid(Card previous, String type) {
        return previous.getType().equals(type);
    }

    public static boolean isPreviousNumberGreater(Card previous, Card selected) {
        if(selected != null) return (previous.getNumber() - 1) == selected.getNumber();
        return false;
    }

    public static boolean isAceAndSameType(Card previous, String type) {
        return previous.isAce() && previous.getType().equals(type);
    }
}

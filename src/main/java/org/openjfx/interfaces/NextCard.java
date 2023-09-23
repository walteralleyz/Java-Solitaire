package org.openjfx.interfaces;

import org.openjfx.decks.SideDeck;

@FunctionalInterface
public interface NextCard {
    void flip(SideDeck deck);
}

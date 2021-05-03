package org.openjfx.decks;

import org.openjfx.cards.Card;

import java.util.*;

public class Deck {
    private final Stack<Card> memory = new Stack<>();

    public Deck() { }

    public Stack<Card> getCardStack() {
        return memory;
    }

    public int getStackSize() {
        return getCardStack().size();
    }

    public void shuffleDeck() { Collections.shuffle(memory); }

    public Card popCard() {
        return memory.pop();
    }

    public Card peekCard() {
        return memory.peek();
    }

    public boolean isDeckEmpty() { return memory.isEmpty(); }

    public void addCard(Card card) {
        memory.push(card);
    }

    @Override
    public String toString() {
        return memory.toString();
    }
}

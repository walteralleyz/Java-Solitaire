package org.openjfx.cards;

import java.util.*;

public class Deck {
    private final Stack<Card> memory = new Stack<>();
    private final boolean modifiable;

    public Deck(Deck deck) {
        modifiable = false;
        memory.addAll(deck.getMemory());
    }

    private Deck(boolean b) {
        modifiable = b;
    }

    public void copyFromStack(Stack<Card> stack) {
        if(memory.isEmpty()) {
            while(!stack.isEmpty()) {
                memory.push(stack.pop());
            }

            Collections.shuffle(memory);
        }
    }

    public Stack<Card> getMemory() {
        if(modifiable) return memory;
        return new Stack<>();
    }

    public void shuffleDeck() { Collections.shuffle(memory); }

    public Card getItem() {
        return memory.pop();
    }

    public boolean isEmpty() { return memory.isEmpty(); }

    public void addCard(Card card) {
        if(modifiable) memory.push(card);
    }

    public static Deck getMutableInstance() {
        return new Deck(true);
    }
}

package org.openjfx.cards;

import org.openjfx.game.History;

import java.util.*;

import static org.openjfx.utils.Comparator.isCardValid;

public class Deck {
    private final Stack<Card> memory = new Stack<>();

    public Deck() { }

    public void copyFromStack(Stack<Card> stack) {
        if(memory.isEmpty()) {
            while(!stack.isEmpty()) {
                memory.push(stack.pop());
            }

            Collections.shuffle(memory);
        }
    }

    public boolean moveToDeck(History history) {
        if(history.isNotCardNull()) {
            Card previous = history.getCard();
            Card selected = getStackSize() > 0 ? peekCard() : null;

            if(selected == null || isCardValid(previous, selected)) {
                Stack<Card> temp = new Stack<>();
                Card card;

                do {
                    card = history.popCardFromDeck();
                    card.setOpenTrue();
                    temp.push(card);
                } while(card != previous);

                while(!temp.isEmpty()) { addCard(temp.pop()); }

                try { history.peekCardFromDeck().setOpenTrue(); }
                catch (Exception ignored) {}

                history.cleanCard();
                history.sendSignalToGame();

                return true;
            }
        }

        return false;
    }

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

    public boolean isEmpty() { return memory.isEmpty(); }

    public void addCard(Card card) {
        memory.push(card);
    }

    @Override
    public String toString() {
        return memory.toString();
    }
}

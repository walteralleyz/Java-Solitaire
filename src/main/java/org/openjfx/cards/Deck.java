package org.openjfx.cards;

import javafx.scene.image.ImageView;
import org.openjfx.enums.CardSize;
import org.openjfx.game.History;
import org.openjfx.utils.Images;

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
        if(history.getCard() != null) {
            Card historyCard = history.getDeck().getLastCard();
            Card card = getMemory().size() > 0 ? getLastCard() : null;

            if(card == null || isCardValid(historyCard, card)) {
                addCard(history.getDeck().getItem());

                try { history.getDeck().getLastCard().setOpenTrue(); }
                catch (Exception ignored) {}

                history.cleanCard();
                history.sendSignalToGame();

                return true;
            }
        }

        return false;
    }

    public Stack<Card> getMemory() {
        return memory;
    }

    public void shuffleDeck() { Collections.shuffle(memory); }

    public Card getItem() {
        return memory.pop();
    }

    public Card getLastCard() {
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

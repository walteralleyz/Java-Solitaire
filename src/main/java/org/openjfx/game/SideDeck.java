package org.openjfx.game;

import javafx.scene.image.ImageView;
import org.openjfx.cards.Card;
import org.openjfx.utils.Images;

import java.util.Stack;

public class SideDeck {
    private final String[] roles = {"hearts", "tiles", "clovers", "pikes"};
    private final Stack<Card> memory;

    public SideDeck() {
        memory = new Stack<>();
    }

    public void addCard(Card card) {
        memory.push(card);
    }

    public ImageView getNextCardFace() {
        Card card = memory.peek();

        return Images.createCardImage(card.getType(), card.getNumber(), 2);
    }

    public Stack<Card> getMemory() {
        return memory;
    }
}

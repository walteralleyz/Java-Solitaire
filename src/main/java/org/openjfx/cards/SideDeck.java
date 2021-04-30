package org.openjfx.cards;

import javafx.scene.image.ImageView;
import org.openjfx.enums.CardSize;
import org.openjfx.game.History;
import org.openjfx.utils.Images;

import java.util.Stack;

public class SideDeck {
    private final Deck deck = new Deck();

    public void addCard(Card card) {
        deck.getMemory().push(card);
    }

    public ImageView getNextCardFace(History history) {
        Card card = deck.getMemory().peek();
        card.setOpenTrue();
        ImageView view = Images.createCardImage(card.getType(), card.getNumber(), CardSize.SMALL.size);
        view.setOnMouseClicked(event -> history.setCard(view, deck));

        return view;
    }

    public Stack<Card> getMemory() {
        return deck.getMemory();
    }
}

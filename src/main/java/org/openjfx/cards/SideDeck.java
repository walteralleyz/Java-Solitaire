package org.openjfx.cards;

import javafx.scene.image.ImageView;
import org.openjfx.game.History;

import java.util.Stack;

import static org.openjfx.cards.Types.isAWin;
import static org.openjfx.game.Attempts.isAlive;

public class SideDeck {
    private final Deck deck = new Deck();

    public void addCard(Card card) {
        deck.getCardStack().push(card);
    }

    public ImageView getNextCardFace(History history) {
        try {
            Card card = deck.peekCard();
            ImageView view = card.getView();
            view.setOnMouseClicked(event -> {
                if(isAlive() && !isAWin()) history.setCard(card, deck);
            });

            return view;
        } catch (Exception e) {
            return new ImageView();
        }
    }

    public Stack<Card> getDeck() {
        return deck.getCardStack();
    }
}

package org.openjfx.decks;

import javafx.scene.image.ImageView;
import org.openjfx.cards.Card;
import org.openjfx.components.History;

import static org.openjfx.components.Attempts.isAlive;
import static org.openjfx.containers.Types.isAWin;

public class SideDeck extends Deck {

    public SideDeck() {
        super();
    }

    public void addCard(Card card) {
        getCardStack().push(card);
    }

    public ImageView getNextCardFace(History history) {
        try {
            Card card = peekCard();
            ImageView view = card.getView();
            view.setOnMouseClicked(event -> {
                if (isAlive() && !isAWin()) {
                    history.cleanCard();
                    history.setCard(card, this);
                }
            });

            return view;
        } catch (Exception e) {
            return new ImageView();
        }
    }
}

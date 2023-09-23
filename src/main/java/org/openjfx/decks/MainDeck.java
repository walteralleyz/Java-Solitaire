package org.openjfx.decks;

import javafx.scene.image.ImageView;
import org.openjfx.cards.Card;
import org.openjfx.components.History;
import org.openjfx.interfaces.NextCard;

import java.util.Collections;

import static org.openjfx.components.Attempts.tookDamage;

public class MainDeck extends Deck {

    public MainDeck() {
        super();
    }

    public void copyFromSideDeck(SideDeck sideDeck) {
        if (getCardStack().isEmpty()) {
            while (!sideDeck.getCardStack().isEmpty()) {
                getCardStack().push(sideDeck.getCardStack().pop());
            }

            Collections.shuffle(getCardStack());
        }
    }

    public ImageView createBackCardDeck(NextCard card, SideDeck deck, History history) {
        ImageView deckFace = Card.getCardBack();
        deckFace.setOnMouseClicked(event -> {
            card.flip(deck);
            history.cleanCard();
        });

        return deckFace;
    }

    public ImageView createResetCardDeck(SideDeck sideDeck, History history) {
        ImageView reset = Card.getCardBlank();
        reset.setOnMouseClicked(event -> {
            tookDamage();
            copyFromSideDeck(sideDeck);

            history.sendSignalToGame();
        });

        return reset;
    }
}

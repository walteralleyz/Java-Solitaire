package org.openjfx.game;

import javafx.scene.image.ImageView;
import org.openjfx.cards.Deck;


public class History {
    private ImageView card;
    private Deck deck;

    private final Game game;

    public History(Game game) {
        this.game = game;
    }

    public ImageView getCard() {
        return card;
    }

    public Deck getDeck() {
        return deck;
    }

    public void sendSignalToGame() {
        game.update();
    }

    public void setCard(ImageView card, Deck deck) {
        if(this.card != null) this.card.setStyle("-fx-opacity: 1");

        this.deck = deck;
        this.card = card;
        this.card.setStyle("-fx-opacity: 0.8");
    }

    public void cleanCard() {
        if(card != null) {
            card.setStyle("-fx-opacity: 1");
            card = null;
            deck = null;
        }
    }
}

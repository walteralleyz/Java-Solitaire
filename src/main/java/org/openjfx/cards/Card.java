package org.openjfx.cards;

import javafx.scene.image.ImageView;
import org.openjfx.enums.CardSize;
import org.openjfx.game.History;
import org.openjfx.utils.Images;

public class Card {
    private final String type;
    private final Integer number;
    private boolean isOpen;
    private final ImageView view;

    public Card(String type, Integer number) {
        this.type = type;
        this.number = number;
        this.isOpen = false;
        this.view = Images.createCardImage(this.getType(), this.getNumber(), CardSize.SMALL.size);
    }

    public ImageView showDeckCardAndSetHandler(History history, Deck deck) {
        view.setOnMouseClicked(event -> {
            if(deck.moveToDeck(history)) return;
            history.setCard(view, deck);
        });

        return view;
    }

    public ImageView showDeckEmptyAndSetHandler(History history, Deck deck) {
        view.setOnMouseClicked(event -> deck.moveToDeck(history));

        return view;
    }

    public static ImageView showCardBack() {
        return Images.createCardImage("faces", 1, CardSize.SMALL.size);
    }

    public String getType() {
        return type;
    }

    public Integer getNumber() {
        return number;
    }

    public boolean isOpen() {
        return isOpen;
    }

    public void setOpenTrue() {
        isOpen = true;
    }

    @Override
    public String toString() {
        return "Card{" +
            "type='" + type + '\'' +
            ", number=" + number +
            ", isOpen=" + isOpen +
            '}';
    }
}

package org.openjfx.cards;

import javafx.scene.image.ImageView;
import org.openjfx.components.History;
import org.openjfx.decks.StackDeck;
import org.openjfx.enums.CardNumber;
import org.openjfx.enums.CardSize;

import java.util.Objects;

import static org.openjfx.components.Attempts.isAlive;
import static org.openjfx.containers.Types.isAWin;
import static org.openjfx.utils.Images.createCardImage;

public class Card {
    private final String type;
    private final Integer number;
    private boolean isOpen;
    private final ImageView view;

    public Card(String type, Integer number) {
        this.type = type;
        this.number = number;
        this.isOpen = false;
        this.view = createCardImage(this.getType(), this.getNumber(), CardSize.SMALL.size);
    }

    public ImageView getView() {
        return view;
    }

    public String getType() {
        return type;
    }

    public Integer getNumber() {
        return number;
    }

    public boolean isAce() {
        return getNumber() == CardNumber.ACE.number;
    }

    public boolean isOpen() {
        return isOpen;
    }

    public void setOpenTrue() {
        isOpen = true;
    }

    public ImageView showDeckCardAndSetHandler(History history, StackDeck deck) {
        view.setOnMouseClicked(event -> {
            if (isAlive() && !isAWin()) {
                if (deck.moveToDeck(history)) return;
                history.cleanCard();
                history.setCard(this, deck);
            }
        });

        return view;
    }

    public ImageView showDeckEmptyAndSetHandler(History history, StackDeck deck) {
        view.setOnMouseClicked(event -> {
            if (isAlive() && !isAWin()) deck.moveToDeck(history);
        });

        return view;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return Objects.equals(type, card.type) && Objects.equals(number, card.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, number);
    }

    @Override
    public String toString() {
        return "Card{" +
                "type='" + type + '\'' +
                ", number=" + number +
                ", isOpen=" + isOpen +
                '}';
    }

    public static ImageView getCardBack() {
        return createCardImage("faces", 1, CardSize.SMALL.size);
    }

    public static ImageView getCardBlank() {
        return createCardImage("faces", 2, CardSize.SMALL.size);
    }
}

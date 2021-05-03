package org.openjfx.components;

import org.openjfx.cards.Card;
import org.openjfx.decks.Deck;

import java.util.ArrayList;
import java.util.List;

public class History {
    private Card card;
    private Deck deck;
    private List<Card> cardList;

    private final Game game;
    private final Moves moves;

    public Card getCard() {
        return card;
    }

    public History(Game game, Moves moves) {
        this.game = game;
        this.moves = moves;
    }

    public Deck getDeck() {
        return deck;
    }

    public void sendSignalToGame() {
        game.update();
    }

    public void incrementMoveCounter() { moves.incrementMoves(); }

    public void setCard(Card card, Deck deck) {
        this.deck = deck;
        this.card = card;

        selectAndFillList();
    }

    public void cleanCard() {
        if(card != null) {
            unSelectedAndClearList();

            card = null;
            deck = null;
        }
    }

    public void selectAndFillList() {
        cardList = new ArrayList<>();
        int deckSize = deck.getStackSize()-1;

        do {
            Card temp = deck.getCardStack().get(deckSize);
            temp.getView().setStyle("-fx-opacity: 0.9");
            cardList.add(temp);

            if(temp == card) break;

            deckSize--;
        } while(true);
    }

    public void unSelectedAndClearList() {
        for(Card card : cardList) {
            card.getView().setStyle("-fx-opacity: 1");
        }

        cardList = null;
    }

    public boolean isNotCardNull() {
        return card != null;
    }

    public Card popCardFromDeck() {
        return getDeck().popCard();
    }

    public Card peekCardFromDeck() {
        return getDeck().peekCard();
    }
}

package org.openjfx.decks;

import org.openjfx.cards.Card;
import org.openjfx.components.History;

import java.util.Stack;

import static org.openjfx.utils.Comparator.isCardValid;

public class StackDeck extends Deck {

    public StackDeck() {
        super();
    }

    public boolean moveToDeck(History history) {
        if(history.isNotCardNull()) {
            Card previous = history.getCard();
            Card selected = getStackSize() > 0 ? peekCard() : null;

            if(selected == null || isCardValid(previous, selected)) {
                selectUnderCardSelected(history);

                try { history.peekCardFromDeck().setOpenTrue(); }
                catch (Exception ignored) {}

                history.cleanCard();
                history.sendSignalToGame();
                history.incrementMoveCounter();

                return true;
            }
        }

        return false;
    }

    public void selectUnderCardSelected(History history) {
        Stack<Card> temp = new Stack<>();
        Card card;

        do {
            card = history.popCardFromDeck();
            card.setOpenTrue();
            temp.push(card);
        } while(card != history.getCard());

        while(!temp.isEmpty()) { addCard(temp.pop()); }
    }
}

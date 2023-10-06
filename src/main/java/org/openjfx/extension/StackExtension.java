package org.openjfx.extension;

import org.openjfx.cards.Card;
import org.openjfx.containers.Stacks;
import org.openjfx.decks.Deck;
import org.openjfx.decks.StackDeck;

public class StackExtension {
    public static Stacks populateStacks(Deck deck) {
        Stacks stacks = new Stacks();

        for (int i = 0; i < 7; i++) {
            StackDeck temp = new StackDeck();

            for (int j = 0; j <= i; j++) {
                Card card = deck.popCard();

                if (j == i) card.setOpenTrue();

                temp.addCard(card);
            }

            stacks.getDeckList().add(temp);
        }

        return stacks;
    }
}

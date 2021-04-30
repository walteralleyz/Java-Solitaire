package org.openjfx.extension;

import org.openjfx.cards.Card;
import org.openjfx.cards.Deck;
import org.openjfx.cards.Stacks;

public class StackExtension {
    public static Stacks populateStacks(Deck deck) {
        Stacks stacks = new Stacks();

        for(int i = 0; i < 7; i++) {
            Deck temp = new Deck();

            for(int j = 0; j <= i; j++) {
                Card card = deck.getItem();

                if(j == i) card.setOpenTrue();

                temp.addCard(card);
            }

            stacks.getMemory().add(temp);
        }

        return stacks;
    }
}

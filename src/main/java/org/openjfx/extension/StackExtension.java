package org.openjfx.extension;

import org.openjfx.cards.Deck;
import org.openjfx.cards.Stacks;

public class StackExtension {
    public static Stacks populateStacks(Deck deck) {
        Stacks stacks = Stacks.getMutableInstance();

        for(int i = 0; i < 7; i++) {
            Deck temp = Deck.getMutableInstance();

            for(int j = 0; j <= i; j++) {
                temp.addCard(deck.getItem());
            }

            stacks.getMemory().add(temp);
        }

        return new Stacks(stacks);
    }
}

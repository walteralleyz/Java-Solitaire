package org.openjfx.extension;

import org.openjfx.cards.Card;
import org.openjfx.decks.MainDeck;
import org.openjfx.enums.CardNumber;

import static org.openjfx.utils.Roles.roles;

public class DeckExtension {
    public static MainDeck populateDeck() {
        MainDeck temp = new MainDeck();

        for (String role : roles) {
            for (int card = CardNumber.ACE.number; card <= CardNumber.KING.number; card++) {
                Card pair = new Card(role, card);

                temp.addCard(pair);
            }
        }

        temp.shuffleDeck();
        return temp;
    }
}

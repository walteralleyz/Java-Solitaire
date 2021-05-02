package org.openjfx.extension;

import org.openjfx.cards.Deck;
import org.openjfx.cards.Types;

import static org.openjfx.utils.Roles.roles;

public class TypesExtension {
    public static Types populateTypes() {
        Types types = new Types();

        for(int roleIndex = 0; roleIndex < roles.size(); roleIndex++) {
            Deck roleDeck = new Deck();

            types.getDeckList().add(roleDeck);
        }

        return types;
    }
}

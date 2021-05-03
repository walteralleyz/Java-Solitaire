package org.openjfx.extension;

import org.openjfx.decks.TypeDeck;
import org.openjfx.containers.Types;

import static org.openjfx.utils.Roles.roles;

public class TypesExtension {
    public static Types populateTypes() {
        Types types = new Types();

        for(String role : roles) {
            TypeDeck roleDeck = new TypeDeck(role);

            types.getDeckList().add(roleDeck);
        }

        return types;
    }
}

package org.openjfx.extension;

import org.openjfx.cards.Types;

import java.util.Stack;

import static org.openjfx.utils.Roles.roles;

public class TypesExtension {
    public static Types populateTypes() {
        Types types = Types.getMutableInstance();

        for(String role : roles) {
            Stack<Integer> roleDeck = new Stack<>();

            types.getMemory().put(role, roleDeck);
        }

        return new Types(types);
    }
}

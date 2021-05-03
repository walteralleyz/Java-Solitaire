package org.openjfx.containers;

import javafx.scene.Group;
import javafx.scene.image.ImageView;
import org.openjfx.components.History;
import org.openjfx.decks.Deck;
import org.openjfx.decks.TypeDeck;

import java.util.*;
import java.util.stream.Collectors;

public class Types {
    private final List<TypeDeck> memory = new ArrayList<>();
    private static boolean isAWin;

    public Types() { }

    public List<TypeDeck> getDeckList() {
        return memory;
    }

    public Group createTypesFace(History history) {
        Group group = new Group();
        int distanceX = 0;

        for(TypeDeck typeDeck : getDeckList()) {
            ImageView view = typeDeck.getTypeCardFace(history);

            view.setX(100 * (distanceX * 1.75));

            group.getChildren().add(view);
            distanceX++;
        }

        return group;
    }

    public void verifyAllTypes() {
        List<Deck> decks = getDeckList().stream()
            .filter(deck -> deck.getStackSize() == 13)
            .collect(Collectors.toList());

        setIsAWin(decks.size() == 4);
    }

    public static boolean isAWin() {
        return isAWin;
    }

    public static void setIsAWin(boolean isAWin) {
        Types.isAWin = isAWin;
    }
}

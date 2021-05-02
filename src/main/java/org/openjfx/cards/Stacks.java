package org.openjfx.cards;

import javafx.scene.Group;
import javafx.scene.image.ImageView;
import org.openjfx.enums.ColumnWidth;
import org.openjfx.game.History;

import java.util.ArrayList;
import java.util.List;

public class Stacks {
    private final List<Deck> memory = new ArrayList<>();

    public Stacks() { }

    public int getSize() {
        return memory.size();
    }

    public List<Deck> getDeckList() {
        return memory;
    }

    public Group createDecks(History history) {
        Group group = new Group();

        for(int stackIndex = 0; stackIndex < getSize(); stackIndex++) {
            Group temp = new Group();
            Deck deck = getDeckList().get(stackIndex);
            int stackSize = deck.getStackSize();

            if(stackSize == 0) temp.getChildren().add(
                new Card("faces", 2)
                    .showDeckEmptyAndSetHandler(history, deck)
            );

            for(int deckIndex = 0; deckIndex < stackSize; deckIndex++) {
                Card card = deck.getCardStack().get(deckIndex);
                ImageView image = Card.getCardBack();

                if(card.isOpen()) image = card.showDeckCardAndSetHandler(history, deck);

                image.setY(deckIndex * 25);
                temp.getChildren().add(image);
            }

            temp.setLayoutX(ColumnWidth.BOTH.width / 7d * stackIndex);
            group.getChildren().add(temp);
        };

        return group;
    }
}

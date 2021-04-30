package org.openjfx.cards;

import javafx.scene.Group;
import javafx.scene.image.ImageView;
import org.openjfx.enums.ColumnWidth;
import org.openjfx.game.History;

import java.util.ArrayList;
import java.util.List;

import static org.openjfx.cards.Card.showCardBack;

public class Stacks {
    private final List<Deck> memory = new ArrayList<>();

    public Stacks() { }

    public int getSize() {
        return memory.size();
    }

    public List<Deck> getMemory() {
        return memory;
    }

    public Group createDecks(History history) {
        Group group = new Group();

        for(int stackIndex = 0; stackIndex < getMemory().size(); stackIndex++) {
            Group temp = new Group();
            Deck deck = getMemory().get(stackIndex);
            int size = deck.getMemory().size();

            if(size == 0) temp.getChildren().add(new Card("faces", 2).showDeckEmptyAndSetHandler(history, deck));

            for(int deckIndex = 0; deckIndex < size; deckIndex++) {
                Card card = deck.getMemory().get(deckIndex);
                ImageView image = showCardBack();

                if(card.isOpen()) image = card.showDeckCardAndSetHandler(history, deck);

                image.setY(deckIndex * 15);
                temp.getChildren().add(image);
            }

            temp.setLayoutX(ColumnWidth.BOTH.width / 7d * stackIndex);
            group.getChildren().add(temp);
        };

        return group;
    }
}

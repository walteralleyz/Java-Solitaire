package org.openjfx.containers;

import javafx.scene.Group;
import javafx.scene.image.ImageView;
import org.openjfx.cards.Card;
import org.openjfx.components.History;
import org.openjfx.decks.StackDeck;
import org.openjfx.enums.ColumnWidth;

import java.util.ArrayList;
import java.util.List;

public class Stacks {
    private final List<StackDeck> memory = new ArrayList<>();

    public Stacks() {
    }

    public int getSize() {
        return memory.size();
    }

    public List<StackDeck> getDeckList() {
        return memory;
    }

    public Group createDecks(History history) {
        Group group = new Group();

        for (int stackIndex = 0; stackIndex < getSize(); stackIndex++) {
            StackDeck deck = getDeckList().get(stackIndex);
            int stackSize = deck.getStackSize();
            Group temp = createDeckCardGroup(history, stackSize, deck);

            for (int deckIndex = 0; deckIndex < stackSize; deckIndex++)
                temp.getChildren().add(createDeckCardImage(deck, history, deckIndex));

            temp.setLayoutX(ColumnWidth.BOTH.width / 7d * stackIndex);
            group.getChildren().add(temp);
        }
        ;

        return group;
    }

    public Group createDeckCardGroup(History history, int stackSize, StackDeck deck) {
        Group temp = new Group();

        if (stackSize == 0) temp.getChildren().add(
                new Card("faces", 2)
                        .showDeckEmptyAndSetHandler(history, deck)
        );

        return temp;
    }

    public ImageView createDeckCardImage(StackDeck deck, History history, int deckIndex) {
        Card card = deck.getCardStack().get(deckIndex);
        ImageView image = Card.getCardBack();

        if (card.isOpen()) image = card.showDeckCardAndSetHandler(history, deck);

        image.setY(deckIndex * 25);

        return image;
    }
}

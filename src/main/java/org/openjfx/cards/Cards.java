package org.openjfx.cards;

import javafx.scene.image.ImageView;
import org.openjfx.enums.CardSize;
import org.openjfx.game.History;

import java.util.Stack;

import static org.openjfx.utils.Images.createCardImage;
import static org.openjfx.extension.DeckExtension.populateDeck;
import static org.openjfx.extension.TypesExtension.populateTypes;
import static org.openjfx.extension.StackExtension.populateStacks;

public class Cards {
    private final Types types = populateTypes();
    private final Deck deck = populateDeck();
    private final Stacks stacks = populateStacks(deck);

    public void createNewDeck(Stack<Card> sideDeck) { deck.copyFromStack(sideDeck); }

    public Card getNextCard() { return deck.getItem(); }

    public ImageView getDeckFace() {
        return createCardImage("faces", 1, CardSize.SMALL.size);
    }

    public ImageView getResetDeckFace() {
        return createCardImage("faces", 2, CardSize.SMALL.size);
    }

    public boolean isDeckEmpty() {
        return deck.isEmpty();
    }

    public Stacks getStacks() {
        return stacks;
    }

    public Types getTypes() { return types; }
}

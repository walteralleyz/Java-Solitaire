package org.openjfx.game;

import javafx.geometry.Pos;
import javafx.scene.image.ImageView;
import org.openjfx.cards.*;
import org.openjfx.layout.Grids;
import org.openjfx.layout.Pane;

import static org.openjfx.cards.Types.isAWin;
import static org.openjfx.extension.DeckExtension.populateDeck;
import static org.openjfx.extension.StackExtension.populateStacks;
import static org.openjfx.extension.TypesExtension.populateTypes;
import static org.openjfx.game.Attempts.*;

public class Game {
    private final Deck deck = populateDeck();
    private final Types types = populateTypes();
    private final Stacks stacks = populateStacks(deck);
    private final SideDeck sideDeck = new SideDeck();
    private final Grids grids = new Grids();
    private final Clock clock = new Clock();
    private final Pane pane = Pane.setup(grids);
    private final History history = new History(this);

    public Pane setup() {
        grids.addTo("deck", createDeckFace());
        grids.addTo("sideDeck", sideDeck.getNextCardFace(history));
        grids.addTo("clock", clock.setup());
        grids.addTo("attempt", attemptText());
        grids.addTo("type", types.createTypesFace(history));
        grids.addTo("stack", stacks.createDecks(history));
        grids.addTo("music", new MusicPlayer().setup());

        grids.alignGridContent("music", Pos.TOP_RIGHT);
        clock.initialize();

        return pane;
    }

    public void update() {
        types.verifyAllTypes();

        grids.setTo("deck", createDeckFace());
        grids.setTo("sideDeck", sideDeck.getNextCardFace(history));
        grids.setTo("attempt", attemptText());
        grids.setTo("type", types.createTypesFace(history));
        grids.setTo("stack", stacks.createDecks(history));

        if(isAlive() && isAWin()) {
            grids.setTo("clock", winnerText());
            clock.stop();
        }

        else if(!isAlive()) {
            grids.setTo("clock", gameOverText());
            clock.stop();
        }
    }

    public ImageView resetDeck() {
        ImageView reset = Card.getCardReset();
        reset.setOnMouseClicked(event -> {
            tookDamage();
            deck.copyFromStack(sideDeck.getDeck());

            update();
        });

        return reset;
    }

    public ImageView backDeck() {
        ImageView deckFace = Card.getCardBack();
        deckFace.setOnMouseClicked(event -> {
            nextDeckCard();
            history.cleanCard();
        });

        return deckFace;
    }

    public void nextDeckCard() {
        sideDeck.addCard(deck.popCard());
        update();
    }

    public ImageView createDeckFace() {
        if(deck.isEmpty()) return resetDeck();
        return backDeck();
    }
}

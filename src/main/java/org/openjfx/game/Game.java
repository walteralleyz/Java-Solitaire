package org.openjfx.game;

import javafx.geometry.Pos;
import javafx.scene.image.ImageView;
import org.openjfx.cards.Cards;
import org.openjfx.cards.SideDeck;
import org.openjfx.layout.Grids;
import org.openjfx.layout.Pane;

import static org.openjfx.game.Attempts.*;

public class Game {
    private final Cards cards = new Cards();
    private final SideDeck sideDeck = new SideDeck();
    private final Grids grids = new Grids();
    private final Clock clock = new Clock();
    private final Pane pane = Pane.setup(grids);
    private final History history = new History(this);

    public Pane setup() {
        nextDeckCard();

        grids.addTo("deck", createDeckFace());
        grids.addTo("clock", clock.setup());
        grids.addTo("attempt", attemptText());
        grids.addTo("type", cards.getTypes().createTypesFace(history));
        grids.addTo("stack", cards.getStacks().createDecks(history));
        grids.addTo("music", setupMusicPlayer());
        grids.addTo("sideDeck", createSideDeckFace());

        grids.alignGridContent("music", Pos.TOP_RIGHT);
        clock.initialize();

        return pane;
    }

    public void update() {
        grids.setTo("type", 0, cards.getTypes().createTypesFace(history));
        grids.setTo("stack", 0, cards.getStacks().createDecks(history));
        grids.setTo("sideDeck", 0, createSideDeckFace());
    }

    public void flipNextCard() {
        if(cards.isDeckEmpty()) resetDeck();
        else {
            nextDeckCard();
            update();
        }
    }

    public void resetDeck() {
        ImageView reset = cards.getResetDeckFace();
        reset.setOnMouseClicked(event -> {
            if(isAlive()) {
                tookDamage();

                cards.createNewDeck(sideDeck.getMemory());
                grids.setToChildren("deck", 0, createDeckFace());
                grids.setToChildren("attempt", 0, attemptText());
            }

            else {
                grids.setToChildren("attempt", 0, gameOverText());
                clock.stop();
            }
        });

        grids.setToChildren("deck", 0, reset);
    }

    public void nextDeckCard() {
        sideDeck.addCard(cards.getNextCard());
    }

    public ImageView setupMusicPlayer() {
        MusicPlayer player = new MusicPlayer();
        return player.setup();
    }

    public ImageView createSideDeckFace() {
        try { return sideDeck.getNextCardFace(history); }
        catch (Exception e) { return new ImageView(); }
    }

    public ImageView createDeckFace() {
        ImageView deckFace = cards.getDeckFace();
        deckFace.setOnMouseClicked(event -> {
            flipNextCard();
            history.cleanCard();
        });

        return deckFace;
    }
}

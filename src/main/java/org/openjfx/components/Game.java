package org.openjfx.components;

import javafx.geometry.Pos;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import org.openjfx.containers.Stacks;
import org.openjfx.containers.Types;
import org.openjfx.decks.MainDeck;
import org.openjfx.decks.SideDeck;
import org.openjfx.layouts.Grids;
import org.openjfx.layouts.Pane;

import static org.openjfx.containers.Types.isAWin;
import static org.openjfx.extension.DeckExtension.populateDeck;
import static org.openjfx.extension.StackExtension.populateStacks;
import static org.openjfx.extension.TypesExtension.populateTypes;
import static org.openjfx.components.Attempts.*;

public class Game {
    private final SideDeck sideDeck = new SideDeck();
    private final MainDeck mainDeck = populateDeck();
    private final Types types = populateTypes();
    private final Stacks stacks = populateStacks(mainDeck);
    private final Grids grids = new Grids();
    private final Clock clock = new Clock();
    private final Pane pane = Pane.setup(grids);
    private final MusicPlayer player = new MusicPlayer();
    private final Moves moves = new Moves();
    private final History history = new History(this, moves);

    public Pane setup() {
        grids.addTo("deck", createDeckFace());
        grids.addTo("sideDeck", sideDeck.getNextCardFace(history));
        grids.addTo("clock", clock.setup());
        grids.addTo("attempt", attemptText());
        grids.addTo("type", types.createTypesFace(history));
        grids.addTo("stack", stacks.createDecks(history));
        grids.addTo("music", moves.setup());
        grids.addTo("music", player.setup());


        grids.alignGridContent("music", Pos.TOP_RIGHT);
        grids.getGrid("music").setHgap(50);
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
            clock.stop();
            player.stop();
            grids.getGrid("stack").setAlignment(Pos.CENTER);
            grids.getGrid("stack").getChildren().set(0, winnerText(Color.WHITE));
        }

        else if(!isAlive()) {
            grids.setTo("clock", gameOverText());
            clock.stop();
            player.stop();
        }
    }

    public ImageView createDeckFace() {
        if(mainDeck.isDeckEmpty()) return mainDeck.createResetCardDeck(sideDeck, history);
        return mainDeck.createBackCardDeck(side -> {
            side.addCard(mainDeck.popCard());
            update();
        }, sideDeck, history);
    }
}
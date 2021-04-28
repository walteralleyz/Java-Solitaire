package org.openjfx.game;

import javafx.scene.Group;
import javafx.scene.image.ImageView;
import org.openjfx.cards.Cards;
import org.openjfx.enums.CardSize;
import org.openjfx.utils.Images;

import static org.openjfx.game.Attempts.*;
import static org.openjfx.utils.Roles.roles;

public class Game {
    private final Cards cards = new Cards();
    private final SideDeck sideDeck = new SideDeck();
    private final LayoutGroups groups = new LayoutGroups();
    private final Clock clock = new Clock();
    private final Pane pane = Pane.setup(groups);

    public Pane setup() {
        groups.addTo("deck", createDeckFace());
        groups.addTo("clock", clock.setup());
        groups.addTo("attempt", attemptText());
        groups.addAllTo("card", createCardsFace());
        groups.addAllTo("stack", createStacksFace());

        groups.getClockGroup().setAutoSizeChildren(true);

        nextDeckCard();
        clock.initialize();

        return pane;
    }

    public void flipNextCard() {
        if(cards.isDeckEmpty()) resetDeck();
        else nextDeckCard();
    }

    public void resetDeck() {
        ImageView reset = Images.createCardImage("faces", 2, CardSize.SMALL.size);
        reset.setOnMouseClicked(event -> {
            if(isAlive()) {
                tookDamage();

                cards.createNewDeck(sideDeck.getMemory());
                groups.setTo("deck", 0, createDeckFace());
                groups.setTo("attempt", 0, attemptText());
            }

            else {
                groups.setTo("attempt", 0, gameOverText());
                clock.stop();
            }
        });

        groups.setTo("deck", 0, reset);
    }

    public void nextDeckCard() {
        sideDeck.addCard(cards.getNextCard());
        ImageView sideDeckCardFace = sideDeck.getNextCardFace();
        sideDeckCardFace.setX(63 * 1.35);

        try { groups.setTo("deck", 1, sideDeckCardFace); }
        catch (Exception e) { groups.getDeckGroup().getChildren().add(sideDeckCardFace); }
    }

    public ImageView createDeckFace() {
        ImageView deckFace = cards.getDeckFace();
        deckFace.setOnMouseClicked(event -> flipNextCard());

        return deckFace;
    }

    public ImageView[] createCardsFace() {
        float distance = 1f;
        ImageView[] images = new ImageView[roles.size()];

        for(int i = 0; i < roles.size(); i++) {
            ImageView card = cards.getCardsFace(roles.get(i));
            card.setX(70 * (1.35 * distance));

            images[i] = card;
            distance += 1.49;
        }

        return images;
    }

    public Group[] createStacksFace() {
        final int stacksSize = 7;

        Group[] images = new Group[stacksSize];

        for(int i = 0; i < stacksSize; i++) {
            Group temp = new Group();

            for(int k = 0; k <= i; k++) {
                ImageView image = Images.createCardImage("faces", 1, CardSize.SMALL.size);

                if(k == i) {
                    image = cards.getStacksFace(i);
                }

                image.setY(15 * k);
                temp.getChildren().add(image);
            }

            double j = i + 1;

            temp.setLayoutX(85 * (1.35 * j));
            images[i] = temp;
        }

        return images;
    }
}

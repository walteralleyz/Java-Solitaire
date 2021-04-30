package org.openjfx.cards;

import javafx.scene.Group;
import javafx.scene.image.ImageView;
import org.openjfx.enums.CardSize;
import org.openjfx.game.History;
import org.openjfx.utils.Images;

import java.util.*;

import static org.openjfx.utils.Roles.roles;
import static org.openjfx.utils.Comparator.isTypeCardValid;

public class Types {
    private final List<Deck> memory = new ArrayList<>();

    public Types() { }

    public List<Deck> getMemory() {
        return memory;
    }

    public ImageView getCardsFace(String type) {
        Deck deck = getMemory().get(roles.indexOf(type));
        if(deck.getMemory().size() == 0) return Images.createCardImage(
            "faces",
            roles.indexOf(type) + 3,
            CardSize.SMALL.size
        );

        Card card = deck.getMemory().peek();
        return Images.createCardImage(card.getType(), card.getNumber(), CardSize.SMALL.size);
    }

    public void moveToTypes(History history, Deck deck) {
        if(history.getCard() != null) {
            Card historyCard = history.getDeck().getLastCard();
            Card card = deck.getMemory().size() > 0 ? deck.getLastCard() : null;

            if(card == null && historyCard.getNumber().equals(1)
                || card != null && isTypeCardValid(historyCard, card)) {
                deck.addCard(history.getDeck().getItem());

                try { history.getDeck().getLastCard().setOpenTrue(); }
                catch (Exception ignored) {}

                history.sendSignalToGame();
            }

            history.cleanCard();
        }
    }

    public Group createTypesFace(History history) {
        Group group = new Group();

        for(int roleIndex = 0; roleIndex < roles.size(); roleIndex++) {
            ImageView view = getCardsFace(roles.get(roleIndex));
            int finalRoleIndex = roleIndex;

            view.setX(100 * (roleIndex * 1.75));
            view.setOnMouseClicked(event -> {
                if(history.getDeck().getLastCard().getType().equals(roles.get(finalRoleIndex)))
                    moveToTypes(history, getMemory().get(finalRoleIndex));

                else history.cleanCard();
            });

            group.getChildren().add(view);
        }

        return group;
    }
}

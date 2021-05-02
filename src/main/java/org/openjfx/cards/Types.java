package org.openjfx.cards;

import javafx.scene.Group;
import javafx.scene.image.ImageView;
import org.openjfx.enums.CardSize;
import org.openjfx.game.History;
import org.openjfx.utils.Images;

import java.util.*;
import java.util.stream.Collectors;

import static org.openjfx.utils.Roles.roles;
import static org.openjfx.utils.Comparator.isTypeCardValid;
import static org.openjfx.game.Attempts.isAlive;

public class Types {
    private final List<Deck> memory = new ArrayList<>();
    private static boolean isAWin;

    public Types() { }

    public List<Deck> getDeckList() {
        return memory;
    }

    public ImageView getCardsFace(String type) {
        Deck deck = getDeckList().get(roles.indexOf(type));
        if(deck.getStackSize() == 0) return Images.createCardImage(
            "faces",
            roles.indexOf(type) + 3,
            CardSize.SMALL.size
        );

        Card card = deck.peekCard();
        return Images.createCardImage(card.getType(), card.getNumber(), CardSize.SMALL.size);
    }

    public void moveToTypes(History history, Deck deck) {
        if(history.isNotCardNull()) {
            Card historyCard = history.peekCardFromDeck();
            Card card = deck.getStackSize() > 0 ? deck.peekCard() : null;

            if(card == null && historyCard.isAce()
                || card != null && isTypeCardValid(historyCard, card)) {
                deck.addCard(history.popCardFromDeck());

                try { history.peekCardFromDeck().setOpenTrue(); }
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
                if(isAlive() && !isAWin()) {
                    if(history.isNotCardNull()
                        && history.peekCardFromDeck().getType().equals(roles.get(finalRoleIndex)))
                        moveToTypes(history, getDeckList().get(finalRoleIndex));

                    else history.cleanCard();
                }
            });

            group.getChildren().add(view);
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

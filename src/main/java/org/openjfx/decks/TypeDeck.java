package org.openjfx.decks;

import javafx.scene.image.ImageView;
import org.openjfx.cards.Card;
import org.openjfx.components.History;
import org.openjfx.enums.CardSize;

import static org.openjfx.containers.Types.isAWin;
import static org.openjfx.components.Attempts.isAlive;
import static org.openjfx.utils.Comparator.*;
import static org.openjfx.utils.Images.createCardImage;
import static org.openjfx.utils.Roles.roles;

public class TypeDeck extends Deck {
    private final String type;

    public TypeDeck(String type) {
        super();
        this.type = type;
    }

    public ImageView getTypeCardFace(History history) {
        ImageView view;

        if(isDeckEmpty()) view = createCardImage(
            "faces",
            roles.indexOf(type) + 3,
            CardSize.SMALL.size
        );

        else view = createCardImage(peekCard().getType(), peekCard().getNumber(), CardSize.SMALL.size);

        view.setOnMouseClicked(event -> {
            if(isAlive() && !isAWin()) {
                if(history.isNotCardNull())
                    moveToTypeDeck(history);

                else history.cleanCard();
            }
        });

        return view;
    }

    public void moveToTypeDeck(History history) {
        if(history.isNotCardNull()) {
            Card previous = history.peekCardFromDeck();
            Card selected = isDeckEmpty() ? null : peekCard();

            if(selected == null && isAceAndSameType(previous, type)) {
                addCardAndUpdate(history);
                history.incrementMoveCounter();
            }

            if(isTypeCardValid(previous, type) && isPreviousNumberGreater(previous, selected)) {
                addCardAndUpdate(history);
                history.incrementMoveCounter();
            }

            history.cleanCard();
        }
    }

    public void addCardAndUpdate(History history) {
        addCard(history.popCardFromDeck());

        try { history.peekCardFromDeck().setOpenTrue(); }
        catch (Exception ignored) {}

        history.sendSignalToGame();
    }
}

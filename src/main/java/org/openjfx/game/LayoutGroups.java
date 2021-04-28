package org.openjfx.game;

import javafx.scene.Group;
import javafx.scene.Node;
import java.util.Map;

public class LayoutGroups {
    private final Group
        deckGroup = new Group(),
        cardGroup = new Group(),
        stacksGroup = new Group(),
        attemptGroup = new Group(),
        clockGroup = new Group()
    ;

    private final Map<String, Group> groupMap = Map.of(
        "deck", deckGroup,
        "card", cardGroup,
        "stack", stacksGroup,
        "attempt", attemptGroup,
        "clock", clockGroup
    );

    public Group getAttemptGroup() {
        return attemptGroup;
    }

    public Group getCardGroup() {
        return cardGroup;
    }

    public Group getClockGroup() {
        return clockGroup;
    }

    public Group getDeckGroup() {
        return deckGroup;
    }

    public Group getStacksGroup() {
        return stacksGroup;
    }

    public void setTo(String group, int index, Node node) {
        try { groupMap.get(group).getChildren().set(index, node); }
        catch (Exception e) { throw new RuntimeException("Collection group not found!"); }
    }

    public void addTo(String group, Node node) {
        try { groupMap.get(group).getChildren().add(node); }
        catch (Exception e) { throw new RuntimeException("Collection group not found!"); }
    }

    public void addAllTo(String group, Node... nodes) {
        try { groupMap.get(group).getChildren().addAll(nodes); }
        catch (Exception e) { throw new RuntimeException("Collection group not found!"); }
    }
}

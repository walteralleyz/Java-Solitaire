package org.openjfx.game;

import javafx.scene.layout.GridPane;

public class Pane extends GridPane {
    private Pane() {
        super();
    }

    public static Pane setup(LayoutGroups groups) {
        Pane pane = new Pane();

        pane.setMinSize(800d, 640d);
        pane.setStyle("-fx-background-color: #0b6c59; -fx-padding: 35px");
        pane.setVgap(50d);
        pane.add(groups.getAttemptGroup(), 0, 0);
        pane.add(groups.getClockGroup(), 1, 0);
        pane.add(groups.getDeckGroup(), 0, 1);
        pane.add(groups.getCardGroup(), 1, 1);
        pane.add(groups.getStacksGroup(), 0, 2, 2, 1);

        return pane;
    }
}

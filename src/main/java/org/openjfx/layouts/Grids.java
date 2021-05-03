package org.openjfx.layouts;

import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.layout.GridPane;

import java.util.Map;

public class Grids {
    private final GridPane
        deck     = new GridPane(),
        sideDeck = new GridPane(),
        type     = new GridPane(),
        stack    = new GridPane(),
        attempt  = new GridPane(),
        clock    = new GridPane(),
        music    = new GridPane()
    ;

    private final Map<String, GridPane> gridMap = Map.of(
        "deck", deck,
        "sideDeck", sideDeck,
        "type", type,
        "stack", stack,
        "attempt", attempt,
        "clock", clock,
        "music", music
    );

    public GridPane getGrid(String grid) {
        return gridMap.get(grid);
    }

    public void alignGridContent(String grid, Pos pos) {
        getGrid(grid).setAlignment(pos);
    }

    public void setTo(String grid, Node node) {
        try { getGrid(grid).getChildren().set(0, node); }
        catch (Exception e) { throw new RuntimeException(e.getMessage()); }
    }

    public void addTo(String grid, Node node) {
        try {
            getGrid(grid).add(node, getGrid(grid).getColumnCount() + 1, 0);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}

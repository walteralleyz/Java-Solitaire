package org.openjfx.layout;

import javafx.geometry.Pos;
import javafx.scene.Group;
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

    public void setTo(String grid, int index, Node node) {
        try { getGrid(grid).getChildren().set(index, node); }
        catch (Exception e) { throw new RuntimeException("Collection grid not found!"); }
    }

    public void addTo(String grid, Node node) {
        try { getGrid(grid).add(node, getGrid(grid).getColumnCount() + 1, 0); }
        catch (Exception e) { throw new RuntimeException("Collection grid not found!"); }
    }

    public void addToChildren(String grid, Node node) {
        try {
            Group group = (Group) getGrid(grid).getChildren().get(0);
            group.getChildren().add(node);
        } catch (Exception e) { throw new RuntimeException("Collection grid not found!"); }
    }

    public void setToChildren(String grid, int index, Node node) {
        try {
            Group group = (Group) getGrid(grid).getChildren().get(0);
            group.getChildren().set(index, node);
        } catch (Exception e) { throw new RuntimeException("Collection grid not found!"); }
    }

    public Group getChild(String grid) {
        return (Group) getGrid(grid).getChildren().get(0);
    }
}

package org.openjfx.cards;

import javafx.scene.image.ImageView;
import org.openjfx.enums.CardSize;
import org.openjfx.utils.Images;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import static org.openjfx.utils.Roles.roles;

public class Types {
    private final Map<String, Stack<Integer>> memory = new HashMap<>();
    private final boolean modifiable;

    public Types(Types types) {
        memory.putAll(types.getMemory());
        modifiable = false;
    }

    private Types(boolean b) { modifiable = b; }

    public Map<String, Stack<Integer>> getMemory() {
        if(modifiable) return memory;
        return new HashMap<>();
    }

    public static Types getMutableInstance() {
        return new Types(true);
    }

    public ImageView getCardsFace(String type) {
        if(memory.get(type).isEmpty()) return Images.createCardImage("faces", (roles.indexOf(type) + 3), CardSize.SMALL.size);
        return Images.createCardImage(type, memory.get(type).peek(), CardSize.SMALL.size);
    }
}

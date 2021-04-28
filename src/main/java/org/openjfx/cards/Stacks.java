package org.openjfx.cards;

import javafx.scene.image.ImageView;
import org.openjfx.enums.CardSize;
import org.openjfx.utils.Images;

import java.util.ArrayList;
import java.util.List;

public class Stacks {
    private final List<Deck> memory = new ArrayList<>();
    private final boolean modifiable;

    public Stacks(Stacks stacks) {
        modifiable = false;
        memory.addAll(stacks.getMemory());
    }

    private Stacks(boolean b) { modifiable = b; }

    public ImageView showCardFace(int pos) {
        Card card = memory.get(pos).getMemory().peek();
        return Images.createCardImage(card.getType(), card.getNumber(), CardSize.SMALL.size);
    }

    public int getSize() {
        return memory.size();
    }

    public List<Deck> getMemory() {
        if(modifiable) return memory;
        return new ArrayList<>();
    }

    public static Stacks getMutableInstance() {
        return new Stacks(true);
    }
}

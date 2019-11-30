package com.robcio.game;

import java.util.LinkedList;
import java.util.List;

public class BoldBrush  extends Brush {
    @Override
    List<PositionOffset> getShape() {
        final LinkedList<PositionOffset> shape = new LinkedList<>();
        shape.add(PositionOffset.of(1, 1));
        shape.add(PositionOffset.of(1, 0));
        shape.add(PositionOffset.of(1, -1));
        shape.add(PositionOffset.of(0, 1));
        shape.add(PositionOffset.of(0, 0));
        shape.add(PositionOffset.of(0, -1));
        shape.add(PositionOffset.of(-1, 1));
        shape.add(PositionOffset.of(-1, 0));
        shape.add(PositionOffset.of(-1, -1));
        return shape;
    }
}

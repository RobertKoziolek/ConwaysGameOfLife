package com.robcio.game;

import java.util.LinkedList;
import java.util.List;

public class BasicBrush extends Brush {
    @Override
    List<PositionOffset> getShape() {
        final LinkedList<PositionOffset> shape = new LinkedList<>();
        shape.add(PositionOffset.of(0, 0));
        return shape;
    }
}

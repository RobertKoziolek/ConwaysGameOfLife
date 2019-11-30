package com.robcio.game;

import java.util.List;

public abstract class Brush {

    private final List<PositionOffset> shape;

    Brush() {
        shape = getShape();

    }

    abstract List<PositionOffset> getShape();

    public void paint(final Grid grid, final int x, final int y) {
        for (final PositionOffset positionOffset : shape) {
            grid.animate(x + positionOffset.getXOffset(), y + positionOffset.getYOffset());
        }
    }
}
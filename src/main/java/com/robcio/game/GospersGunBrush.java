package com.robcio.game;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class GospersGunBrush extends Brush {
    @Override
    List<PositionOffset> getShape() {
        final LinkedList<PositionOffset> shape = new LinkedList<>();
        shape.add(PositionOffset.of(-17, 0));
        shape.add(PositionOffset.of(-18, 0));
        shape.add(PositionOffset.of(-17, -1));
        shape.add(PositionOffset.of(-18, -1));

        shape.add(PositionOffset.of(-8, -1));
        shape.add(PositionOffset.of(-7, -2));
        shape.add(PositionOffset.of(-6, -3));
        shape.add(PositionOffset.of(-5, -3));
        shape.add(PositionOffset.of(-3, -2));
        shape.add(PositionOffset.of(-2, -1));
        shape.add(PositionOffset.of(-8, 0));
        shape.add(PositionOffset.of(-8, 1));
        shape.add(PositionOffset.of(-7, 2));
        shape.add(PositionOffset.of(-6, 3));
        shape.add(PositionOffset.of(-5, 3));
        shape.add(PositionOffset.of(-3, 2));
        shape.add(PositionOffset.of(-2, 1));
        shape.add(PositionOffset.of(-8, 0));
        shape.add(PositionOffset.of(-4, 0));
        shape.add(PositionOffset.of(-2, 0));
        shape.add(PositionOffset.of(-1, 0));

        shape.add(PositionOffset.of(2, -1));
        shape.add(PositionOffset.of(2, -2));
        shape.add(PositionOffset.of(2, -3));
        shape.add(PositionOffset.of(3, -1));
        shape.add(PositionOffset.of(3, -2));
        shape.add(PositionOffset.of(3, -3));
        shape.add(PositionOffset.of(4, 0));
        shape.add(PositionOffset.of(4, -4));
        shape.add(PositionOffset.of(6, 0));
        shape.add(PositionOffset.of(6, 1));
        shape.add(PositionOffset.of(6, -5));
        shape.add(PositionOffset.of(6, -4));
        shape.add(PositionOffset.of(16, -2));
        shape.add(PositionOffset.of(16, -3));
        shape.add(PositionOffset.of(17, -3));
        shape.add(PositionOffset.of(17, -2));
        return shape.stream().map(PositionOffset::reverse).collect(Collectors.toList());

//        return shape;
    }
}

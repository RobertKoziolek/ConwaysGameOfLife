package com.robcio.game;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.LinkedList;
import java.util.List;

@NoArgsConstructor
class NeighbourMatrix {
    @Getter
    private final List<PositionOffset> offsets = new LinkedList<>();

    {
        offsets.add(PositionOffset.of(-1, -1));
        offsets.add(PositionOffset.of(0, -1));
        offsets.add(PositionOffset.of(1, -1));
        offsets.add(PositionOffset.of(-1, 0));
        offsets.add(PositionOffset.of(1, 0));
        offsets.add(PositionOffset.of(-1, 1));
        offsets.add(PositionOffset.of(0, 1));
        offsets.add(PositionOffset.of(1, 1));
    }
}

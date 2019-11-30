package com.robcio.game;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
class PositionOffset {
    private final int xOffset;
    private final int yOffset;

    static PositionOffset of(final int xOffset, final int yOffset){
        return new PositionOffset(xOffset, yOffset);
    }

    public PositionOffset reverse() {
        return of(-xOffset, yOffset);
    }
}

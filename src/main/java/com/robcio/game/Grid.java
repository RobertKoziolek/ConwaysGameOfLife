package com.robcio.game;

import lombok.Getter;

import java.util.Random;

import static com.robcio.util.Constants.*;

public class Grid {

    private final NeighbourMatrix neighbourMatrix = new NeighbourMatrix();
    @Getter
    private final boolean[][] grid = new boolean[GRID_SIZE_X][GRID_SIZE_Y];

    public boolean isAlive(final int x, final int y) {
        return grid[periodic(x, GRID_SIZE_X)][periodic(y, GRID_SIZE_Y)];
    }

    private int periodic(final int value, final int max) {
        if (PERIODIC_BOUNDARIES) {
            if (value == -1) {
                return max - 1;
            } else if (value == max) {
                return 0;
            }
        }
        return value;
    }

    void animate(final int x, final int y) {
        try {
            grid[x][y] = true;
        } catch (final ArrayIndexOutOfBoundsException e) {
            System.out.println("Out of bounds");
        }
    }

    private int getNumberOfNeighbours(final int x, final int y) {
        int count = 0;
        for (final PositionOffset positionOffset : neighbourMatrix.getOffsets()) {
            try {
                if (isAlive(x + positionOffset.getXOffset(), y + positionOffset.getYOffset())) {
                    count++;
                }
            } catch (final ArrayIndexOutOfBoundsException e) {
                continue;
            }
        }
        return count;
    }

    public Grid step() {
        final Grid newGrid = new Grid();
        for (int x = 0; x < grid.length; x++) {
            for (int y = 0; y < grid[x].length; y++) {
                final int numberOfNeighbours = getNumberOfNeighbours(x, y);
                if (numberOfNeighbours == 3 || (isAlive(x, y) && numberOfNeighbours == 2)) {
                    newGrid.animate(x, y);
                }
            }
        }
        return newGrid;
    }

    public void randomize() {
        final Random random = new Random();
        for (boolean[] booleans : grid) {
            for (int i = 0; i < booleans.length; i++) {
                booleans[i] = random.nextBoolean() && random.nextBoolean();
            }
        }
    }
}

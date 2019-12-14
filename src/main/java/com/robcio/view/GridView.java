package com.robcio.view;

import com.robcio.game.Grid;
import lombok.Setter;

import javax.swing.*;
import java.awt.*;

import static com.robcio.util.Constants.BLOCK_SIZE_X;
import static com.robcio.util.Constants.BLOCK_SIZE_Y;

public class GridView extends JComponent {

    @Setter
    private Grid grid;

    public GridView(final Grid grid) {
        setGrid(grid);
    }

    @Override
    public void paint(final Graphics g) {
        final boolean[][] booleans = this.grid.getGrid();
        for (int x = 0; x < booleans.length; x++) {
            for (int y = 0; y < booleans[x].length; y++) {
                if (grid.isAlive(x, y)) {
                    g.drawRect(x * BLOCK_SIZE_X, y * BLOCK_SIZE_Y, BLOCK_SIZE_X, BLOCK_SIZE_Y);
                }
            }
        }
    }
}
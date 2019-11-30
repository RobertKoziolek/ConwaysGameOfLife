package com.robcio.view;

import com.robcio.game.Grid;
import lombok.Setter;

import javax.swing.*;
import java.awt.*;

import static com.robcio.util.Constants.*;

public class GraphicsView extends JComponent {

    private final JFrame window;

    @Setter
    private Grid grid;

    public GraphicsView (final Grid grid) {
        setGrid(grid);
        window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setBounds(0, 0, WINDOW_SIZE_X, WINDOW_SIZE_Y);
        window.getContentPane().add(this);
        window.setVisible(true);
        window.setLocationRelativeTo(null);
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
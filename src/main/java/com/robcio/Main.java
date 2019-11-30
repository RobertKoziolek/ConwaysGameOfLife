package com.robcio;

import com.robcio.game.Brush;
import com.robcio.game.GospersGunBrush;
import com.robcio.game.Grid;
import com.robcio.util.StepTime;
import com.robcio.view.GraphicsView;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;

import static com.robcio.util.Constants.BLOCK_SIZE_X;
import static com.robcio.util.Constants.BLOCK_SIZE_Y;

public class Main {

    private volatile Grid grid = new Grid();
    private Thread stepThread = getStepThread();

    public static void main(String[] args) throws InterruptedException {
        new Main();
    }

    private Main() throws InterruptedException {
//        grid.randomize();
        final GraphicsView graphicsView = new GraphicsView(grid);
        final StepTime stepTime = new StepTime();
        final Brush brush = new GospersGunBrush();

        graphicsView.addMouseWheelListener(new MouseAdapter() {
            @Override
            public void mouseWheelMoved(MouseWheelEvent e) {
                super.mouseWheelMoved(e);
                if (e.getWheelRotation() > 0) {
                    stepTime.hastenSpeed();
                } else {
                    stepTime.slowSpeed();
                }
            }

        });
        graphicsView.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                super.mouseDragged(e);
                try {
                    stepThread.join();
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
                brush.paint(grid, e.getX() / BLOCK_SIZE_X, e.getY() / BLOCK_SIZE_Y);
            }
        });
        graphicsView.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                try {
                    stepThread.join();
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
                brush.paint(grid, e.getX() / BLOCK_SIZE_X, e.getY() / BLOCK_SIZE_Y);
            }
        });

        while (true) {
            stepThread.join();
            graphicsView.setGrid(grid);
            graphicsView.repaint();
            stepThread = getStepThread();
            stepThread.start();
            Thread.sleep(stepTime.getStepTime());
        }
    }

    private Thread getStepThread() {
        return new Thread(() -> {
            grid = grid.step();
        });
    }

}

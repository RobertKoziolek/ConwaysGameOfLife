package com.robcio.game;

import com.robcio.util.StepTime;
import lombok.Getter;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;

import static com.robcio.util.Constants.BLOCK_SIZE_X;
import static com.robcio.util.Constants.BLOCK_SIZE_Y;

public class GameController {

    @Getter
    private volatile Grid grid = new Grid();
    private Thread stepThread;
    final StepTime stepTime = new StepTime();
    final Brush brush = new GospersGunBrush();


    public Thread getStepThread() {
        stepThread = new Thread(() -> {
            grid = grid.step();
        });
        return stepThread;
    }

    public long getStepTime() {
        return stepTime.getStepTime();
    }

    public void addListeners(final JFrame component) {
        component.addMouseWheelListener(new MouseAdapter() {
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
        component.addMouseMotionListener(new MouseAdapter() {
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
        component.addMouseListener(new MouseAdapter() {
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
    }
}

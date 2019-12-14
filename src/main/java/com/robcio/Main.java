package com.robcio;

import com.robcio.game.GameController;
import com.robcio.view.GridView;
import com.robcio.view.Window;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        final GameController gameController = new GameController();
        Thread stepThread = gameController.getStepThread();
        final GridView gridView = new GridView(gameController.getGrid());
        final Window window = new Window(gridView);
        gameController.addListeners(window);
        while (true) {
            stepThread.join();
            gridView.setGrid(gameController.getGrid());
            window.repaint();
            stepThread = gameController.getStepThread();
            stepThread.start();
            Thread.sleep(gameController.getStepTime());
        }
    }
}

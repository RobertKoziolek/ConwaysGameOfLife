package com.robcio;

import com.robcio.game.GameController;
import com.robcio.view.GridView;
import com.robcio.view.Window;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        final GameController gameController = new GameController();

        final GridView gridView = new GridView(gameController.getGrid());
        final Window window = new Window(gridView);

        gameController.addListeners(gridView);
        while (true) {
            gameController.joinStep();
            gridView.setGrid(gameController.getGrid());
            window.repaint();
            gameController.startStep();
            Thread.sleep(gameController.getStepTime());
        }
    }
}

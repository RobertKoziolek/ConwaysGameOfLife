package com.robcio.view;

import javax.swing.*;

import static com.robcio.util.Constants.WINDOW_SIZE_X;
import static com.robcio.util.Constants.WINDOW_SIZE_Y;

public class Window extends JFrame {

    public Window(final GridView gridView) {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(0, 0, WINDOW_SIZE_X, WINDOW_SIZE_Y);
        getContentPane().add(gridView);
        setVisible(true);
        setLocationRelativeTo(null);
    }
}
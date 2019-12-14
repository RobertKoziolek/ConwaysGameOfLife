package com.robcio.util;

public class Constants {
    public static final int STEP_TIME = 5;
    public static final int MIN_STEP_TIME = 0;
    public static final int MAX_STEP_TIME = 200;
    public static final boolean PERIODIC_BOUNDARIES = true;

    //should not exceed window size
    public static final int GRID_SIZE_X = 600;
    public static final int GRID_SIZE_Y = 200;


    public static final int GAME_WINDOW_SIZE_X = 1200;
    public static final int GAME_WINDOW_SIZE_Y = 800;
    public static final int WINDOW_UI_PANEL_SIZE_X = 300;
    public static final int WINDOW_SIZE_X = GAME_WINDOW_SIZE_X + WINDOW_UI_PANEL_SIZE_X;
    public static final int WINDOW_SIZE_Y = GAME_WINDOW_SIZE_Y;

    public static final int BLOCK_SIZE_X = WINDOW_SIZE_X/GRID_SIZE_X;
    public static final int BLOCK_SIZE_Y = WINDOW_SIZE_Y/GRID_SIZE_Y;

}

package com.epicness.slimeland.menu;

import static com.epicness.fundamentals.SharedConstants.CAMERA_HEIGHT;
import static com.epicness.fundamentals.SharedConstants.CAMERA_WIDTH;

public class MenuConstants {

    // Overlay
    public static final String WELCOME_BACK_MESSAGE = "Welcome back";
    // Choose text
    public static final float CHOOSE_TEXT_WIDTH = CAMERA_WIDTH;
    public static final float CHOOSE_TEXT_HEIGHT = 100f;
    public static final float CHOOSE_TEXT_Y = CAMERA_HEIGHT - CHOOSE_TEXT_HEIGHT;
    // Slimes
    public static final int SLIME_COLUMNS = 7;
    public static final int SLIME_ROWS = 15;
    public static final float SLIME_GRID_X_PADDING = 100f;
    public static final float SLIME_GRID_WIDTH = CAMERA_WIDTH - SLIME_GRID_X_PADDING * 2f;
    public static final float SLIME_SPACING = 50f;
    private static final float TOTAL_SPACING_X = SLIME_SPACING * (SLIME_COLUMNS - 1);
    public static final float SLIME_OPTION_WIDTH = (SLIME_GRID_WIDTH - TOTAL_SPACING_X) / SLIME_COLUMNS;
    public static final float SLIME_OPTION_HEIGHT = SLIME_OPTION_WIDTH * 0.7f;
    public static final float SLIME_GRID_STARTING_Y = CHOOSE_TEXT_Y - SLIME_OPTION_HEIGHT;
    public static final float SLIME_GRID_HEIGHT = SLIME_OPTION_HEIGHT * SLIME_ROWS + SLIME_SPACING * (SLIME_ROWS - 1);
    public static final float SLIME_GRID_SCROLL_MIN_Y = CAMERA_HEIGHT - CHOOSE_TEXT_HEIGHT - SLIME_OPTION_HEIGHT;
    public static final float SLIME_GRID_SCROLL_MAX_Y = SLIME_GRID_HEIGHT - SLIME_OPTION_HEIGHT;
    // Selector
    public static final float CHECK_SIZE = SLIME_OPTION_WIDTH;
}
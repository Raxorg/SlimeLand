package com.epicness.slimeland.game;

import static com.epicness.fundamentals.SharedConstants.CAMERA_HEIGHT;
import static com.epicness.fundamentals.SharedConstants.CAMERA_WIDTH;

public class GameConstants {

    // Preferences
    public static final String PREFS_PATH = "EpicnessSlimeLandPrefs";
    public static final String QUANTITY_PREF_KEY = "quantity";
    // Clouds
    public static final float CLOUD_WIDTH = 104f;
    public static final float CLOUD_HEIGHT = CLOUD_WIDTH / 2f;
    public static final float CLOUD_SHADOW_OFFSET = 200f;
    // Grid
    public static final int GRID_COLUMNS = 7;
    public static final int GRID_ROWS = 7;
    public static final float CELL_SIZE = 100f;
    private static final float GRID_SIZE = GRID_COLUMNS * CELL_SIZE;
    public static final float GRID_X = CAMERA_WIDTH / 2f - GRID_SIZE / 2f;
    public static final float GRID_Y = CAMERA_HEIGHT / 2f - GRID_SIZE / 2f;
    // Cell properties
    public static final String MACHINE_PROPERTY = "Machine";
    // Slimes
    public static final float SLIME_WIDTH = 50f;
    public static final float SLIME_HEIGHT = SLIME_WIDTH * 0.7f;
    public static final float SLIME_STARTING_X = CAMERA_WIDTH / 2f - SLIME_WIDTH / 2f;
    public static final float SLIME_STARTING_Y = CAMERA_HEIGHT / 2f - SLIME_HEIGHT / 2f;
    public static final float SLIME_MIN_SPEED = -500f;
    public static final float SLIME_MAX_SPEED = 500f;
    // Build menu
    public static final float BUILD_MENU_WIDTH = CELL_SIZE * 2f;
    public static final float BUILD_MENU_HEIGHT = CAMERA_HEIGHT;
    public static final float BUILD_MENU_SPEED = 1000f;
    // Build menu options
    public static final int OPTIONS = 3;
    private static final int SPACES = OPTIONS + 2;
    public static final float BUILD_OPTION_SIZE = BUILD_MENU_WIDTH / 2f;
    public static final float BUILD_OPTION_SPACING = (BUILD_MENU_HEIGHT - BUILD_OPTION_SIZE * (OPTIONS + 1)) / SPACES;
    public static final float BUILD_OPTION_X_OFFSET = BUILD_MENU_WIDTH / 2f - BUILD_OPTION_SIZE / 2f;
    public static final int FACTORY_ID = 0;
    public static final int WORKSHOP_ID = 1;
    public static final int TOWER_ID = 2;
    // Build menu counter
    public static final float BUILD_MENU_COUNTER_SIZE = BUILD_MENU_WIDTH / 2f;
    public static final float BUILD_MENU_COUNTER_Y = CAMERA_HEIGHT - BUILD_MENU_COUNTER_SIZE - BUILD_OPTION_SPACING;
    public static final float BUILD_MENU_COUNTER_X_OFFSET = BUILD_MENU_WIDTH / 2f - BUILD_MENU_COUNTER_SIZE / 2f;
    // Other
    public static final float HIDDEN_X = CAMERA_WIDTH * 2f;
    public static final float HIDDEN_Y = CAMERA_HEIGHT * 2f;
}
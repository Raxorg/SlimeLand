package com.epicness.slimeland.game;

import static com.epicness.fundamentals.SharedConstants.CAMERA_HEIGHT;
import static com.epicness.fundamentals.SharedConstants.CAMERA_WIDTH;

public class GameConstants {

    // Clouds
    public static final float CLOUD_WIDTH = 104f;
    public static final float CLOUD_HEIGHT = CLOUD_WIDTH / 2f;
    public static final float CLOUD_SHADOW_OFFSET = 200f;
    // Bushes
    public static final float BUSH_WIDTH = 52f;
    public static final float BUSH_HEIGHT = BUSH_WIDTH / 2.88f;
    // Grid
    public static final int GRID_COLUMNS = 7;
    public static final int GRID_ROWS = 7;
    public static final float CELL_SIZE = 100f;
    public static final float GRID_SIZE = GRID_COLUMNS * CELL_SIZE;
    public static final float GRID_X = CAMERA_WIDTH / 2f - GRID_SIZE / 2f;
    public static final float GRID_Y = CAMERA_HEIGHT / 2f - GRID_SIZE / 2f;
    // Cell properties
    public static final String MACHINE_PROPERTY = "Machine";
    // Machines
    public static final float MACHINE_SIZE = CELL_SIZE;
    // Slimes
    public static final float SLIME_WIDTH = 50f;
    public static final float SLIME_HEIGHT = SLIME_WIDTH * 0.7f;
    public static final float SLIME_MIN_SPEED = -400f;
    public static final float SLIME_MAX_SPEED = 400f;
    public static final float SLIME_HIDING_SPEED = 200f;
    // Foreign slimes
    public static final float FOREIGN_SLIME_SPEED = 100f;
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
    public static final int ANTENNA_ID = 3;
    // Build menu counter
    public static final float BUILD_CHARGES_FRAME_SIZE = BUILD_MENU_WIDTH / 2f;
    public static final float BUILD_CHARGES_FRAME_Y = CAMERA_HEIGHT - BUILD_CHARGES_FRAME_SIZE - BUILD_OPTION_SPACING;
    public static final float BUILD_CHARGES_FRAME_X_OFFSET = BUILD_MENU_WIDTH / 2f - BUILD_CHARGES_FRAME_SIZE / 2f;
    // Player info
    public static final float PLAYER_INFO_HEIGHT = 100f;
}
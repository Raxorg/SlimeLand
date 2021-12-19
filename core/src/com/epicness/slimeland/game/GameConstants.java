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

    public static final float BULLET_MAX_SIZE = 40f;
    public static final float BULLET_GROWTH_RATE = BULLET_MAX_SIZE / 2f;
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
    // Player list
    public static final float PLAYER_LIST_WIDTH = CAMERA_WIDTH * 0.8f;
    public static final float PLAYER_LIST_X = CAMERA_WIDTH / 2f - PLAYER_LIST_WIDTH / 2f;
    public static final float PLAYER_LIST_HEIGHT = CAMERA_HEIGHT;

    public static final float PLAYER_INFO_X = PLAYER_LIST_X;
    public static final float PLAYER_INFO_WIDTH = PLAYER_LIST_WIDTH;
    public static final float PLAYER_INFO_HEIGHT = 100f;
    public static final float PLAYER_INFO_NAME_WIDTH = PLAYER_INFO_WIDTH / 3f;
    public static final float PLAYER_INFO_SLIME_WIDTH = PLAYER_INFO_WIDTH / 6f;
    public static final float PLAYER_INFO_QUANTITY_WIDTH = PLAYER_INFO_WIDTH / 6f;
    public static final float PLAYER_INFO_STRENGTH_WIDTH = PLAYER_INFO_WIDTH / 6f;
    public static final float PLAYER_INFO_AGILITY_WIDTH = PLAYER_INFO_WIDTH / 6f;
    public static final float PLAYER_INFO_NAME_OFFSET_X = 0f;
    public static final float PLAYER_INFO_SLIME_OFFSET_X = PLAYER_INFO_NAME_WIDTH + PLAYER_INFO_SLIME_WIDTH / 2f - SLIME_WIDTH / 2f;
    public static final float PLAYER_INFO_QUANTITY_OFFSET_X = PLAYER_INFO_NAME_WIDTH + PLAYER_INFO_SLIME_WIDTH;
    public static final float PLAYER_INFO_STRENGTH_OFFSET_X = PLAYER_INFO_QUANTITY_OFFSET_X + PLAYER_INFO_QUANTITY_WIDTH;
    public static final float PLAYER_INFO_AGILITY_OFFSET_X = PLAYER_INFO_STRENGTH_OFFSET_X + PLAYER_INFO_STRENGTH_WIDTH;

    public static final float PLAYER_LIST_MIN_Y = CAMERA_HEIGHT - PLAYER_INFO_HEIGHT * 2f;

    public static final float LIST_HEADER_HEIGHT = 100f;
    public static final float LIST_HEADER_Y = CAMERA_HEIGHT - LIST_HEADER_HEIGHT;
    public static final float LIST_PLAYER_LABEL_OFFSET_X = 0f;
    public static final float LIST_PLAYER_LABEL_WIDTH = PLAYER_INFO_NAME_WIDTH;
    public static final float LIST_COLORS_LABEL_OFFSET_X = LIST_PLAYER_LABEL_WIDTH;
    public static final float LIST_COLORS_LABEL_WIDTH = PLAYER_INFO_SLIME_WIDTH;
    public static final float LIST_ARMY_LABEL_OFFSET_X = LIST_COLORS_LABEL_OFFSET_X + LIST_COLORS_LABEL_WIDTH;
    public static final float LIST_ARMY_LABEL_WIDTH = PLAYER_INFO_QUANTITY_WIDTH;
    public static final float LIST_STRENGTH_LABEL_OFFSET_X = LIST_ARMY_LABEL_OFFSET_X + LIST_ARMY_LABEL_WIDTH;
    public static final float LIST_STRENGTH_LABEL_WIDTH = PLAYER_INFO_STRENGTH_WIDTH;
    public static final float LIST_AGILITY_LABEL_OFFSET_X = LIST_STRENGTH_LABEL_OFFSET_X + LIST_STRENGTH_LABEL_WIDTH;
    public static final float LIST_AGILITY_LABEL_WIDTH = PLAYER_INFO_AGILITY_WIDTH;
}
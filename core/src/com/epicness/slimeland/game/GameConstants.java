package com.epicness.slimeland.game;

import static com.epicness.fundamentals.SharedConstants.CAMERA_HEIGHT;
import static com.epicness.fundamentals.SharedConstants.CAMERA_WIDTH;

public class GameConstants {

    public static final float HIDDEN_X = CAMERA_WIDTH * 2f;
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
    // Slimes
    public static final float SLIME_WIDTH = 50f;
    public static final float SLIME_HEIGHT = SLIME_WIDTH * 0.7f;
}
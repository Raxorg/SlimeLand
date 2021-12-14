package com.epicness.slimeland.game.stuff;

import static com.epicness.fundamentals.SharedConstants.DIRT;
import static com.epicness.fundamentals.SharedConstants.LIGHT_DIRT;
import static com.epicness.slimeland.game.GameConstants.CELL_SIZE;
import static com.epicness.slimeland.game.GameConstants.CLOUD_HEIGHT;
import static com.epicness.slimeland.game.GameConstants.CLOUD_SHADOW_OFFSET;
import static com.epicness.slimeland.game.GameConstants.CLOUD_WIDTH;
import static com.epicness.slimeland.game.GameConstants.GRID_COLUMNS;
import static com.epicness.slimeland.game.GameConstants.GRID_ROWS;
import static com.epicness.slimeland.game.GameConstants.GRID_X;
import static com.epicness.slimeland.game.GameConstants.GRID_Y;
import static com.epicness.slimeland.game.GameConstants.HIDDEN_X;

import com.epicness.fundamentals.stuff.Stuff;
import com.epicness.fundamentals.stuff.grid.Cell;
import com.epicness.fundamentals.stuff.grid.Grid;
import com.epicness.slimeland.game.GameAssets;

public class GameStuff extends Stuff {

    private Cloud[] clouds;
    private Grid grid;

    @Override
    public void initializeStuff() {
        GameAssets assets = (GameAssets) this.assets;

        clouds = new Cloud[10];
        for (int i = 0; i < clouds.length; i++) {
            clouds[i] = new Cloud(assets.getCloudShadow(), assets.getCloud(), CLOUD_SHADOW_OFFSET);
            clouds[i].setX(HIDDEN_X);
            clouds[i].setSize(CLOUD_WIDTH, CLOUD_HEIGHT);
        }

        grid = new Grid(GRID_COLUMNS, GRID_ROWS, sharedAssets.getSquare());
        for (int column = 0; column < GRID_COLUMNS; column++) {
            for (int row = 0; row < GRID_ROWS; row++) {
                Cell cell = grid.getCells()[column][row];
                cell.setPosition(GRID_X + column * CELL_SIZE, GRID_Y + row * CELL_SIZE);
                cell.setSize(CELL_SIZE);
                cell.setColor((column + row) % 2 == 0 ? DIRT : LIGHT_DIRT);
            }
        }
    }

    public Cloud[] getClouds() {
        return clouds;
    }

    public Grid getGrid() {
        return grid;
    }
}
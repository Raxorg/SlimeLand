package com.epicness.slimeland.game.stuff;

import static com.epicness.fundamentals.SharedConstants.DIRT;
import static com.epicness.fundamentals.SharedConstants.LIGHT_DIRT;
import static com.epicness.fundamentals.SharedConstants.TRANSPARENT;
import static com.epicness.slimeland.SlimeConstants.HIDDEN_X;
import static com.epicness.slimeland.game.GameConstants.CELL_SIZE;
import static com.epicness.slimeland.game.GameConstants.CLOUD_HEIGHT;
import static com.epicness.slimeland.game.GameConstants.CLOUD_SHADOW_OFFSET;
import static com.epicness.slimeland.game.GameConstants.CLOUD_WIDTH;
import static com.epicness.slimeland.game.GameConstants.GRID_COLUMNS;
import static com.epicness.slimeland.game.GameConstants.GRID_ROWS;
import static com.epicness.slimeland.game.GameConstants.GRID_X;
import static com.epicness.slimeland.game.GameConstants.GRID_Y;
import static com.epicness.slimeland.game.GameConstants.SLIME_HEIGHT;
import static com.epicness.slimeland.game.GameConstants.SLIME_STARTING_X;
import static com.epicness.slimeland.game.GameConstants.SLIME_STARTING_Y;
import static com.epicness.slimeland.game.GameConstants.SLIME_WIDTH;

import com.badlogic.gdx.utils.DelayedRemovalArray;
import com.epicness.fundamentals.stuff.Sprited;
import com.epicness.fundamentals.stuff.Stuff;
import com.epicness.fundamentals.stuff.grid.Cell;
import com.epicness.fundamentals.stuff.grid.Grid;
import com.epicness.slimeland.game.GameAssets;
import com.epicness.slimeland.game.stuff.buildmenu.BuildMenu;

public class GameStuff extends Stuff {

    private Grid grid;
    private Sprited cellSelector;
    private DelayedRemovalArray<Slime> slimes;
    private Cloud[] clouds;
    private BuildMenu buildMenu;

    @Override
    public void initializeStuff() {
        GameAssets assets = (GameAssets) this.assets;

        initializeGrid();
        slimes = new DelayedRemovalArray<>();
        for (int i = 0; i < 25; i++) {
            Slime slime = new Slime(assets.getLeftSlime(), assets.getRightSlime());
            slime.setPosition(SLIME_STARTING_X, SLIME_STARTING_Y);
            slime.setSize(SLIME_WIDTH, SLIME_HEIGHT);
            slimes.add(slime);
        }
        initializeCellSelector();
        initializeClouds(assets);
        buildMenu = new BuildMenu(sharedAssets, assets);
    }

    private void initializeGrid() {
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

    private void initializeCellSelector() {
        cellSelector = new Sprited(sharedAssets.getPixel());
        cellSelector.setSize(CELL_SIZE, CELL_SIZE);
        cellSelector.setColor(TRANSPARENT);
    }

    private void initializeClouds(GameAssets assets) {
        clouds = new Cloud[10];
        for (int i = 0; i < clouds.length; i++) {
            clouds[i] = new Cloud(assets.getCloudShadow(), assets.getCloud(), CLOUD_SHADOW_OFFSET);
            clouds[i].setX(HIDDEN_X);
            clouds[i].setSize(CLOUD_WIDTH, CLOUD_HEIGHT);
        }
    }

    // Getters
    public Grid getGrid() {
        return grid;
    }

    public Sprited getCellSelector() {
        return cellSelector;
    }

    public DelayedRemovalArray<Slime> getSlimes() {
        return slimes;
    }

    public Cloud[] getClouds() {
        return clouds;
    }

    public BuildMenu getBuildMenu() {
        return buildMenu;
    }
}
package com.epicness.slimeland.game.stuff;

import static com.epicness.fundamentals.SharedConstants.CAMERA_HEIGHT;
import static com.epicness.fundamentals.SharedConstants.CAMERA_WIDTH;
import static com.epicness.fundamentals.SharedConstants.DIRT;
import static com.epicness.fundamentals.SharedConstants.LIGHT_DIRT;
import static com.epicness.fundamentals.SharedConstants.TRANSPARENT;
import static com.epicness.slimeland.SlimeConstants.HIDDEN_X;
import static com.epicness.slimeland.game.GameConstants.BUSH_HEIGHT;
import static com.epicness.slimeland.game.GameConstants.BUSH_WIDTH;
import static com.epicness.slimeland.game.GameConstants.CELL_SIZE;
import static com.epicness.slimeland.game.GameConstants.CLOUD_HEIGHT;
import static com.epicness.slimeland.game.GameConstants.CLOUD_SHADOW_OFFSET;
import static com.epicness.slimeland.game.GameConstants.CLOUD_WIDTH;
import static com.epicness.slimeland.game.GameConstants.GRID_COLUMNS;
import static com.epicness.slimeland.game.GameConstants.GRID_ROWS;
import static com.epicness.slimeland.game.GameConstants.GRID_SIZE;
import static com.epicness.slimeland.game.GameConstants.GRID_X;
import static com.epicness.slimeland.game.GameConstants.GRID_Y;
import static com.epicness.slimeland.game.GameConstants.SLIME_HEIGHT;
import static com.epicness.slimeland.game.GameConstants.SLIME_STARTING_X;
import static com.epicness.slimeland.game.GameConstants.SLIME_STARTING_Y;
import static com.epicness.slimeland.game.GameConstants.SLIME_WIDTH;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.DelayedRemovalArray;
import com.epicness.fundamentals.stuff.Sprited;
import com.epicness.fundamentals.stuff.Stuff;
import com.epicness.fundamentals.stuff.grid.Cell;
import com.epicness.fundamentals.stuff.grid.Grid;
import com.epicness.slimeland.game.GameAssets;
import com.epicness.slimeland.game.stuff.buildmenu.BuildMenu;

import java.util.ArrayList;
import java.util.List;

public class GameStuff extends Stuff {

    private Grid grid;
    private List<Sprited> bushes;
    private Sprited cellSelector;
    private DelayedRemovalArray<Slime> slimes;
    private Cloud[] clouds;
    private BuildMenu buildMenu;

    @Override
    public void initializeStuff() {
        GameAssets assets = (GameAssets) this.assets;

        initializeGrid();
        initializeBushes(assets);
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

    private void initializeBushes(GameAssets assets) {
        bushes = new ArrayList<>();
        for (int i = 0; i < 25; i++) {
            Sprited bush = new Sprited(assets.getBush());
            bushes.add(bush);
            float x, y;
            do {
                x = MathUtils.random(0, CAMERA_WIDTH);
                y = MathUtils.random(0, CAMERA_HEIGHT);
            } while (x >= GRID_X - BUSH_WIDTH && x <= GRID_X + GRID_SIZE && y >= GRID_Y - BUSH_HEIGHT && y <= GRID_Y + GRID_SIZE);
            bush.setPosition(x, y);
            bush.setSize(BUSH_WIDTH, BUSH_HEIGHT);
            bush.setScale(MathUtils.random(1f, 2.5f));
            bush.setFlip(MathUtils.randomBoolean(), false);
            float randomR = MathUtils.random(0.15f, 0.5f);
            float randomG = MathUtils.random(0.6f, 1f);
            float randomB = MathUtils.random(0.3f);
            Color color = new Color(randomR, randomG, randomB, 1f);
            bush.setColor(color);
        }
        bushes.sort((bush1, bush2) -> Float.compare(bush2.getY(), bush1.getY()));
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
            float scale = MathUtils.random(1f, 1.6f);
            clouds[i].setSize(CLOUD_WIDTH * scale, CLOUD_HEIGHT * scale);
        }
    }

    // Getters
    public Grid getGrid() {
        return grid;
    }

    public List<Sprited> getBushes() {
        return bushes;
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
package com.epicness.slimeland.game.logic;

import static com.epicness.slimeland.game.GameConstants.BUILD_MENU_SPEED;
import static com.epicness.slimeland.game.GameConstants.BUILD_MENU_WIDTH;

import com.epicness.fundamentals.stuff.grid.Cell;
import com.epicness.slimeland.game.stuff.BuildMenu;
import com.epicness.slimeland.game.stuff.GameStuff;

public class BuildMenuHandler {

    // Structure
    private GameStuff stuff;
    // Logic
    private Cell selectedCell;
    private boolean deploying, hiding, deployed;

    public void setup() {
        stuff.getBuildMenu().setX(-BUILD_MENU_WIDTH);
    }

    public void update(float delta) {
        BuildMenu buildMenu = stuff.getBuildMenu();
        if (deploying) {
            buildMenu.translateX(BUILD_MENU_SPEED * delta);
            if (buildMenu.getX() >= 0f) {
                buildMenu.setX(0f);
                deploying = false;
                deployed = true;
            }
        }
        if (hiding) {
            buildMenu.translateX(-BUILD_MENU_SPEED * delta);
            if (buildMenu.getX() <= -BUILD_MENU_WIDTH) {
                buildMenu.setX(-BUILD_MENU_WIDTH);
                hiding = false;
            }
        }
    }

    public void show(Cell cell) {
        selectedCell = cell;
        if (deployed || deploying) {
            return;
        }
        deploying = true;
    }

    public void hide() {
        deploying = false;
        deployed = false;
        hiding = true;
    }

    // Structure
    public void setStuff(GameStuff stuff) {
        this.stuff = stuff;
    }
}
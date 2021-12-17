package com.epicness.slimeland.game.logic.machines;

import static com.epicness.slimeland.game.GameConstants.BUILD_MENU_SPEED;
import static com.epicness.slimeland.game.GameConstants.BUILD_MENU_WIDTH;

import com.epicness.fundamentals.stuff.grid.Cell;
import com.epicness.slimeland.game.logic.GameLogic;
import com.epicness.slimeland.game.stuff.GameStuff;
import com.epicness.slimeland.game.stuff.buildmenu.BuildMenu;
import com.epicness.slimeland.game.stuff.buildmenu.BuildOption;

public class BuildMenuHandler {

    // Structure
    private GameLogic logic;
    private GameStuff stuff;
    // Logic
    private boolean deploying, hiding, deployed;
    private Cell selectedCell;

    public void setup() {
        stuff.getBuildMenu().setX(-BUILD_MENU_WIDTH);
    }

    public void show(Cell selectedCell) {
        this.selectedCell = selectedCell;
        if (deployed || deploying) {
            return;
        }
        deploying = true;
    }

    public void hide() {
        selectedCell = null;
        deploying = false;
        deployed = false;
        hiding = true;
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

    public void touchUp(float x, float y) {
        BuildOption[] options = stuff.getBuildMenu().getOptions();
        for (int i = 0; i < options.length; i++) {
            BuildOption option = options[i];
            if (option.contains(x, y)) {
                logic.getBuildingHandler().buildWithCharge(option.getMachineType(), selectedCell);
                return;
            }
        }
    }

    // Structure
    public void setLogic(GameLogic logic) {
        this.logic = logic;
    }

    public void setStuff(GameStuff stuff) {
        this.stuff = stuff;
    }
}
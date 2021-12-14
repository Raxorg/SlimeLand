package com.epicness.slimeland.menu.logic;

import static com.epicness.slimeland.menu.MenuConstants.CHECK_SIZE;
import static com.epicness.slimeland.menu.MenuConstants.HIDDEN_X;
import static com.epicness.slimeland.menu.MenuConstants.HIDDEN_Y;
import static com.epicness.slimeland.menu.MenuConstants.SLIME_COLUMNS;
import static com.epicness.slimeland.menu.MenuConstants.SLIME_GRID_SCROLL_MAX_Y;
import static com.epicness.slimeland.menu.MenuConstants.SLIME_GRID_SCROLL_MIN_Y;
import static com.epicness.slimeland.menu.MenuConstants.SLIME_ROWS;

import com.badlogic.gdx.graphics.Color;
import com.epicness.fundamentals.stuff.DualSprited;
import com.epicness.slimeland.menu.stuff.MenuStuff;

public class SlimeGridHandler {

    // Structure
    private MenuLogic logic;
    private MenuStuff stuff;
    // Logic
    private DualSprited selectedSlime;
    private boolean ignoreTouchUp;

    public void setup() {
        stuff.getSlimeSelector().setPosition(HIDDEN_X, HIDDEN_Y);
        stuff.getSlimeSelector().setColor(Color.WHITE);
        logic.getScrollBehavior().setup(stuff.getSlimeGrid(), SLIME_GRID_SCROLL_MIN_Y, SLIME_GRID_SCROLL_MAX_Y);
        selectedSlime = null;
    }

    public void update() {
        if (selectedSlime == null) {
            return;
        }
        float yPosition = selectedSlime.getY() + selectedSlime.getHeight() / 2f - CHECK_SIZE / 2f;
        stuff.getSlimeSelector().setPosition(selectedSlime.getX(), yPosition);
    }

    public void touchDown(float x, float y) {
        if (selectedSlime == null) {
            return;
        }
        if (selectedSlime.contains(x, y)) {
            stuff.getSlimeSelector().setColor(Color.GREEN);
        }
    }

    public void touchDragged(float x, float y) {
        ignoreTouchUp = true;
        if (selectedSlime == null) {
            return;
        }
        if (!selectedSlime.contains(x, y)) {
            stuff.getSlimeSelector().setColor(Color.WHITE);
        }
    }

    public void touchUp(float x, float y) {
        if (ignoreTouchUp) {
            ignoreTouchUp = false;
            return;
        }
        DualSprited[][] slimes = stuff.getSlimeGrid().getSlimes();
        stuff.getSlimeSelector().setPosition(HIDDEN_X, HIDDEN_Y);
        for (int column = 0; column < SLIME_COLUMNS; column++) {
            for (int row = 0; row < SLIME_ROWS; row++) {
                DualSprited slime = slimes[column][row];
                if (slime.contains(x, y)) {
                    slimeSelected(slime);
                    return;
                }
            }
        }
        selectedSlime = null;
    }

    private void slimeSelected(DualSprited slime) {
        if (selectedSlime == slime) {
            logic.getColorSelectionHandler().claimColorPair(slime.getBackgroundColor(), slime.getForegroundColor());
            return;
        }
        float yPosition = slime.getY() + slime.getHeight() / 2f - CHECK_SIZE / 2f;
        stuff.getSlimeSelector().setPosition(slime.getX(), yPosition);
        selectedSlime = slime;
    }

    // Structure
    public void setLogic(MenuLogic logic) {
        this.logic = logic;
    }

    public void setStuff(MenuStuff stuff) {
        this.stuff = stuff;
    }
}
package com.epicness.slimeland.menu.logic;

import static com.epicness.fundamentals.utils.ColorUtils.stringFromColor;
import static com.epicness.slimeland.SlimeConstants.HIDDEN_X;
import static com.epicness.slimeland.SlimeConstants.HIDDEN_Y;
import static com.epicness.slimeland.menu.MenuConstants.CHECK_SIZE;
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
    private boolean ignoreTouchUp, inputDisabled;

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
        if (inputDisabled) {
            return;
        }
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
        if (slime.getBackgroundColor().equals(Color.BLACK)) {
            selectedSlime = null;
            return;
        }
        if (selectedSlime == slime) {
            String color1 = stringFromColor(slime.getBackgroundColor());
            String color2 = stringFromColor(slime.getForegroundColor());
            logic.getPlayerRegistrator().assignPlayerColors(color1 + "-" + color2);
            logic.getPlayerRegistrator().registerPlayer();
            return;
        }
        float yPosition = slime.getY() + slime.getHeight() / 2f - CHECK_SIZE / 2f;
        stuff.getSlimeSelector().setPosition(slime.getX(), yPosition);
        selectedSlime = slime;
    }

    public void disableInput() {
        inputDisabled = true;
    }

    public void updateAvailableColors(String[] availableColorPairs) {
        DualSprited[][] slimes = stuff.getSlimeGrid().getSlimes();
        for (int column = 0; column < SLIME_COLUMNS; column++) {
            slimeFor:
            for (int row = 0; row < SLIME_ROWS; row++) {
                DualSprited slime = slimes[column][row];
                String slimeColor1 = stringFromColor(slime.getBackgroundColor());
                String slimeColor2 = stringFromColor(slime.getForegroundColor());
                for (int i = 0; i < availableColorPairs.length; i++) {
                    String availableColorPair = availableColorPairs[i];
                    String[] availableColors = availableColorPair.split("-");
                    String color1 = availableColors[0];
                    String color2 = availableColors[1];
                    if (slimeColor1.equals(color1) && slimeColor2.equals(color2)) {
                        continue slimeFor;
                    }
                }
                slime.setColor(Color.BLACK);
            }
        }
    }

    // Structure
    public void setLogic(MenuLogic logic) {
        this.logic = logic;
    }

    public void setStuff(MenuStuff stuff) {
        this.stuff = stuff;
    }
}
package com.epicness.slimeland.menu.stuff;

import static com.epicness.slimeland.menu.MenuConstants.SLIME_COLUMNS;
import static com.epicness.slimeland.menu.MenuConstants.SLIME_GRID_STARTING_Y;
import static com.epicness.slimeland.menu.MenuConstants.SLIME_GRID_X_PADDING;
import static com.epicness.slimeland.menu.MenuConstants.SLIME_OPTION_HEIGHT;
import static com.epicness.slimeland.menu.MenuConstants.SLIME_ROWS;
import static com.epicness.slimeland.menu.MenuConstants.SLIME_SPACING;
import static com.epicness.slimeland.menu.MenuConstants.SLIME_OPTION_WIDTH;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.epicness.fundamentals.stuff.DualSprited;
import com.epicness.fundamentals.stuff.Scrollable;
import com.epicness.slimeland.menu.MenuAssets;

public class SlimeGrid implements Scrollable {

    private final DualSprited[][] slimes;

    public SlimeGrid(MenuAssets assets) {
        Color[] colors = new Color[]{
                Color.WHITE, Color.RED, Color.PURPLE, Color.SALMON, Color.ORANGE, Color.YELLOW, Color.OLIVE,
                Color.CHARTREUSE, Color.FOREST, Color.TEAL, Color.CYAN, Color.BLUE, Color.BROWN, Color.MAGENTA, Color.GRAY
        };

        Color[] pairs = new Color[SLIME_COLUMNS * SLIME_ROWS * 2];
        int index = 0;
        for (int i = 0; i < colors.length; i++) {
            for (int j = i + 1; j < colors.length; j++, index += 2) {
                pairs[index] = colors[i];
                pairs[index + 1] = colors[j];
            }
        }

        slimes = new DualSprited[SLIME_COLUMNS][];
        for (int column = 0; column < SLIME_COLUMNS; column++) {
            slimes[column] = new DualSprited[SLIME_ROWS];
            for (int row = 0; row < SLIME_ROWS; row++) {
                slimes[column][row] = new DualSprited(assets.getSlimeLeftHalf(), assets.getSlimeRightHalf());
                DualSprited slime = slimes[column][row];
                slime.setX(SLIME_GRID_X_PADDING + (SLIME_OPTION_WIDTH + SLIME_SPACING) * column);
                slime.setY(SLIME_GRID_STARTING_Y - (SLIME_OPTION_HEIGHT + SLIME_SPACING) * row);
                slime.setSize(SLIME_OPTION_WIDTH, SLIME_OPTION_HEIGHT);
                index = (column * SLIME_ROWS + row) * 2;
                slime.setBackgroundColor(pairs[index]);
                slime.setForegroundColor(pairs[index + 1]);
            }
        }
    }


    public void draw(SpriteBatch spriteBatch) {
        for (int column = 0; column < SLIME_COLUMNS; column++) {
            for (int row = 0; row < SLIME_ROWS; row++) {
                slimes[column][row].draw(spriteBatch);
            }
        }
    }

    @Override
    public float getY() {
        return slimes[0][0].getY();
    }

    @Override
    public void setY(float y) {
        for (int column = 0; column < SLIME_COLUMNS; column++) {
            for (int row = 0; row < SLIME_ROWS; row++) {
                slimes[column][row].setY(y - (SLIME_OPTION_HEIGHT + SLIME_SPACING) * row);
            }
        }
    }

    @Override
    public void translateY(float y) {
        for (int column = 0; column < SLIME_COLUMNS; column++) {
            for (int row = 0; row < SLIME_ROWS; row++) {
                slimes[column][row].translateY(y);
            }
        }
    }

    public DualSprited[][] getSlimes() {
        return slimes;
    }
}
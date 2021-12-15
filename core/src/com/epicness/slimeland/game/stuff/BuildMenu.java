package com.epicness.slimeland.game.stuff;

import static com.epicness.fundamentals.SharedConstants.TRANSPARENT;
import static com.epicness.slimeland.game.GameConstants.BUILD_MENU_HEIGHT;
import static com.epicness.slimeland.game.GameConstants.BUILD_MENU_WIDTH;
import static com.epicness.slimeland.game.GameConstants.BUILD_OPTION_SIZE;
import static com.epicness.slimeland.game.GameConstants.BUILD_OPTION_X_OFFSET;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.epicness.fundamentals.assets.SharedAssets;
import com.epicness.fundamentals.stuff.DualSprited;
import com.epicness.fundamentals.stuff.Sprited;
import com.epicness.slimeland.game.GameAssets;

public class BuildMenu extends Sprited {

    private final DualSprited[] options;

    public BuildMenu(SharedAssets sharedAssets, GameAssets assets) {
        super(sharedAssets.getPixel());
        sprite.setSize(BUILD_MENU_WIDTH, BUILD_MENU_HEIGHT);
        sprite.setColor(TRANSPARENT);

        options = new DualSprited[2];
        options[0] = new DualSprited(assets.getFactoryLeft(), assets.getFactoryRight());
        options[1] = new DualSprited(assets.getTowerLeft(), assets.getTowerRight());
        float spacing = (BUILD_MENU_HEIGHT - (BUILD_OPTION_SIZE / 2f * options.length)) / (options.length + 1);
        for (int i = 0; i < options.length; i++) {
            options[i].setSize(BUILD_OPTION_SIZE);
            options[i].setY(spacing * (i + 1));
        }
    }

    @Override
    public void draw(SpriteBatch spriteBatch) {
        super.draw(spriteBatch);
        for (int i = 0; i < options.length; i++) {
            options[i].draw(spriteBatch);
        }
    }

    @Override
    public void setX(float x) {
        super.setX(x);
        for (int i = 0; i < options.length; i++) {
            options[i].setX(x + BUILD_OPTION_X_OFFSET);
        }
    }

    @Override
    public void translateX(float amount) {
        super.translateX(amount);
        for (int i = 0; i < options.length; i++) {
            options[i].translateX(amount);
        }
    }

    public void setColors(Color color1, Color color2) {
        for (int i = 0; i < options.length; i++) {
            options[i].setBackgroundColor(color1);
            options[i].setForegroundColor(color2);
        }
    }
}
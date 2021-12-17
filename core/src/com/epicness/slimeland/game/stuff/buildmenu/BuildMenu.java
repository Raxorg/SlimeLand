package com.epicness.slimeland.game.stuff.buildmenu;

import static com.epicness.fundamentals.SharedConstants.TRANSPARENT;
import static com.epicness.fundamentals.SharedConstants.WHITE_OPAQUE_TRANSPARENT;
import static com.epicness.slimeland.game.GameConstants.BUILD_CHARGES_FRAME_SIZE;
import static com.epicness.slimeland.game.GameConstants.BUILD_CHARGES_FRAME_X_OFFSET;
import static com.epicness.slimeland.game.GameConstants.BUILD_CHARGES_FRAME_Y;
import static com.epicness.slimeland.game.GameConstants.BUILD_MENU_HEIGHT;
import static com.epicness.slimeland.game.GameConstants.BUILD_MENU_WIDTH;
import static com.epicness.slimeland.game.GameConstants.BUILD_OPTION_SIZE;
import static com.epicness.slimeland.game.GameConstants.BUILD_OPTION_SPACING;
import static com.epicness.slimeland.game.GameConstants.BUILD_OPTION_X_OFFSET;
import static com.epicness.slimeland.game.GameConstants.FACTORY_ID;
import static com.epicness.slimeland.game.GameConstants.OPTIONS;
import static com.epicness.slimeland.game.GameConstants.TOWER_ID;
import static com.epicness.slimeland.game.GameConstants.WORKSHOP_ID;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.epicness.fundamentals.assets.SharedAssets;
import com.epicness.fundamentals.stuff.DualSprited;
import com.epicness.fundamentals.stuff.Sprited;
import com.epicness.fundamentals.stuff.SpritedText;
import com.epicness.slimeland.game.GameAssets;

public class BuildMenu extends Sprited {

    private final SpritedText buildChargesFrame;
    private final DualSprited[] options;

    public BuildMenu(SharedAssets sharedAssets, GameAssets assets) {
        super(sharedAssets.getPixel());
        setSize(BUILD_MENU_WIDTH, BUILD_MENU_HEIGHT);
        setColor(TRANSPARENT);

        buildChargesFrame = new SpritedText(sharedAssets.getSquare(), assets.getPixelFont());
        buildChargesFrame.setY(BUILD_CHARGES_FRAME_Y);
        buildChargesFrame.setSize(BUILD_CHARGES_FRAME_SIZE);
        buildChargesFrame.setColor(WHITE_OPAQUE_TRANSPARENT);

        options = new DualSprited[OPTIONS];
        options[FACTORY_ID] = new DualSprited(assets.getFactoryLeft(), assets.getFactoryRight());
        options[WORKSHOP_ID] = new DualSprited(assets.getFactoryLeft(), assets.getTowerRight());
        options[TOWER_ID] = new DualSprited(assets.getTowerLeft(), assets.getTowerRight());
        for (int i = 0; i < options.length; i++) {
            options[i].setSize(BUILD_OPTION_SIZE);
            options[i].setY(BUILD_OPTION_SPACING * (i + 1) + BUILD_OPTION_SIZE * i);
        }
    }

    @Override
    public void draw(SpriteBatch spriteBatch) {
        super.draw(spriteBatch);
        buildChargesFrame.draw(spriteBatch);
        for (int i = 0; i < options.length; i++) {
            options[i].draw(spriteBatch);
        }
    }

    @Override
    public void setX(float x) {
        super.setX(x);
        buildChargesFrame.setX(x + BUILD_CHARGES_FRAME_X_OFFSET);
        for (int i = 0; i < options.length; i++) {
            options[i].setX(x + BUILD_OPTION_X_OFFSET);
        }
    }

    @Override
    public void translateX(float amount) {
        super.translateX(amount);
        buildChargesFrame.translateX(amount);
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

    public int getBuildCharges() {
        return Integer.parseInt(buildChargesFrame.getText());
    }

    public void setBuildCharges(int buildCharges) {
        buildChargesFrame.setText(buildCharges + "");
    }

    public DualSprited[] getOptions() {
        return options;
    }
}
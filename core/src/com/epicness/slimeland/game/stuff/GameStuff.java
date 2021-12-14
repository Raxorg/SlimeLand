package com.epicness.slimeland.game.stuff;

import static com.epicness.slimeland.game.GameConstants.CLOUD_HEIGHT;
import static com.epicness.slimeland.game.GameConstants.CLOUD_SHADOW_OFFSET;
import static com.epicness.slimeland.game.GameConstants.CLOUD_WIDTH;
import static com.epicness.slimeland.game.GameConstants.HIDDEN_X;

import com.epicness.fundamentals.stuff.Stuff;
import com.epicness.slimeland.game.GameAssets;

public class GameStuff extends Stuff {

    private Cloud[] clouds;

    @Override
    public void initializeStuff() {
        GameAssets assets = (GameAssets) this.assets;

        clouds = new Cloud[10];
        for (int i = 0; i < clouds.length; i++) {
            clouds[i] = new Cloud(assets.getCloudShadow(), assets.getCloud(), CLOUD_SHADOW_OFFSET);
            clouds[i].setX(HIDDEN_X);
            clouds[i].setSize(CLOUD_WIDTH, CLOUD_HEIGHT);
        }
    }

    public Cloud[] getClouds() {
        return clouds;
    }
}
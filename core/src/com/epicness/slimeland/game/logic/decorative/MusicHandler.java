package com.epicness.slimeland.game.logic.decorative;

import com.epicness.slimeland.game.GameAssets;

public class MusicHandler {

    private GameAssets assets;

    public void playMusic() {
        assets.getChillMusic().setLooping(true);
        assets.getChillMusic().play();
    }

    public void setAssets(GameAssets assets) {
        this.assets = assets;
    }
}
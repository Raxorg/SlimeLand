package com.epicness.slimeland.game;

import static com.epicness.slimeland.AssetPaths.SLIME_PATH;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.epicness.fundamentals.assets.Assets;

public class GameAssets extends Assets {

    private Sprite slime;

    @Override
    public void queueAssetLoading() {
        assetManager.load(SLIME_PATH, Texture.class);
    }

    @Override
    public void initializeAssets() {
        slime = new Sprite(assetManager.get(SLIME_PATH, Texture.class));
    }

    public Sprite getSlime() {
        return slime;
    }
}
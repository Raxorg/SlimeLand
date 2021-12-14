package com.epicness.slimeland.game;

import static com.epicness.slimeland.AssetPaths.CLOUD_PATH;
import static com.epicness.slimeland.AssetPaths.CLOUD_SHADOW_PATH;
import static com.epicness.slimeland.AssetPaths.SLIME_PATH;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.epicness.fundamentals.assets.Assets;

public class GameAssets extends Assets {

    // Sprites
    private Sprite slime, cloud, cloudShadow;

    @Override
    public void queueAssetLoading() {
        assetManager.load(SLIME_PATH, Texture.class);
        assetManager.load(CLOUD_PATH, Texture.class);
        assetManager.load(CLOUD_SHADOW_PATH, Texture.class);
    }

    @Override
    public void initializeAssets() {
        slime = new Sprite(assetManager.get(SLIME_PATH, Texture.class));
        cloud = new Sprite(assetManager.get(CLOUD_PATH, Texture.class));
        cloudShadow = new Sprite(assetManager.get(CLOUD_SHADOW_PATH, Texture.class));
    }

    // Sprites
    public Sprite getSlime() {
        return slime;
    }

    public Sprite getCloud() {
        return cloud;
    }

    public Sprite getCloudShadow() {
        return cloudShadow;
    }
}
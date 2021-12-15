package com.epicness.slimeland.game;

import static com.epicness.slimeland.AssetPaths.BLUE_ORNAMENT_PATH;
import static com.epicness.slimeland.AssetPaths.CLOUD_PATH;
import static com.epicness.slimeland.AssetPaths.CLOUD_SHADOW_PATH;
import static com.epicness.slimeland.AssetPaths.FACTORY_LEFT_PATH;
import static com.epicness.slimeland.AssetPaths.FACTORY_RIGHT_PATH;
import static com.epicness.slimeland.AssetPaths.GREEN_ORNAMENT_PATH;
import static com.epicness.slimeland.AssetPaths.ORANGE_ORNAMENT_PATH;
import static com.epicness.slimeland.AssetPaths.PURPLE_ORNAMENT_PATH;
import static com.epicness.slimeland.AssetPaths.RED_ORNAMENT_PATH;
import static com.epicness.slimeland.AssetPaths.SLIME_LEFT_HALF_PATH;
import static com.epicness.slimeland.AssetPaths.SLIME_RIGHT_HALF_PATH;
import static com.epicness.slimeland.AssetPaths.TOWER_LEFT_PATH;
import static com.epicness.slimeland.AssetPaths.TOWER_RIGHT_PATH;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.epicness.fundamentals.assets.Assets;

public class GameAssets extends Assets {

    // Sprites
    private Sprite leftSlime, rightSlime, cloud, cloudShadow;
    private Sprite factoryLeft, factoryRight, towerLeft, towerRight;
    private Sprite blueOrnament, greenOrnament, orangeOrnament, purpleOrnament, redOrnament;

    @Override
    public void queueAssetLoading() {
        assetManager.load(SLIME_LEFT_HALF_PATH, Texture.class);
        assetManager.load(SLIME_RIGHT_HALF_PATH, Texture.class);
        assetManager.load(CLOUD_PATH, Texture.class);
        assetManager.load(CLOUD_SHADOW_PATH, Texture.class);

        assetManager.load(FACTORY_LEFT_PATH, Texture.class);
        assetManager.load(FACTORY_RIGHT_PATH, Texture.class);
        assetManager.load(TOWER_LEFT_PATH, Texture.class);
        assetManager.load(TOWER_RIGHT_PATH, Texture.class);

        assetManager.load(BLUE_ORNAMENT_PATH, Texture.class);
        assetManager.load(GREEN_ORNAMENT_PATH, Texture.class);
        assetManager.load(ORANGE_ORNAMENT_PATH, Texture.class);
        assetManager.load(PURPLE_ORNAMENT_PATH, Texture.class);
        assetManager.load(RED_ORNAMENT_PATH, Texture.class);
    }

    @Override
    public void initializeAssets() {
        leftSlime = new Sprite(assetManager.get(SLIME_LEFT_HALF_PATH, Texture.class));
        rightSlime = new Sprite(assetManager.get(SLIME_RIGHT_HALF_PATH, Texture.class));
        cloud = new Sprite(assetManager.get(CLOUD_PATH, Texture.class));
        cloudShadow = new Sprite(assetManager.get(CLOUD_SHADOW_PATH, Texture.class));

        factoryLeft = new Sprite(assetManager.get(FACTORY_LEFT_PATH, Texture.class));
        factoryRight = new Sprite(assetManager.get(FACTORY_RIGHT_PATH, Texture.class));
        towerLeft = new Sprite(assetManager.get(TOWER_LEFT_PATH, Texture.class));
        towerRight = new Sprite(assetManager.get(TOWER_RIGHT_PATH, Texture.class));

        blueOrnament = new Sprite(assetManager.get(BLUE_ORNAMENT_PATH, Texture.class));
        greenOrnament = new Sprite(assetManager.get(BLUE_ORNAMENT_PATH, Texture.class));
        orangeOrnament = new Sprite(assetManager.get(BLUE_ORNAMENT_PATH, Texture.class));
        purpleOrnament = new Sprite(assetManager.get(PURPLE_ORNAMENT_PATH, Texture.class));
        redOrnament = new Sprite(assetManager.get(BLUE_ORNAMENT_PATH, Texture.class));
    }

    // Sprites
    public Sprite getLeftSlime() {
        return leftSlime;
    }

    public Sprite getRightSlime() {
        return rightSlime;
    }

    public Sprite getCloud() {
        return cloud;
    }

    public Sprite getCloudShadow() {
        return cloudShadow;
    }

    public Sprite getFactoryLeft() {
        return factoryLeft;
    }

    public Sprite getFactoryRight() {
        return factoryRight;
    }

    public Sprite getTowerLeft() {
        return towerLeft;
    }

    public Sprite getTowerRight() {
        return towerRight;
    }

    public Sprite getBlueOrnament() {
        return blueOrnament;
    }

    public Sprite getGreenOrnament() {
        return greenOrnament;
    }

    public Sprite getOrangeOrnament() {
        return orangeOrnament;
    }

    public Sprite getPurpleOrnament() {
        return purpleOrnament;
    }

    public Sprite getRedOrnament() {
        return redOrnament;
    }
}
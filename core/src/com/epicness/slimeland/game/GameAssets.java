package com.epicness.slimeland.game;

import static com.epicness.slimeland.AssetPaths.BIGGER_PIXEL_FONT_PATH;
import static com.epicness.slimeland.AssetPaths.BLUE_ORNAMENT_PATH;
import static com.epicness.slimeland.AssetPaths.BUSH_PATH;
import static com.epicness.slimeland.AssetPaths.CHILL_MUSIC_PATH;
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
import static com.epicness.slimeland.AssetPaths.WORKSHOP_EXTERIOR_PATH;
import static com.epicness.slimeland.AssetPaths.WORKSHOP_INTERIOR_PATH;

import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.epicness.fundamentals.assets.Assets;

public class GameAssets extends Assets {

    // Audio
    private Music chillMusic;
    // Fonts
    private BitmapFont pixelFont;
    // Sprites
    private Sprite leftSlime, rightSlime, cloud, cloudShadow, bush;
    private Sprite factoryLeft, factoryRight, workshopExterior, workshopInterior, towerLeft, towerRight;
    private Sprite blueOrnament, greenOrnament, orangeOrnament, purpleOrnament, redOrnament;

    @Override
    public void queueAssetLoading() {
        // Audio
        assetManager.load(CHILL_MUSIC_PATH, Music.class);
        // Fonts
        assetManager.load(BIGGER_PIXEL_FONT_PATH, BitmapFont.class);
        // Sprites
        assetManager.load(SLIME_LEFT_HALF_PATH, Texture.class);
        assetManager.load(SLIME_RIGHT_HALF_PATH, Texture.class);
        assetManager.load(CLOUD_PATH, Texture.class);
        assetManager.load(CLOUD_SHADOW_PATH, Texture.class);
        assetManager.load(BUSH_PATH, Texture.class);

        assetManager.load(FACTORY_LEFT_PATH, Texture.class);
        assetManager.load(FACTORY_RIGHT_PATH, Texture.class);
        assetManager.load(WORKSHOP_EXTERIOR_PATH, Texture.class);
        assetManager.load(WORKSHOP_INTERIOR_PATH, Texture.class);
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
        // Audio
        chillMusic = assetManager.get(CHILL_MUSIC_PATH, Music.class);
        // Fonts
        pixelFont = assetManager.get(BIGGER_PIXEL_FONT_PATH, BitmapFont.class);
        pixelFont.getData().setScale(5f);
        // Sprites
        leftSlime = new Sprite(assetManager.get(SLIME_LEFT_HALF_PATH, Texture.class));
        rightSlime = new Sprite(assetManager.get(SLIME_RIGHT_HALF_PATH, Texture.class));
        cloud = new Sprite(assetManager.get(CLOUD_PATH, Texture.class));
        cloudShadow = new Sprite(assetManager.get(CLOUD_SHADOW_PATH, Texture.class));
        bush = new Sprite(assetManager.get(BUSH_PATH, Texture.class));

        factoryLeft = new Sprite(assetManager.get(FACTORY_LEFT_PATH, Texture.class));
        factoryRight = new Sprite(assetManager.get(FACTORY_RIGHT_PATH, Texture.class));
        workshopExterior = new Sprite(assetManager.get(WORKSHOP_EXTERIOR_PATH, Texture.class));
        workshopInterior = new Sprite(assetManager.get(WORKSHOP_INTERIOR_PATH, Texture.class));
        towerLeft = new Sprite(assetManager.get(TOWER_LEFT_PATH, Texture.class));
        towerRight = new Sprite(assetManager.get(TOWER_RIGHT_PATH, Texture.class));

        blueOrnament = new Sprite(assetManager.get(BLUE_ORNAMENT_PATH, Texture.class));
        greenOrnament = new Sprite(assetManager.get(BLUE_ORNAMENT_PATH, Texture.class));
        orangeOrnament = new Sprite(assetManager.get(BLUE_ORNAMENT_PATH, Texture.class));
        purpleOrnament = new Sprite(assetManager.get(PURPLE_ORNAMENT_PATH, Texture.class));
        redOrnament = new Sprite(assetManager.get(BLUE_ORNAMENT_PATH, Texture.class));
    }

    // Audio
    public Music getChillMusic() {
        return chillMusic;
    }

    // Fonts
    public BitmapFont getPixelFont() {
        return pixelFont;
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

    public Sprite getBush() {
        return bush;
    }

    public Sprite getFactoryLeft() {
        return factoryLeft;
    }

    public Sprite getFactoryRight() {
        return factoryRight;
    }

    public Sprite getWorkshopExterior() {
        return workshopExterior;
    }

    public Sprite getWorkshopInterior() {
        return workshopInterior;
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
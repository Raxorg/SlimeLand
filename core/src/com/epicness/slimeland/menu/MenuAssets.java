package com.epicness.slimeland.menu;

import static com.epicness.fundamentals.SharedConstants.PIXEL_FONT_PATH;
import static com.epicness.slimeland.AssetPaths.BIGGER_PIXEL_FONT_PATH;
import static com.epicness.slimeland.AssetPaths.CHECK_PATH;
import static com.epicness.slimeland.AssetPaths.SLIME_LEFT_HALF_PATH;
import static com.epicness.slimeland.AssetPaths.SLIME_RIGHT_HALF_PATH;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.epicness.fundamentals.assets.Assets;

public class MenuAssets extends Assets {

    // Fonts
    private BitmapFont pixelFont, biggerPixelFont;
    // Sprites
    private Sprite slimeLeftHalf, slimeRightHalf, check;

    @Override
    public void queueAssetLoading() {
        // Fonts
        assetManager.load(PIXEL_FONT_PATH, BitmapFont.class);
        assetManager.load(BIGGER_PIXEL_FONT_PATH, BitmapFont.class);
        // Sprites
        assetManager.load(SLIME_LEFT_HALF_PATH, Texture.class);
        assetManager.load(SLIME_RIGHT_HALF_PATH, Texture.class);
        assetManager.load(CHECK_PATH, Texture.class);
    }

    @Override
    public void initializeAssets() {
        // Fonts
        pixelFont = assetManager.get(PIXEL_FONT_PATH, BitmapFont.class);
        pixelFont.getData().setScale(6f);
        biggerPixelFont = assetManager.get(BIGGER_PIXEL_FONT_PATH, BitmapFont.class);
        biggerPixelFont.getData().setScale(10f);
        // Sprites
        slimeLeftHalf = new Sprite(assetManager.get(SLIME_LEFT_HALF_PATH, Texture.class));
        slimeRightHalf = new Sprite(assetManager.get(SLIME_RIGHT_HALF_PATH, Texture.class));
        check = new Sprite(assetManager.get(CHECK_PATH, Texture.class));
    }

    // Fonts
    public BitmapFont getPixelFont() {
        return pixelFont;
    }

    public BitmapFont getBiggerPixelFont() {
        return biggerPixelFont;
    }

    // Sprites
    public Sprite getSlimeLeftHalf() {
        return slimeLeftHalf;
    }

    public Sprite getSlimeRightHalf() {
        return slimeRightHalf;
    }

    public Sprite getCheck() {
        return check;
    }
}
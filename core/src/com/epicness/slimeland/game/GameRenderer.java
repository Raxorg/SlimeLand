package com.epicness.slimeland.game;

import static com.epicness.fundamentals.SharedConstants.GRASS;

import com.badlogic.gdx.utils.ScreenUtils;
import com.epicness.fundamentals.renderer.Renderer;
import com.epicness.slimeland.game.stuff.GameStuff;

public class GameRenderer extends Renderer {

    @Override
    public void render() {
        GameStuff stuff = (GameStuff) this.stuff;

        ScreenUtils.clear(GRASS);

        spriteBatch.setProjectionMatrix(screen.getStaticCamera().combined);

        spriteBatch.begin();
        for (int i = 0; i < stuff.getClouds().length; i++) {
            stuff.getClouds()[i].drawBackground(spriteBatch);
        }
        for (int i = 0; i < stuff.getClouds().length; i++) {
            stuff.getClouds()[i].drawForeground(spriteBatch);
        }
        spriteBatch.end();
    }
}
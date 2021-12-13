package com.epicness.slimeland.menu;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.utils.ScreenUtils;
import com.epicness.fundamentals.renderer.Renderer;
import com.epicness.slimeland.menu.stuff.MenuStuff;

public class MenuRenderer extends Renderer {

    @Override
    public void render() {
        MenuStuff stuff = (MenuStuff) this.stuff;

        ScreenUtils.clear(Color.WHITE);

        spriteBatch.setProjectionMatrix(screen.getStaticCamera().combined);

        spriteBatch.begin();
        stuff.getSlimeGrid().draw(spriteBatch);
        stuff.getSlimeSelector().draw(spriteBatch);
        stuff.getChooseText().draw(spriteBatch);
        stuff.getLoadingOverlay().draw(spriteBatch);
        spriteBatch.end();
    }
}
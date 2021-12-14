package com.epicness.slimeland.game;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.utils.ScreenUtils;
import com.epicness.fundamentals.renderer.Renderer;

public class GameRenderer extends Renderer {
    @Override
    public void render() {
        ScreenUtils.clear(Color.GREEN);
    }
}
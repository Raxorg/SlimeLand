package com.epicness.slimeland.game.stuff.machines;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.epicness.fundamentals.stuff.Text;

public class Factory extends Machine {

    private final Text counter;

    public Factory(Sprite leftSprite, Sprite rightSprite, BitmapFont font) {
        super(leftSprite, rightSprite);
        counter = new Text(font);
    }

    @Override
    public void draw(SpriteBatch spriteBatch) {
        super.draw(spriteBatch);
        counter.draw(spriteBatch);
    }
}
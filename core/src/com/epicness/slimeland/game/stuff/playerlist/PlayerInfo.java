package com.epicness.slimeland.game.stuff.playerlist;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.epicness.fundamentals.stuff.DualSprited;
import com.epicness.fundamentals.stuff.Scrollable;
import com.epicness.fundamentals.stuff.Sprited;
import com.epicness.fundamentals.stuff.Text;

public class PlayerInfo implements Scrollable {

    private final Sprited background;
    private final Text name, quantity;
    private final DualSprited slime;

    public PlayerInfo(Sprite backgroundSprite, BitmapFont font, Sprite leftSlime, Sprite rightSlime, String playerName,
                      Color leftColor, Color rightColor, int slimeQuantity) {
        background = new Sprited(backgroundSprite);
        name = new Text(font);
        slime = new DualSprited(leftSlime, rightSlime);
        quantity = new Text(font);
    }

    public void draw(SpriteBatch spriteBatch) {
        background.draw(spriteBatch);
        name.draw(spriteBatch);
        slime.draw(spriteBatch);
        quantity.draw(spriteBatch);
    }

    @Override
    public float getY() {
        return background.getY();
    }

    @Override
    public void setY(float y) {
        background.setY(y);
        name.setY(y);
        quantity.setY(y);
        slime.setY(y);
    }

    @Override
    public void translateY(float y) {
        background.translateY(y);
        name.translateY(y);
        quantity.translateY(y);
        slime.translateY(y);
    }
}
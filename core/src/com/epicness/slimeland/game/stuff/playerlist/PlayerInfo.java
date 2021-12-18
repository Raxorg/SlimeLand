package com.epicness.slimeland.game.stuff.playerlist;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.epicness.fundamentals.stuff.DualSprited;
import com.epicness.fundamentals.stuff.Text;

public class PlayerInfo {

    private final Text name, quantity;
    private final DualSprited slime;

    public PlayerInfo(BitmapFont font, Sprite leftSlime, Sprite rightSlime, String playerName, Color leftColor, Color rightColor,
                      int slimeQuantity) {
        name = new Text(font);
        slime = new DualSprited(leftSlime, rightSlime);
        quantity = new Text(font);
    }

    public void draw(SpriteBatch spriteBatch) {
        name.draw(spriteBatch);
        slime.draw(spriteBatch);
        quantity.draw(spriteBatch);
    }
}
package com.epicness.slimeland.game.stuff.slimes;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.epicness.fundamentals.stuff.Text;

public class ForeignSlime extends Slime {

    private final Text playerText;
    private boolean dead;

    public ForeignSlime(Sprite left, Sprite right, BitmapFont font, String playerName, Color leftColor, Color rightColor) {
        super(left, right);
        playerText = new Text(font);
        playerText.setText(playerName);
        setColors(leftColor, rightColor);
    }

    @Override
    public void draw(SpriteBatch spriteBatch) {
        super.draw(spriteBatch);
        playerText.draw(spriteBatch);
    }

    @Override
    public void setX(float x) {
        super.setX(x);
    }

    @Override
    public void setY(float y) {
        super.setY(y);
    }

    @Override
    public void translateY(float amount) {
        super.translateY(amount);
    }

    public boolean isDead() {
        return dead;
    }

    public void setDead(boolean dead) {
        this.dead = dead;
    }
}

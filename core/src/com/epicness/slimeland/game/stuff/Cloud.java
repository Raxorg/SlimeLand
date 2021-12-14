package com.epicness.slimeland.game.stuff;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.epicness.fundamentals.stuff.DualSprited;

public class Cloud extends DualSprited {

    private float speed;
    private final float offset;

    public Cloud(Sprite backgroundSprite, Sprite foregroundSprite, float offset) {
        super(backgroundSprite, foregroundSprite);
        this.offset = offset;
    }

    @Override
    public void setY(float y) {
        background.setY(y - offset);
        foreground.setY(y);
    }

    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }
}
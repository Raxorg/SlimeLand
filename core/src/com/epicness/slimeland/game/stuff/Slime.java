package com.epicness.slimeland.game.stuff;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.epicness.fundamentals.stuff.DualSprited;

public class Slime extends DualSprited {

    private float actionProgress;
    private final Vector2 speed;

    public Slime(Sprite left, Sprite right) {
        super(left, right);
        actionProgress = 1f;
        speed = new Vector2();
    }

    public void setLeftColor(Color color) {
        setBackgroundColor(color);
    }

    public void setRightColor(Color color) {
        setForegroundColor(color);
    }

    public float getActionProgress() {
        return actionProgress;
    }

    public void setActionProgress(float actionProgress) {
        this.actionProgress = actionProgress;
    }

    public Vector2 getSpeed() {
        return speed;
    }
}
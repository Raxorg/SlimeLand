package com.epicness.slimeland.game.stuff;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.epicness.fundamentals.stuff.DualSprited;

public class Slime extends DualSprited {

    private float actionTime;
    private final Vector2 origin, destination;

    public Slime(Sprite left, Sprite right) {
        super(left, right);
        origin = new Vector2();
        destination = new Vector2();
    }

    public void setLeftColor(Color color) {
        setBackgroundColor(color);
    }

    public void setRightColor(Color color) {
        setForegroundColor(color);
    }

    public float getActionTime() {
        return actionTime;
    }

    public void setActionTime(float actionTime) {
        this.actionTime = actionTime;
    }

    public Vector2 getOrigin() {
        return origin;
    }

    public Vector2 getDestination() {
        return destination;
    }
}
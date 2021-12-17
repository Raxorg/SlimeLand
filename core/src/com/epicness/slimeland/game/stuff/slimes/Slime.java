package com.epicness.slimeland.game.stuff.slimes;

import static com.epicness.slimeland.game.stuff.slimes.SlimeBehavior.ROAMING;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.epicness.fundamentals.stuff.DualSprited;

public class Slime extends DualSprited {

    private SlimeBehavior behavior;
    private float behaviorProgress;
    private final Vector2 speed;

    public Slime(Sprite left, Sprite right) {
        super(left, right);
        behavior = ROAMING;
        behaviorProgress = 1f;
        speed = new Vector2();
    }

    public void setColors(Color leftColor, Color rightColor) {
        setBackgroundColor(leftColor);
        setForegroundColor(rightColor);
    }

    public SlimeBehavior getBehavior() {
        return behavior;
    }

    public void setBehavior(SlimeBehavior behavior) {
        this.behavior = behavior;
    }

    public float getBehaviorProgress() {
        return behaviorProgress;
    }

    public void setBehaviorProgress(float behaviorProgress) {
        this.behaviorProgress = behaviorProgress;
    }

    public Vector2 getSpeed() {
        return speed;
    }
}
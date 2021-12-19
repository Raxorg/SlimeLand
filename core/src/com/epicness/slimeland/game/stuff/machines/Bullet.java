package com.epicness.slimeland.game.stuff.machines;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.epicness.fundamentals.stuff.Sprited;
import com.epicness.slimeland.game.stuff.slimes.ForeignSlime;

public class Bullet extends Sprited {

    private float size, progress;
    private final Vector2 origin;
    private ForeignSlime target;

    public Bullet(Sprite sprite, Vector2 origin) {
        super(sprite);
        this.origin = origin;
        setSize(0f);
    }

    public float getSize() {
        return size;
    }

    @Override
    public void setSize(float size) {
        super.setSize(size);
        setX(origin.x - size / 2f);
        setY(origin.y - size / 2f);
        this.size = size;
    }

    public float getProgress() {
        return progress;
    }

    public void setProgress(float progress) {
        this.progress = progress;
    }

    public Vector2 getOrigin() {
        return origin;
    }

    public ForeignSlime getTarget() {
        return target;
    }

    public void setTarget(ForeignSlime target) {
        this.target = target;
    }
}
package com.epicness.slimeland.game.stuff.machines;

import static com.epicness.slimeland.game.GameConstants.BULLET_MAX_SIZE;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.epicness.fundamentals.stuff.Sprited;
import com.epicness.slimeland.game.stuff.slimes.Slime;

public class Bullet extends Sprited {

    private final Tower tower;
    private float size, progress;
    private Vector2 origin;
    private Slime target;

    public Bullet(Sprite sprite, Tower tower) {
        super(sprite);
        this.tower = tower;
        setSize(0f);
    }

    public float getSize() {
        return size;
    }

    @Override
    public void setSize(float size) {
        super.setSize(size);
        setX(tower.getX() + tower.getWidth() / 2f - size / 2f);
        setY(tower.getY() + tower.getHeight() * 0.725f - size / 2f);
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

    public void updateOrigin() {
        float originX = tower.getX() + tower.getWidth() / 2f - BULLET_MAX_SIZE / 2f;
        float originY = tower.getY() + tower.getHeight() * 0.725f - BULLET_MAX_SIZE / 2f;
        origin = new Vector2(originX, originY);
    }

    public Slime getTarget() {
        return target;
    }

    public void setTarget(Slime target) {
        this.target = target;
    }
}
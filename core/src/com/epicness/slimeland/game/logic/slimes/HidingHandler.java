package com.epicness.slimeland.game.logic.slimes;

import static com.epicness.slimeland.game.GameConstants.GRID_SIZE;
import static com.epicness.slimeland.game.GameConstants.GRID_X;
import static com.epicness.slimeland.game.GameConstants.GRID_Y;
import static com.epicness.slimeland.game.GameConstants.SLIME_HIDING_SPEED;
import static com.epicness.slimeland.game.GameConstants.SLIME_MAX_SPEED;
import static com.epicness.slimeland.game.GameConstants.SLIME_MIN_SPEED;

import com.badlogic.gdx.math.Interpolation;
import com.badlogic.gdx.math.MathUtils;
import com.epicness.slimeland.game.stuff.slimes.Slime;

public class HidingHandler {

    public void handleSlimeHiding(Slime slime, float delta) {
        if (goingToHide(slime, delta)) {
            return;
        }
        float behaviorTime = slime.getBehaviorProgress();
        if (behaviorTime < 0f) {
            slime.setBehaviorProgress(behaviorTime + delta);
        } else if (behaviorTime < 1f) {
            float x = slime.getX() + slime.getSpeed().x * delta * Interpolation.sine.apply(slime.getBehaviorProgress() * 2f);
            float y = slime.getY() + slime.getSpeed().y * delta * Interpolation.sine.apply(slime.getBehaviorProgress() * 2f);
            slime.setPosition(x, y);
            slime.setBehaviorProgress(behaviorTime + delta / MathUtils.random(1f, 2f));
            adjustPosition(slime);
        } else {
            float randomXSpeed = MathUtils.random(SLIME_MIN_SPEED, SLIME_MAX_SPEED);
            float randomYSpeed = MathUtils.random(SLIME_MIN_SPEED, SLIME_MAX_SPEED);
            slime.getSpeed().set(randomXSpeed, randomYSpeed);
            slime.setBehaviorProgress(MathUtils.random(-7f, -0f));
        }
    }

    private boolean goingToHide(Slime slime, float delta) {
        boolean goingToHide = false;
        if (slime.getX() < GRID_X) {
            slime.translateX(SLIME_HIDING_SPEED * delta);
            goingToHide = true;
        } else if (slime.getX() + slime.getWidth() > GRID_X + GRID_SIZE) {
            slime.translateX(-SLIME_HIDING_SPEED * delta);
            goingToHide = true;
        }
        if (slime.getY() < GRID_Y) {
            slime.translateY(SLIME_HIDING_SPEED * delta);
            goingToHide = true;
        } else if (slime.getY() + slime.getHeight() > GRID_Y + GRID_SIZE) {
            slime.translateY(-SLIME_HIDING_SPEED * delta);
            goingToHide = true;
        }
        return goingToHide;
    }

    private void adjustPosition(Slime slime) {
        if (slime.getX() < GRID_X) {
            slime.setX(GRID_X);
            slime.getSpeed().x *= -1;
        }
        if (slime.getX() + slime.getWidth() > GRID_X + GRID_SIZE) {
            slime.setX(GRID_X + GRID_SIZE - slime.getWidth());
            slime.getSpeed().x *= -1;
        }
        if (slime.getY() < GRID_Y) {
            slime.setY(GRID_Y);
            slime.getSpeed().y *= -1;
        }
        if (slime.getY() + slime.getHeight() > GRID_Y + GRID_SIZE) {
            slime.setY(GRID_Y + GRID_SIZE - slime.getHeight());
            slime.getSpeed().y *= -1;
        }
    }
}
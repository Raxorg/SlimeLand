package com.epicness.slimeland.game.logic.slimes;

import static com.epicness.fundamentals.SharedConstants.CAMERA_HEIGHT;
import static com.epicness.fundamentals.SharedConstants.CAMERA_WIDTH;
import static com.epicness.slimeland.game.GameConstants.SLIME_MAX_SPEED;
import static com.epicness.slimeland.game.GameConstants.SLIME_MIN_SPEED;

import com.badlogic.gdx.math.Interpolation;
import com.badlogic.gdx.math.MathUtils;
import com.epicness.slimeland.game.stuff.slimes.Slime;

public class RoamingHandler {

    public void handleSlimeRoaming(Slime slime, float delta) {
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

    private void adjustPosition(Slime slime) {
        if (slime.getX() < 0f) {
            slime.setX(0f);
            slime.getSpeed().x *= -1;
        }
        if (slime.getX() + slime.getWidth() > CAMERA_WIDTH) {
            slime.setX(CAMERA_WIDTH - slime.getWidth());
            slime.getSpeed().x *= -1;
        }
        if (slime.getY() < 0f) {
            slime.setY(0f);
            slime.getSpeed().y *= -1;
        }
        if (slime.getY() + slime.getHeight() > CAMERA_HEIGHT) {
            slime.setY(CAMERA_HEIGHT - slime.getHeight());
            slime.getSpeed().y *= -1;
        }
    }
}
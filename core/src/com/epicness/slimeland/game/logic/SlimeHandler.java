package com.epicness.slimeland.game.logic;

import static com.epicness.fundamentals.SharedConstants.CAMERA_HEIGHT;
import static com.epicness.fundamentals.SharedConstants.CAMERA_WIDTH;
import static com.epicness.slimeland.game.GameConstants.SLIME_MAX_SPEED;
import static com.epicness.slimeland.game.GameConstants.SLIME_MIN_SPEED;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.DelayedRemovalArray;
import com.epicness.slimeland.game.stuff.GameStuff;
import com.epicness.slimeland.game.stuff.Slime;

public class SlimeHandler {

    // Structure
    private GameStuff stuff;

    public void update(float delta) {
        DelayedRemovalArray<Slime> slimes = stuff.getSlimes();
        for (int i = 0; i < slimes.size; i++) {
            Slime slime = slimes.get(i);
            handleMovement(slime, delta);
            adjustPosition(slime);
        }
    }

    private void handleMovement(Slime slime, float delta) {
        float actionTime = slime.getActionProgress();
        if (actionTime < 0f) {
            slime.setActionProgress(actionTime + delta);
        } else if (actionTime < 1f) {
            float x = slime.getX() + slime.getSpeed().x * delta;
            float y = slime.getY() + slime.getSpeed().y * delta;
            slime.setPosition(x, y);
            slime.setActionProgress(actionTime + delta);
        } else {
            float randomXSpeed = MathUtils.random(SLIME_MIN_SPEED, SLIME_MAX_SPEED);
            float randomYSpeed = MathUtils.random(SLIME_MIN_SPEED, SLIME_MAX_SPEED);
            slime.getSpeed().set(randomXSpeed, randomYSpeed);
            slime.setActionProgress(MathUtils.random(-7f, -0f));
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

    // Structure
    public void setStuff(GameStuff stuff) {
        this.stuff = stuff;
    }
}
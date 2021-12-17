package com.epicness.slimeland.game.logic.decorative;

import static com.epicness.fundamentals.SharedConstants.CAMERA_HEIGHT;
import static com.epicness.fundamentals.SharedConstants.CAMERA_WIDTH;

import com.badlogic.gdx.math.MathUtils;
import com.epicness.slimeland.game.stuff.Cloud;
import com.epicness.slimeland.game.stuff.GameStuff;

public class CloudHandler {

    private GameStuff stuff;
    // Logic
    private float time, spawnTime;

    public void update(float delta) {
        Cloud[] clouds = stuff.getClouds();
        for (int i = 0; i < clouds.length; i++) {
            clouds[i].translateX(clouds[i].getSpeed() * delta);
        }
        advanceSpawnTimer(delta);
    }

    private void advanceSpawnTimer(float delta) {
        time += delta;
        if (time >= spawnTime) {
            spawnCloud();
            time = 0f;
            spawnTime = MathUtils.random(10f, 15f);
        }
    }

    private void spawnCloud() {
        Cloud[] clouds = stuff.getClouds();
        for (int i = 0; i < clouds.length; i++) {
            Cloud cloud = clouds[i];
            if (cloud.getX() > CAMERA_WIDTH || cloud.getX() + cloud.getWidth() < 0f) {
                boolean left = MathUtils.randomBoolean();
                if (left) {
                    cloud.setX(-cloud.getWidth());
                } else {
                    cloud.setX(CAMERA_WIDTH);
                }
                cloud.setY(MathUtils.random(-cloud.getHeight() / 3f, CAMERA_HEIGHT - cloud.getHeight() / 3f));
                cloud.setSpeed(MathUtils.random(15f, 30f) * (left ? 1 : -1));
                cloud.setFlip(MathUtils.randomBoolean(), false);
                return;
            }
        }
    }

    public void setStuff(GameStuff stuff) {
        this.stuff = stuff;
    }
}
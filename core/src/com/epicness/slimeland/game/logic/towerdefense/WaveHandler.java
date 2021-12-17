package com.epicness.slimeland.game.logic.towerdefense;

import static com.epicness.fundamentals.SharedConstants.CAMERA_HEIGHT;
import static com.epicness.fundamentals.SharedConstants.CAMERA_WIDTH;
import static com.epicness.slimeland.game.GameConstants.FOREIGN_SLIME_SPEED;
import static com.epicness.slimeland.game.GameConstants.GRID_X;
import static com.epicness.slimeland.game.GameConstants.SLIME_HEIGHT;
import static com.epicness.slimeland.game.GameConstants.SLIME_WIDTH;

import com.badlogic.gdx.math.MathUtils;
import com.epicness.slimeland.game.GameAssets;
import com.epicness.slimeland.game.stuff.GameStuff;
import com.epicness.slimeland.game.stuff.slimes.Slime;
import com.epicness.slimeland.game.stuff.slimes.SlimeBehavior;

public class WaveHandler {

    // Structure
    private GameAssets assets;
    private GameStuff stuff;
    // Logic
    private float time, spawnInterval;
    private int waveSize, spawnedSlimes;

    public void startWave() {
        spawnInterval = 1f;
        waveSize = 20;
        spawnedSlimes = 0;
        for (int i = 0; i < stuff.getSlimes().size; i++) {
            stuff.getSlimes().get(i).setBehavior(SlimeBehavior.HIDING);
        }
    }

    public void update(float delta) {
        moveSlimes(delta);
        handleWave(delta);
    }

    private void moveSlimes(float delta) {
        for (int i = 0; i < stuff.getForeignSlimes().size; i++) {
            stuff.getForeignSlimes().get(i).translateY(-FOREIGN_SLIME_SPEED * delta);
        }
    }

    private void handleWave(float delta) {
        if (spawnedSlimes == waveSize) {
            return;
        }
        time += delta;
        if (time >= spawnInterval) {
            spawnSlime();
            time = 0f;
        }
    }

    private void spawnSlime() {
        Slime slime = new Slime(assets.getLeftSlime(), assets.getRightSlime());
        slime.setSize(SLIME_WIDTH, SLIME_HEIGHT);
        slime.setX(GRID_X / 2f - SLIME_WIDTH / 2f);
        if (MathUtils.randomBoolean()) {
            slime.setX(CAMERA_WIDTH - slime.getX() - SLIME_WIDTH);
        }
        slime.setY(CAMERA_HEIGHT);
        stuff.getForeignSlimes().add(slime);
        spawnedSlimes++;
    }

    // Structure
    public void setAssets(GameAssets assets) {
        this.assets = assets;
    }

    public void setStuff(GameStuff stuff) {
        this.stuff = stuff;
    }
}
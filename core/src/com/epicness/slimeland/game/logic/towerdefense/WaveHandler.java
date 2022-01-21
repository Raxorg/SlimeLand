package com.epicness.slimeland.game.logic.towerdefense;

import static com.epicness.fundamentals.SharedConstants.CAMERA_HEIGHT;
import static com.epicness.fundamentals.SharedConstants.CAMERA_WIDTH;
import static com.epicness.slimeland.game.GameConstants.CELL_SIZE;
import static com.epicness.slimeland.game.GameConstants.FOREIGN_SLIME_SPEED;
import static com.epicness.slimeland.game.GameConstants.GRID_X;
import static com.epicness.slimeland.game.GameConstants.INITIAL_SPAWN_INTERVAL;
import static com.epicness.slimeland.game.GameConstants.SLIME_HEIGHT;
import static com.epicness.slimeland.game.GameConstants.SLIME_WIDTH;
import static com.epicness.slimeland.game.GameConstants.TOWER_ID;
import static com.epicness.slimeland.game.GameConstants.WAVE_SIZE;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.DelayedRemovalArray;
import com.epicness.slimeland.game.GameAssets;
import com.epicness.slimeland.game.logic.GameLogic;
import com.epicness.slimeland.game.stuff.GameStuff;
import com.epicness.slimeland.game.stuff.playerlist.PlayerInfo;
import com.epicness.slimeland.game.stuff.slimes.ForeignSlime;
import com.epicness.slimeland.game.stuff.slimes.SlimeBehavior;

import java.util.Map;

public class WaveHandler {

    // Structure
    private GameAssets assets;
    private GameLogic logic;
    private GameStuff stuff;
    // Logic
    private float[] times;
    private float[] spawnIntervals;
    private int[] spawnedSlimes;
    private String thisPlayerName;
    private boolean ended;

    public void startWave() {
        int towers = countTowers();
        times = new float[towers];
        spawnIntervals = new float[towers];
        spawnedSlimes = new int[towers];
        for (int i = 0; i < spawnIntervals.length; i++) {
            spawnIntervals[i] = MathUtils.random(INITIAL_SPAWN_INTERVAL - 2f, INITIAL_SPAWN_INTERVAL + 2f);
        }
        for (int i = 0; i < stuff.getSlimes().size; i++) {
            stuff.getSlimes().get(i).setBehavior(SlimeBehavior.HIDING);
        }
        logic.getTowerHandler().setOnWave(true);
        ended = false;
    }

    private int countTowers() {
        int towers = 0;
        Map<String, ?> buildingData = logic.getStateHandler().getBuildingData();
        for (Map.Entry<String, ?> entry : buildingData.entrySet()) {
            int machineID = (int) entry.getValue();
            if (machineID == TOWER_ID) {
                towers++;
            }
        }
        return towers;
    }

    public void update(float delta) {
        if (times == null) {
            return;
        }
        handleWave(delta);
        moveSlimes(delta);
        checkWave();
    }

    private void handleWave(float delta) {
        for (int i = 0; i < times.length; i++) {
            times[i] += delta;
            if (times[i] < spawnIntervals[i]) {
                continue;
            }
            if (spawnedSlimes[i] == WAVE_SIZE) {
                continue;
            }
            spawnSlime();
            spawnedSlimes[i]++;
            times[i] = 0f;
            spawnIntervals[i] = MathUtils.random(INITIAL_SPAWN_INTERVAL - 2f, INITIAL_SPAWN_INTERVAL + 2f);
        }
    }

    private void spawnSlime() {
        ForeignSlime slime = randomizeSlime();
        slime.setX(GRID_X / 2f - SLIME_WIDTH / 2f + MathUtils.random(-CELL_SIZE, CELL_SIZE));
        if (MathUtils.randomBoolean()) {
            slime.setX(CAMERA_WIDTH - slime.getX() - SLIME_WIDTH);
        }
        slime.setY(CAMERA_HEIGHT);
        slime.setSize(SLIME_WIDTH, SLIME_HEIGHT);
        stuff.getForeignSlimes().add(slime);
    }

    private ForeignSlime randomizeSlime() {
        DelayedRemovalArray<PlayerInfo> playerInfos = stuff.getPlayerList().getPlayerInfos();
        if (playerInfos.isEmpty() || playerInfos.size == 1) {
            return new ForeignSlime(
                    assets.getLeftSlime(), assets.getRightSlime(),
                    assets.getMediumPixelFont(), "",
                    Color.WHITE, Color.WHITE
            );
        }
        PlayerInfo playerInfo;
        do {
            playerInfo = playerInfos.random();
        } while (playerInfo.getName().equals(thisPlayerName));
        String name = playerInfo.getName();
        Color color1 = playerInfo.getSlime().getBackgroundColor();
        Color color2 = playerInfo.getSlime().getForegroundColor();
        return new ForeignSlime(
                assets.getLeftSlime(), assets.getRightSlime(),
                assets.getMediumPixelFont(), name,
                color1, color2
        );
    }

    private void moveSlimes(float delta) {
        DelayedRemovalArray<ForeignSlime> foreignSlimes = stuff.getForeignSlimes();
        foreignSlimes.begin();
        for (int i = 0; i < foreignSlimes.size; i++) {
            ForeignSlime slime = stuff.getForeignSlimes().get(i);
            slime.translateY(-FOREIGN_SLIME_SPEED * delta);
            if (slime.getY() + slime.getHeight() < 0f) {
                foreignSlimes.removeValue(slime, true);
            }
        }
        foreignSlimes.end();
    }

    private void checkWave() {
        if (ended) {
            return;
        }
        for (int i = 0; i < spawnedSlimes.length; i++) {
            if (spawnedSlimes[i] != WAVE_SIZE) {
                return;
            }
        }
        for (int i = 0; i < stuff.getSlimes().size; i++) {
            stuff.getSlimes().get(i).setBehavior(SlimeBehavior.ROAMING);
        }
        logic.getTowerHandler().setOnWave(false);
        ended = true;
    }

    public void setThisPlayerName(String thisPlayerName) {
        this.thisPlayerName = thisPlayerName;
    }

    // Structure
    public void setAssets(GameAssets assets) {
        this.assets = assets;
    }

    public void setLogic(GameLogic logic) {
        this.logic = logic;
    }

    public void setStuff(GameStuff stuff) {
        this.stuff = stuff;
    }
}
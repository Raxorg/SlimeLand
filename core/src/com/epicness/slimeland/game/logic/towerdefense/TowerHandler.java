package com.epicness.slimeland.game.logic.towerdefense;

import static com.epicness.slimeland.game.GameConstants.MACHINE_PROPERTY;
import static com.epicness.slimeland.game.GameConstants.TOWER_ID;

import com.epicness.fundamentals.stuff.grid.Cell;
import com.epicness.slimeland.game.logic.GameLogic;
import com.epicness.slimeland.game.stuff.GameStuff;
import com.epicness.slimeland.game.stuff.machines.Machine;
import com.epicness.slimeland.game.stuff.machines.Tower;

import java.util.Map;

public class TowerHandler {

    // Structure
    private GameLogic logic;
    private GameStuff stuff;
    // Logic
    private float timer;
    private boolean onWave;

    public void loadTowerCooldown() {
        timer = logic.getStateHandler().getTowerCooldown();
        Cell[][] cells = stuff.getGrid().getCells();
        Map<String, ?> buildingData = logic.getStateHandler().getBuildingData();
        for (Map.Entry<String, ?> entry : buildingData.entrySet()) {
            int machineID = (int) entry.getValue();
            if (machineID == TOWER_ID) {
                String[] coordinates = entry.getKey().split("-");
                int column = Integer.parseInt(coordinates[0]);
                int row = Integer.parseInt(coordinates[1]);
                Machine machine = (Machine) cells[column][row].getProperties().get(MACHINE_PROPERTY);
                if (machine instanceof Tower) {
                    ((Tower) machine).setTimer(timer);
                }
            }
        }
    }

    public void update(float delta) {
        if (onWave) {
            return;
        }
        timer -= delta;
        updateTimers();
    }

    private void updateTimers() {
        Cell[][] cells = stuff.getGrid().getCells();
        Map<String, ?> buildingData = logic.getStateHandler().getBuildingData();
        for (Map.Entry<String, ?> entry : buildingData.entrySet()) {
            int machineID = (int) entry.getValue();
            if (machineID == TOWER_ID) {
                String[] coordinates = entry.getKey().split("-");
                int column = Integer.parseInt(coordinates[0]);
                int row = Integer.parseInt(coordinates[1]);
                Tower tower = (Tower) cells[column][row].getProperties().get(MACHINE_PROPERTY);
                tower.setTimer(timer);
            }
        }
    }

    public void towerTouched() {
        if (timer <= 0f) {
            logic.getWaveHandler().startWave();
            timer = 90f;
            updateTimers();
        }
    }

    public void setOnWave(boolean onWave) {
        this.onWave = onWave;
    }

    // Structure
    public void setLogic(GameLogic logic) {
        this.logic = logic;
    }

    public void setStuff(GameStuff stuff) {
        this.stuff = stuff;
    }
}
package com.epicness.slimeland.game.logic.machines;

import static com.epicness.slimeland.SlimeConstants.HIDDEN_X;
import static com.epicness.slimeland.SlimeConstants.HIDDEN_Y;
import static com.epicness.slimeland.game.GameConstants.FACTORY_ID;
import static com.epicness.slimeland.game.GameConstants.MACHINE_PROPERTY;

import com.badlogic.gdx.math.MathUtils;
import com.epicness.fundamentals.input.SharedInput;
import com.epicness.fundamentals.stuff.grid.Cell;
import com.epicness.slimeland.SlimeGame;
import com.epicness.slimeland.game.logic.GameLogic;
import com.epicness.slimeland.game.stuff.GameStuff;
import com.epicness.slimeland.game.stuff.machines.Factory;

import java.util.Map;

public class FactoryHandler {

    // Structure
    private SlimeGame game;
    private SharedInput input;
    private GameLogic logic;
    private GameStuff stuff;
    // Logic
    private float timer;
    private String thisPlayerName;

    public void loadFactoryCooldown() {
        timer = logic.getStateHandler().getFactoryCooldown();
        Cell[][] cells = stuff.getGrid().getCells();
        Map<String, ?> buildingData = logic.getStateHandler().getBuildingData();
        for (Map.Entry<String, ?> entry : buildingData.entrySet()) {
            int machineID = (int) entry.getValue();
            if (machineID == FACTORY_ID) {
                String[] coordinates = entry.getKey().split("-");
                int column = Integer.parseInt(coordinates[0]);
                int row = Integer.parseInt(coordinates[1]);
                Factory factory = (Factory) cells[column][row].getProperties().get(MACHINE_PROPERTY);
                factory.setTimer(timer);
            }
        }
    }

    public void update(float delta) {
        timer -= delta;
        updateTimers();
    }

    private void updateTimers() {
        Cell[][] cells = stuff.getGrid().getCells();
        Map<String, ?> buildingData = logic.getStateHandler().getBuildingData();
        for (Map.Entry<String, ?> entry : buildingData.entrySet()) {
            int machineID = (int) entry.getValue();
            if (machineID == FACTORY_ID) {
                String[] coordinates = entry.getKey().split("-");
                int column = Integer.parseInt(coordinates[0]);
                int row = Integer.parseInt(coordinates[1]);
                Factory factory = (Factory) cells[column][row].getProperties().get(MACHINE_PROPERTY);
                factory.setTimer(timer);
            }
        }
    }

    public void factoryTouched() {
        if (timer <= 0f) {
            spawnSlime();
        }
    }

    private void spawnSlime() {
        input.setEnabled(false);
        game.getFirestore().incrementArmy(
                thisPlayerName,
                success -> {
                    if (success) {
                        logic.getSlimeHandler().spawnSlimes(1);
                        timer = 60f;
                        updateTimers();
                        logic.getSlimeHandler().saveSlimeQuantity();
                    } else {
                        stuff.getOverlay().setPosition(0f, 0f);
                        stuff.getOverlay().setText("SOMETHING WENT WRONG");
                    }
                    input.setEnabled(true);
                });
    }

    public void saveFactoryCooldown() {
        logic.getStateHandler().setFactoryCooldown(MathUtils.ceil(timer));
    }

    public void setThisPlayerName(String thisPlayerName) {
        this.thisPlayerName = thisPlayerName;
    }

    public boolean touchUp() {
        if (stuff.getOverlay().getY() == HIDDEN_Y) {
            return false;
        }
        if (!stuff.getOverlay().getText().equals("SOMETHING WENT WRONG")) {
            return false;
        }
        stuff.getOverlay().setPosition(HIDDEN_X, HIDDEN_Y);
        return true;
    }

    // Structure
    public void setGame(SlimeGame game) {
        this.game = game;
    }

    public void setInput(SharedInput input) {
        this.input = input;
    }

    public void setLogic(GameLogic logic) {
        this.logic = logic;
    }

    public void setStuff(GameStuff stuff) {
        this.stuff = stuff;
    }
}
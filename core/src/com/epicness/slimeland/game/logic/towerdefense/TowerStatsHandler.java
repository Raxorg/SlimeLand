package com.epicness.slimeland.game.logic.towerdefense;

import static com.epicness.slimeland.SlimeConstants.HIDDEN_X;
import static com.epicness.slimeland.SlimeConstants.HIDDEN_Y;

import com.epicness.slimeland.game.logic.GameLogic;
import com.epicness.slimeland.game.stuff.GameStuff;

public class TowerStatsHandler {

    // Structure
    private GameLogic logic;
    private GameStuff stuff;
    // Logic
    private int level, kills;

    public void loadTowerStats() {
        level = logic.getStateHandler().getTDLevel();
        kills = logic.getStateHandler().getKills();
        updateTowerStats();
    }

    private void updateTowerStats() {
        int goal = level * 10 + (level - 1) * 5;
        stuff.getTowerStats().setText("Wave " + level + "     " + kills + " of " + goal);
    }

    public void show() {
        stuff.getTowerStats().setPosition(0f, 0f);
    }

    public void hide() {
        stuff.getTowerStats().setPosition(HIDDEN_X, HIDDEN_Y);
    }

    public void saveTowerStats() {
        logic.getStateHandler().setTDLevel(level);
        logic.getStateHandler().setKills(kills);
    }

    public void increaseKills() {
        kills++;
        if (kills >= level * 10 + (level - 1) * 5) {
            level++;
            logic.getBuildingHandler().addBuildCharge();
        }
        updateTowerStats();
    }

    public void touchUp() {
        hide();
    }

    // Structure
    public void setLogic(GameLogic logic) {
        this.logic = logic;
    }

    public void setStuff(GameStuff stuff) {
        this.stuff = stuff;
    }
}

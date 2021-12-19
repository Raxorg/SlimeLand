package com.epicness.slimeland.game.logic.machines;

import static com.epicness.slimeland.game.GameConstants.MACHINE_PROPERTY;

import com.badlogic.gdx.math.MathUtils;
import com.epicness.slimeland.game.logic.GameLogic;
import com.epicness.slimeland.game.stuff.GameStuff;
import com.epicness.slimeland.game.stuff.machines.Antenna;

public class AntennaHandler {

    // Structure
    private GameLogic logic;
    private GameStuff stuff;

    public void loadAntennaCooldown() {
        Antenna antenna = (Antenna) stuff.getGrid().getCells()[3][3].getProperties().get(MACHINE_PROPERTY);
        int cooldown = logic.getStateHandler().getAntennaCooldown();
        antenna.setTimer(cooldown);
    }

    public void update(float delta) {
        Antenna antenna = (Antenna) stuff.getGrid().getCells()[3][3].getProperties().get(MACHINE_PROPERTY);
        antenna.setTimer(antenna.getTimer() - delta);
    }

    public void antennaTouched() {
        Antenna antenna = (Antenna) stuff.getGrid().getCells()[3][3].getProperties().get(MACHINE_PROPERTY);
        if (antenna.getTimer() <= 0f) {
            antenna.setTimer(90f);
            logic.getMultiplayerHandler().fetchPlayerInfo();
            return;
        }
        logic.getPlayerListHandler().show();
    }

    public void saveAntennaCooldown() {
        Antenna antenna = (Antenna) stuff.getGrid().getCells()[3][3].getProperties().get(MACHINE_PROPERTY);
        int antennaCooldown = MathUtils.ceil(antenna.getTimer());
        logic.getStateHandler().setAntennaCooldown(antennaCooldown);
    }

    // Structure
    public void setLogic(GameLogic logic) {
        this.logic = logic;
    }

    public void setStuff(GameStuff stuff) {
        this.stuff = stuff;
    }
}
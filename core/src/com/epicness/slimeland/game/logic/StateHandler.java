package com.epicness.slimeland.game.logic;

import static com.epicness.fundamentals.utils.ColorUtils.colorFromString;
import static com.epicness.slimeland.SlimeConstants.ANTENNA_COOLDOWN_PREF_KEY;
import static com.epicness.slimeland.SlimeConstants.BUILDING_PREFS_PATH;
import static com.epicness.slimeland.SlimeConstants.BUILD_CHARGES_PREF_KEY;
import static com.epicness.slimeland.SlimeConstants.PREFS_PATH;
import static com.epicness.slimeland.game.GameConstants.MACHINE_PROPERTY;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.MathUtils;
import com.epicness.fundamentals.logic.SharedLogic;
import com.epicness.fundamentals.stuff.grid.Cell;
import com.epicness.slimeland.game.stuff.GameStuff;
import com.epicness.slimeland.game.stuff.machines.Machine;
import com.epicness.slimeland.menu.stuff.Player;

import java.util.Map;

public class StateHandler {

    // Structure
    private SharedLogic sharedLogic;
    private GameLogic logic;
    private GameStuff stuff;

    // Player state
    public void loadPlayerState(Player player) {
        String[] colorArray = player.getColors().split("-");
        Color color1 = colorFromString(colorArray[0]);
        Color color2 = colorFromString(colorArray[1]);

        logic.getPlayerListHandler().setThisPlayerName(player.getName());
        applyColors(color1, color2);
        logic.getSlimeHandler().spawnSlimes(player.getSlimeQuantity());
    }

    private void applyColors(Color color1, Color color2) {
        logic.getCloudHandler().setColors(color1, color2);
        logic.getBuildingHandler().setColors(color1, color2);
        logic.getSlimeHandler().setColors(color1, color2);
        logic.getBulletHandler().setColors(color1, color2);

        stuff.getBuildMenu().setColors(color1, color2);
        Cell[][] cells = stuff.getGrid().getCells();
        for (int column = 0; column < cells.length; column++) {
            for (int row = 0; row < cells[column].length; row++) {
                Machine machine = (Machine) cells[column][row].getProperties().get(MACHINE_PROPERTY);
                if (machine == null) {
                    continue;
                }
                machine.setColors(color1, color2);
            }
        }
        for (int i = 0; i < stuff.getBullets().size; i++) {
            stuff.getBullets().get(i).setColor(MathUtils.randomBoolean() ? color1 : color2);
        }
    }

    // Build charges
    public int getBuildCharges() {
        return sharedLogic.getPreferencesHandler().loadInteger(PREFS_PATH, BUILD_CHARGES_PREF_KEY);
    }

    public void setBuildCharges(int buildCharges) {
        sharedLogic.getPreferencesHandler().saveInteger(PREFS_PATH, BUILD_CHARGES_PREF_KEY, buildCharges);
        applyBuildCharges(buildCharges);
    }

    private void applyBuildCharges(int buildCharges) {
        stuff.getBuildMenu().setBuildCharges(buildCharges);
    }

    // Buildings
    public Map<String, ?> getBuildingData() {
        return sharedLogic.getPreferencesHandler().loadData(BUILDING_PREFS_PATH);
    }

    public void storeBuilding(String coordinates, int machineID) {
        sharedLogic.getPreferencesHandler().saveInteger(BUILDING_PREFS_PATH, coordinates, machineID);
    }

    // Antenna cooldown
    public int getAntennaCooldown() {
        return sharedLogic.getPreferencesHandler().loadInteger(PREFS_PATH, ANTENNA_COOLDOWN_PREF_KEY);
    }

    public void setAntennaCooldown(int antennaCooldown) {
        sharedLogic.getPreferencesHandler().saveInteger(PREFS_PATH, ANTENNA_COOLDOWN_PREF_KEY, antennaCooldown);
    }

    // Structure
    public void setSharedLogic(SharedLogic sharedLogic) {
        this.sharedLogic = sharedLogic;
    }

    public void setLogic(GameLogic logic) {
        this.logic = logic;
    }

    public void setStuff(GameStuff stuff) {
        this.stuff = stuff;
    }
}
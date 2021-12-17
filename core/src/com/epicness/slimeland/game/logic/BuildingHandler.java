package com.epicness.slimeland.game.logic;

import static com.epicness.slimeland.SlimeConstants.BUILD_CHARGES_PREF_KEY;
import static com.epicness.slimeland.SlimeConstants.PREFS_PATH;
import static com.epicness.slimeland.game.GameConstants.BUILDING_PREFS_PATH;
import static com.epicness.slimeland.game.GameConstants.CELL_SIZE;
import static com.epicness.slimeland.game.GameConstants.FACTORY_ID;
import static com.epicness.slimeland.game.GameConstants.MACHINE_PROPERTY;
import static com.epicness.slimeland.game.GameConstants.WORKSHOP_ID;

import com.epicness.fundamentals.assets.SharedAssets;
import com.epicness.fundamentals.logic.SharedLogic;
import com.epicness.fundamentals.stuff.grid.Cell;
import com.epicness.slimeland.game.GameAssets;
import com.epicness.slimeland.game.stuff.GameStuff;
import com.epicness.slimeland.game.stuff.machines.Factory;
import com.epicness.slimeland.game.stuff.machines.Machine;
import com.epicness.slimeland.game.stuff.machines.Tower;
import com.epicness.slimeland.game.stuff.machines.Workshop;

import java.util.Map;

public class BuildingHandler {

    // Structure
    private SharedAssets sharedAssets;
    private GameAssets assets;
    private SharedLogic sharedLogic;
    private GameLogic logic;
    private GameStuff stuff;

    public void loadState() {
        loadBuildCharges();

        Map<String, ?> buildingData = sharedLogic.getPreferencesHandler().loadData(BUILDING_PREFS_PATH);
        for (Map.Entry<String, ?> entry : buildingData.entrySet()) {
            String[] positionInfo = entry.getKey().split("-");
            int column = Integer.parseInt(positionInfo[0]);
            int row = Integer.parseInt(positionInfo[1]);
            Cell cell = stuff.getGrid().getCells()[column][row];
            int machineID = Integer.parseInt((String) entry.getValue());
            buildFromPreferences(machineID, cell);
        }
    }

    private void loadBuildCharges() {
        int buildCharges = sharedLogic.getPreferencesHandler().loadInteger(PREFS_PATH, BUILD_CHARGES_PREF_KEY);
        stuff.getBuildMenu().setBuildCharges(buildCharges);
    }

    private void buildFromPreferences(int machineID, Cell cell) {
        Machine machine = buildMachine(machineID, cell);
        cell.getProperties().put(MACHINE_PROPERTY, machine);
    }

    public void buildWithCharge(int machineID, Cell cell) {
        if (stuff.getBuildMenu().getBuildCharges() == 0) {
            return;
        }
        Machine machine = buildMachine(machineID, cell);
        machine.setColors(logic.getStateHandler().getColor1(), logic.getStateHandler().getColor2());
        cell.getProperties().put(MACHINE_PROPERTY, machine);
        saveToPreferences(cell, machineID);
        removeBuildCharge();
    }

    private Machine buildMachine(int machineID, Cell cell) {
        Machine machine;
        switch (machineID) {
            case FACTORY_ID:
                machine = new Tower(assets.getFactoryLeft(), assets.getFactoryRight());
                break;
            case WORKSHOP_ID:
                machine = new Workshop(assets.getWorkshopExterior(), assets.getWorkshopInterior());
                break;
            default:
                machine = new Factory(assets.getTowerLeft(), assets.getTowerRight(), sharedAssets.getPixelFont());
                break;
        }
        machine.setPosition(cell.getX(), cell.getY());
        machine.setSize(CELL_SIZE);
        return machine;
    }

    private void saveToPreferences(Cell cell, int machineID) {
        String key = cell.getColumn() + "-" + cell.getRow();
        sharedLogic.getPreferencesHandler().saveString(BUILDING_PREFS_PATH, key, machineID + "");
    }

    private void removeBuildCharge() {
        int newBuildCharges = stuff.getBuildMenu().getBuildCharges() - 1;
        stuff.getBuildMenu().setBuildCharges(newBuildCharges);
        sharedLogic.getPreferencesHandler().saveInteger(PREFS_PATH, BUILD_CHARGES_PREF_KEY, newBuildCharges);
    }

    // Structure
    public void setSharedAssets(SharedAssets sharedAssets) {
        this.sharedAssets = sharedAssets;
    }

    public void setAssets(GameAssets assets) {
        this.assets = assets;
    }

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
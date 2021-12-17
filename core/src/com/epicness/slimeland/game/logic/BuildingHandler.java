package com.epicness.slimeland.game.logic;

import static com.epicness.slimeland.SlimeConstants.BUILD_CHARGES_PREF_KEY;
import static com.epicness.slimeland.SlimeConstants.PREFS_PATH;
import static com.epicness.slimeland.game.GameConstants.BUILDING_PREFS_PATH;
import static com.epicness.slimeland.game.GameConstants.CELL_SIZE;
import static com.epicness.slimeland.game.GameConstants.MACHINE_PROPERTY;
import static com.epicness.slimeland.game.GameConstants.MACHINE_SIZE;

import com.epicness.fundamentals.logic.SharedLogic;
import com.epicness.fundamentals.stuff.grid.Cell;
import com.epicness.slimeland.game.GameAssets;
import com.epicness.slimeland.game.stuff.GameStuff;
import com.epicness.slimeland.game.stuff.machines.Factory;
import com.epicness.slimeland.game.stuff.machines.Machine;
import com.epicness.slimeland.game.stuff.machines.MachineType;
import com.epicness.slimeland.game.stuff.machines.Tower;
import com.epicness.slimeland.game.stuff.machines.Workshop;

import java.util.Map;

public class BuildingHandler {

    // Structure
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
        Machine machine = buildMachine(MachineType.findWithID(machineID), cell);
        cell.getProperties().put(MACHINE_PROPERTY, machine);
    }

    public void buildWithCharge(MachineType machineType, Cell cell) {
        if (stuff.getBuildMenu().getBuildCharges() == 0) {
            return;
        }
        Machine machine = buildMachine(machineType, cell);
        machine.setColors(logic.getStateHandler().getColor1(), logic.getStateHandler().getColor2());
        cell.getProperties().put(MACHINE_PROPERTY, machine);
        saveToPreferences(cell, machineType);
        removeBuildCharge();
    }

    private Machine buildMachine(MachineType machineType, Cell cell) {
        Machine machine;
        switch (machineType) {
            case FACTORY:
                machine = new Factory(assets.getFactoryLeft(), assets.getFactoryRight(), assets.getMediumPixelFont());
                break;
            case WORKSHOP:
                machine = new Workshop(assets.getWorkshopExterior(), assets.getWorkshopInterior());
                break;
            case TOWER:
            default:
                machine = new Tower(assets.getTowerLeft(), assets.getTowerRight());
                break;
        }
        machine.setPosition(cell.getX(), cell.getY());
        machine.setSize(MACHINE_SIZE);
        return machine;
    }

    private void saveToPreferences(Cell cell, MachineType machineType) {
        String key = cell.getColumn() + "-" + cell.getRow();
        sharedLogic.getPreferencesHandler().saveString(BUILDING_PREFS_PATH, key, machineType.getMachineID() + "");
    }

    private void removeBuildCharge() {
        int newBuildCharges = stuff.getBuildMenu().getBuildCharges() - 1;
        stuff.getBuildMenu().setBuildCharges(newBuildCharges);
        sharedLogic.getPreferencesHandler().saveInteger(PREFS_PATH, BUILD_CHARGES_PREF_KEY, newBuildCharges);
    }

    // Structure
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
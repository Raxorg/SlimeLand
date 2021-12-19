package com.epicness.slimeland.game.logic.machines;

import static com.epicness.slimeland.game.GameConstants.MACHINE_PROPERTY;
import static com.epicness.slimeland.game.GameConstants.MACHINE_SIZE;

import com.badlogic.gdx.graphics.Color;
import com.epicness.fundamentals.stuff.grid.Cell;
import com.epicness.slimeland.game.GameAssets;
import com.epicness.slimeland.game.logic.GameLogic;
import com.epicness.slimeland.game.stuff.GameStuff;
import com.epicness.slimeland.game.stuff.machines.Antenna;
import com.epicness.slimeland.game.stuff.machines.Factory;
import com.epicness.slimeland.game.stuff.machines.Machine;
import com.epicness.slimeland.game.stuff.machines.MachineType;
import com.epicness.slimeland.game.stuff.machines.Tower;
import com.epicness.slimeland.game.stuff.machines.Workshop;

import java.util.Map;

public class BuildingHandler {

    // Structure
    private GameAssets assets;
    private GameLogic logic;
    private GameStuff stuff;
    // Logic
    private Color color1, color2;

    public void loadState() {
        loadBuildCharges();

        Map<String, ?> buildingData = logic.getStateHandler().getBuildingData();
        for (Map.Entry<String, ?> entry : buildingData.entrySet()) {
            String[] positionInfo = entry.getKey().split("-");
            int column = Integer.parseInt(positionInfo[0]);
            int row = Integer.parseInt(positionInfo[1]);
            Cell cell = stuff.getGrid().getCells()[column][row];
            int machineID = (int) entry.getValue();
            buildFromPreferences(machineID, cell);
        }
    }

    private void loadBuildCharges() {
        int buildCharges = logic.getStateHandler().getBuildCharges();
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
        machine.setColors(color1, color2);
        cell.getProperties().put(MACHINE_PROPERTY, machine);
        int newBuildCharges = stuff.getBuildMenu().getBuildCharges() - 1;
        saveState(cell, machineType, newBuildCharges);
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
                machine = new Tower(assets.getTowerLeft(), assets.getTowerRight());
                break;
            case ANTENNA:
            default:
                machine = new Antenna(assets.getAntenna1(), assets.getAntenna2());
                break;
        }
        machine.setPosition(cell.getX(), cell.getY());
        machine.setSize(MACHINE_SIZE);
        return machine;
    }

    private void saveState(Cell cell, MachineType machineType, int buildCharges) {
        String coordinates = cell.getColumn() + "-" + cell.getRow();
        logic.getStateHandler().storeBuilding(coordinates, machineType.getMachineID());
        logic.getStateHandler().setBuildCharges(buildCharges);
    }

    public void setColors(Color color1, Color color2) {
        this.color1 = color1;
        this.color2 = color2;
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
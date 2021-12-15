package com.epicness.slimeland.game.logic;

import static com.epicness.slimeland.game.GameConstants.CELL_SIZE;
import static com.epicness.slimeland.game.GameConstants.FACTORY_ID;
import static com.epicness.slimeland.game.GameConstants.MACHINE_PROPERTY;
import static com.epicness.slimeland.game.GameConstants.WORKSHOP_ID;

import com.epicness.fundamentals.assets.SharedAssets;
import com.epicness.fundamentals.stuff.grid.Cell;
import com.epicness.slimeland.game.GameAssets;
import com.epicness.slimeland.game.stuff.machines.Factory;
import com.epicness.slimeland.game.stuff.machines.Machine;
import com.epicness.slimeland.game.stuff.machines.Tower;
import com.epicness.slimeland.game.stuff.machines.Workshop;

public class BuildingHandler {

    // Structure
    private SharedAssets sharedAssets;
    private GameAssets assets;
    private GameLogic logic;

    public void build(int machineID, Cell cell) {
        Machine machine;
        switch (machineID) {
            case FACTORY_ID:
                machine = new Tower(assets.getFactoryLeft(), assets.getFactoryRight());
                break;
            case WORKSHOP_ID:
                machine = new Workshop(assets.getFactoryLeft(), assets.getTowerRight());
                break;
            default:
                machine = new Factory(assets.getTowerLeft(), assets.getTowerRight(), sharedAssets.getPixelFont());
                break;
        }
        machine.setPosition(cell.getX(), cell.getY());
        machine.setSize(CELL_SIZE);
        machine.setColors(logic.getStateHandler().getColor1(), logic.getStateHandler().getColor2());
        cell.getProperties().put(MACHINE_PROPERTY, machine);
    }

    // Structure
    public void setSharedAssets(SharedAssets sharedAssets) {
        this.sharedAssets = sharedAssets;
    }

    public void setAssets(GameAssets assets) {
        this.assets = assets;
    }

    public void setLogic(GameLogic logic) {
        this.logic = logic;
    }
}
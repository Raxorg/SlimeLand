package com.epicness.slimeland.game.stuff.machines;

import static com.epicness.slimeland.game.GameConstants.ANTENNA_ID;
import static com.epicness.slimeland.game.GameConstants.FACTORY_ID;
import static com.epicness.slimeland.game.GameConstants.TOWER_ID;
import static com.epicness.slimeland.game.GameConstants.WORKSHOP_ID;

public enum MachineType {

    FACTORY(FACTORY_ID),
    WORKSHOP(WORKSHOP_ID),
    TOWER(TOWER_ID),
    ANTENNA(ANTENNA_ID);

    private final int machineID;

    MachineType(int machineID) {
        this.machineID = machineID;
    }

    public static MachineType findWithID(int machineID) {
        switch (machineID) {
            case FACTORY_ID:
                return FACTORY;
            case WORKSHOP_ID:
                return WORKSHOP;
            case TOWER_ID:
                return TOWER;
            case ANTENNA_ID:
            default:
                return ANTENNA;
        }
    }

    public int getMachineID() {
        return machineID;
    }
}
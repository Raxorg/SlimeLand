package com.epicness.slimeland.game.stuff.buildmenu;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.epicness.fundamentals.stuff.DualSprited;
import com.epicness.slimeland.game.stuff.machines.MachineType;

public class BuildOption extends DualSprited {

    private final MachineType machineType;

    public BuildOption(MachineType machineType, Sprite backgroundSprite, Sprite foregroundSprite) {
        super(backgroundSprite, foregroundSprite);
        this.machineType = machineType;
    }

    public MachineType getMachineType() {
        return machineType;
    }
}
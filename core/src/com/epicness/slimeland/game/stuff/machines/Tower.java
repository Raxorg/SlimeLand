package com.epicness.slimeland.game.stuff.machines;

import static com.epicness.slimeland.game.stuff.machines.MachineType.TOWER;

import com.badlogic.gdx.graphics.g2d.Sprite;

public class Tower extends Machine {

    public Tower(Sprite bottomSprite, Sprite topSprite) {
        super(TOWER, bottomSprite, topSprite);
    }
}
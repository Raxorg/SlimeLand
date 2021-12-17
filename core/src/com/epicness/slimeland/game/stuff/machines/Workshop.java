package com.epicness.slimeland.game.stuff.machines;

import static com.epicness.slimeland.game.stuff.machines.MachineType.WORKSHOP;

import com.badlogic.gdx.graphics.g2d.Sprite;

public class Workshop extends Machine {

    public Workshop(Sprite leftSprite, Sprite rightSprite) {
        super(WORKSHOP, leftSprite, rightSprite);
    }
}
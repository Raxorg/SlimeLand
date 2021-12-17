package com.epicness.slimeland.game.stuff.machines;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.epicness.fundamentals.stuff.DualSprited;

public abstract class Machine extends DualSprited {

    private final MachineType type;

    public Machine(MachineType type, Sprite leftSprite, Sprite rightSprite) {
        super(leftSprite, rightSprite);
        this.type = type;
    }

    public void setColors(Color leftColor, Color rightColor) {
        setBackgroundColor(leftColor);
        setForegroundColor(rightColor);
    }

    public MachineType getType() {
        return type;
    }
}
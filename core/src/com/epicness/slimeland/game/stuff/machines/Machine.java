package com.epicness.slimeland.game.stuff.machines;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.epicness.fundamentals.stuff.DualSprited;

public abstract class Machine extends DualSprited {

    public Machine(Sprite leftSprite, Sprite rightSprite) {
        super(leftSprite, rightSprite);
    }

    public void setColors(Color leftColor, Color rightColor) {
        setBackgroundColor(leftColor);
        setForegroundColor(rightColor);
    }
}
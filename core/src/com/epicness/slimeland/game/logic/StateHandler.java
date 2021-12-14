package com.epicness.slimeland.game.logic;

import com.badlogic.gdx.graphics.Color;
import com.epicness.slimeland.game.stuff.GameStuff;

public class StateHandler {

    // Structure
    private GameStuff stuff;
    // Logic
    private String name;
    private Color color1, color2;

    public void setup(String name, Color color1, Color color2) {
        this.name = name;
        this.color1 = color1;
        this.color2 = color2;

        stuff.getSlimes().get(0).setBackgroundColor(color1);
        stuff.getSlimes().get(0).setForegroundColor(color2);
    }

    public String getName() {
        return name;
    }

    public Color getColor1() {
        return color1;
    }

    public Color getColor2() {
        return color2;
    }

    // Structure
    public void setStuff(GameStuff stuff) {
        this.stuff = stuff;
    }
}
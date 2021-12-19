package com.epicness.slimeland.game.stuff.slimes;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class ForeignSlime extends Slime {

    private final String playerName;
    private boolean dead;

    public ForeignSlime(Sprite left, Sprite right, String playerName, Color leftColor, Color rightColor) {
        super(left, right);
        this.playerName = playerName;
        setColors(leftColor, rightColor);
    }

    public String getPlayerName() {
        return playerName;
    }

    public boolean isDead() {
        return dead;
    }

    public void setDead(boolean dead) {
        this.dead = dead;
    }
}

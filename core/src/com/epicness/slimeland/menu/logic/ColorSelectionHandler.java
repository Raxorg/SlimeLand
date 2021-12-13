package com.epicness.slimeland.menu.logic;

import com.badlogic.gdx.graphics.Color;
import com.epicness.fundamentals.input.SharedInput;
import com.epicness.slimeland.SlimeGame;
import com.epicness.slimeland.menu.stuff.MenuStuff;

public class ColorSelectionHandler {

    // Structure
    private SlimeGame game;
    private SharedInput input;
    private MenuStuff stuff;

    public void claimColor(Color color1, Color color2) {
        input.setEnabled(false);
        stuff.getLoadingOverlay().setPosition(0f, 0f);

        String colors = stringFromColor(color1) + "-" + stringFromColor(color2);
        game.getFirestore().claimColor(colors, aBoolean -> {

        });
    }

    private String stringFromColor(Color color) {
        if (color.equals(Color.WHITE)) {
            return "white";
        }
        if (color.equals(Color.RED)) {
            return "red";
        }
        if (color.equals(Color.PURPLE)) {
            return "purple";
        }
        if (color.equals(Color.SALMON)) {
            return "salmon";
        }
        if (color.equals(Color.ORANGE)) {
            return "orange";
        }
        if (color.equals(Color.YELLOW)) {
            return "yellow";
        }
        if (color.equals(Color.OLIVE)) {
            return "olive";
        }
        if (color.equals(Color.CHARTREUSE)) {
            return "chartreuse";
        }
        if (color.equals(Color.FOREST)) {
            return "forest";
        }
        if (color.equals(Color.TEAL)) {
            return "teal";
        }
        if (color.equals(Color.CYAN)) {
            return "cyan";
        }
        if (color.equals(Color.BLUE)) {
            return "blue";
        }
        if (color.equals(Color.BROWN)) {
            return "brown";
        }
        if (color.equals(Color.MAGENTA)) {
            return "magenta";
        }
        return "gray";
    }

    // Structure
    public void setGame(SlimeGame game) {
        this.game = game;
    }

    public void setInput(SharedInput input) {
        this.input = input;
    }

    public void setStuff(MenuStuff stuff) {
        this.stuff = stuff;
    }
}
package com.epicness.slimeland.game.logic;

import static com.epicness.fundamentals.utils.ColorUtils.colorFromString;
import static com.epicness.slimeland.game.GameConstants.MACHINE_PROPERTY;

import com.badlogic.gdx.graphics.Color;
import com.epicness.fundamentals.stuff.grid.Cell;
import com.epicness.slimeland.game.stuff.GameStuff;
import com.epicness.slimeland.game.stuff.machines.Machine;
import com.epicness.slimeland.menu.stuff.Player;

public class StateLoader {

    // Structure
    private GameLogic logic;
    private GameStuff stuff;

    public void setup(Player player) {
        String[] colorArray = player.getColors().split("-");
        Color color1 = colorFromString(colorArray[0]);
        Color color2 = colorFromString(colorArray[1]);

        applyColors(color1, color2);
    }

    private void applyColors(Color color1, Color color2) {
        logic.getCloudHandler().setColors(color1, color2);
        logic.getBuildingHandler().setColors(color1, color2);

        for (int i = 0; i < stuff.getSlimes().size; i++) {
            stuff.getSlimes().get(i).setColors(color1, color2);
        }
        stuff.getBuildMenu().setColors(color1, color2);
        Cell[][] cells = stuff.getGrid().getCells();
        for (int column = 0; column < cells.length; column++) {
            for (int row = 0; row < cells[column].length; row++) {
                Machine machine = (Machine) cells[column][row].getProperties().get(MACHINE_PROPERTY);
                if (machine == null) {
                    continue;
                }
                machine.setColors(color1, color2);
            }
        }
    }

    // Structure
    public void setLogic(GameLogic logic) {
        this.logic = logic;
    }

    public void setStuff(GameStuff stuff) {
        this.stuff = stuff;
    }
}
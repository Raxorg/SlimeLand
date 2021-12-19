package com.epicness.slimeland.game.logic;

import static com.epicness.slimeland.SlimeConstants.HIDDEN_X;
import static com.epicness.slimeland.SlimeConstants.HIDDEN_Y;
import static com.epicness.slimeland.game.GameConstants.MACHINE_PROPERTY;

import com.epicness.fundamentals.stuff.grid.Cell;
import com.epicness.slimeland.game.stuff.GameStuff;
import com.epicness.slimeland.game.stuff.machines.Machine;

public class GridHandler {

    // Structure
    private GameLogic logic;
    private GameStuff stuff;

    public void setup() {
        stuff.getCellSelector().setPosition(HIDDEN_X, HIDDEN_Y);
    }

    public void touchUp(float x, float y) {
        Cell[][] cells = stuff.getGrid().getCells();
        for (int column = 0; column < cells.length; column++) {
            for (int row = 0; row < cells[column].length; row++) {
                Cell cell = cells[column][row];
                if (cell.contains(x, y)) {
                    selectCell(cell);
                    return;
                }
            }
        }
        deselectCell();
    }

    private void selectCell(Cell cell) {
        Machine machine = (Machine) cell.getProperties().get(MACHINE_PROPERTY);
        if (machine != null) {
            deselectCell();
            selectMachine(machine);
            return;
        }
        stuff.getCellSelector().setPosition(cell.getX(), cell.getY());
        logic.getBuildMenuHandler().show(cell);
    }

    private void selectMachine(Machine machine) {
        switch (machine.getType()) {
            case FACTORY:

                break;
            case WORKSHOP:

                break;
            case TOWER:

                break;
            case ANTENNA:
                logic.getAntennaHandler().antennaTouched();
                break;
        }
    }

    private void deselectCell() {
        stuff.getCellSelector().setPosition(HIDDEN_X, HIDDEN_Y);
        logic.getBuildMenuHandler().hide();
    }

    // Structure
    public void setLogic(GameLogic logic) {
        this.logic = logic;
    }

    public void setStuff(GameStuff stuff) {
        this.stuff = stuff;
    }
}
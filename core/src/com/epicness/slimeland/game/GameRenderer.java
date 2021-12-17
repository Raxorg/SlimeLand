package com.epicness.slimeland.game;

import static com.epicness.fundamentals.SharedConstants.GRASS;
import static com.epicness.slimeland.game.GameConstants.MACHINE_PROPERTY;

import com.badlogic.gdx.utils.ScreenUtils;
import com.epicness.fundamentals.renderer.Renderer;
import com.epicness.fundamentals.stuff.grid.Cell;
import com.epicness.slimeland.game.stuff.GameStuff;
import com.epicness.slimeland.game.stuff.machines.Machine;

public class GameRenderer extends Renderer {

    @Override
    public void render() {
        GameStuff stuff = (GameStuff) this.stuff;

        ScreenUtils.clear(GRASS);

        spriteBatch.setProjectionMatrix(screen.getStaticCamera().combined);

        spriteBatch.begin();
        stuff.getGrid().draw(spriteBatch);
        for (int i = 0; i < stuff.getBushes().size(); i++) {
            stuff.getBushes().get(i).draw(spriteBatch);
        }
        Cell[][] cells = stuff.getGrid().getCells();
        for (int column = 0; column < cells.length; column++) {
            for (int row = 0; row < cells[column].length; row++) {
                Machine machine = (Machine) cells[column][row].getProperties().get(MACHINE_PROPERTY);
                if (machine != null) {
                    machine.draw(spriteBatch);
                }
            }
        }
        stuff.getCellSelector().draw(spriteBatch);
        for (int i = 0; i < stuff.getSlimes().size; i++) {
            stuff.getSlimes().get(i).draw(spriteBatch);
        }
        for (int i = 0; i < stuff.getClouds().length; i++) {
            stuff.getClouds()[i].drawBackground(spriteBatch);
        }
        for (int i = 0; i < stuff.getClouds().length; i++) {
            stuff.getClouds()[i].drawForeground(spriteBatch);
        }
        stuff.getBuildMenu().draw(spriteBatch);
        spriteBatch.end();
    }
}
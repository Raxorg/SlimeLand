package com.epicness.slimeland.game.logic;

import com.epicness.fundamentals.input.InputHandler;

public class GameInputHandler extends InputHandler {

    @Override
    public void touchUp(float x, float y) {
        GameLogic logic = (GameLogic) this.logic;
        logic.getBuildMenuHandler().touchUp(x, y);
        logic.getGridHandler().touchUp(x, y);
    }
}
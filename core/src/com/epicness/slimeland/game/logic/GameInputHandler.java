package com.epicness.slimeland.game.logic;

import com.epicness.fundamentals.input.InputHandler;

public class GameInputHandler extends InputHandler {

    @Override
    public void touchDown(float x, float y) {
        GameLogic logic = (GameLogic) this.logic;
        logic.getScrollBehavior().touchDown(y);
    }

    @Override
    public void touchDragged(float x, float y) {
        GameLogic logic = (GameLogic) this.logic;
        logic.getScrollBehavior().touchDragged(y);
    }

    @Override
    public void touchUp(float x, float y) {
        GameLogic logic = (GameLogic) this.logic;
        if (logic.getMultiplayerHandler().touchUp()) {
            return;
        }
        if (logic.getPlayerListHandler().touchUp(x, y)) {
            return;
        }
        logic.getBuildMenuHandler().touchUp(x, y);
        logic.getGridHandler().touchUp(x, y);
    }
}
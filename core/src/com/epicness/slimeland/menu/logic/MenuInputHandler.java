package com.epicness.slimeland.menu.logic;

import com.epicness.fundamentals.input.InputHandler;

public class MenuInputHandler extends InputHandler {

    @Override
    public void touchDown(float x, float y) {
        MenuLogic logic = (MenuLogic) this.logic;
        logic.getSlimeGridHandler().touchDown(x, y);
        logic.getScrollBehavior().touchDown(y);
    }

    @Override
    public void touchDragged(float x, float y) {
        MenuLogic logic = (MenuLogic) this.logic;
        logic.getSlimeGridHandler().touchDragged(x, y);
        logic.getScrollBehavior().touchDragged(y);
    }

    @Override
    public void touchUp(float x, float y) {
        MenuLogic logic = (MenuLogic) this.logic;
        logic.getSlimeGridHandler().touchUp(x, y);
    }
}
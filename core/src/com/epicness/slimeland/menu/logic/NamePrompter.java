package com.epicness.slimeland.menu.logic;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.epicness.fundamentals.input.SharedInput;

public class NamePrompter {

    // Structure
    private SharedInput input;
    private MenuLogic logic;

    public void promptName() {
        input.setEnabled(false);
        Gdx.input.getTextInput(new Input.TextInputListener() {
            @Override
            public void input(String name) {
                if (name.toUpperCase().matches("[A-Z]+")) {
                    if (name.length() > 2 && name.length() < 12) {
                        logic.getPlayerRegistrator().assignPlayerName(name);
                        input.setEnabled(true);
                    } else {
                        promptName();
                    }
                } else {
                    promptName();
                }
            }

            @Override
            public void canceled() {
                promptName();
            }
        }, "Choose a name", "", "3 to 11 letters");
    }

    // Structure
    public void setInput(SharedInput input) {
        this.input = input;
    }

    public void setLogic(MenuLogic logic) {
        this.logic = logic;
    }
}
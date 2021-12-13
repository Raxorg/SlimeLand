package com.epicness.slimeland.menu.logic;

import static com.epicness.slimeland.menu.MenuConstants.COLORS_PREF_KEY;
import static com.epicness.slimeland.menu.MenuConstants.HIDDEN_X;
import static com.epicness.slimeland.menu.MenuConstants.HIDDEN_Y;
import static com.epicness.slimeland.menu.MenuConstants.PREFS_PATH;

import com.epicness.fundamentals.input.SharedInput;
import com.epicness.slimeland.menu.stuff.MenuStuff;

public class PlayerChecker {

    // Structure
    private SharedInput input;
    private MenuLogic logic;
    private MenuStuff stuff;

    public void checkPlayer() {
        input.setEnabled(false);
        String colors = logic.getPreferencesHandler().loadString(PREFS_PATH, COLORS_PREF_KEY);
        if (colors.equals("")) {
            stuff.getLoadingOverlay().setPosition(HIDDEN_X, HIDDEN_Y);
            input.setEnabled(true);
            return;
        }
        joinGame(colors);
    }

    private void joinGame(String colors) {
        System.out.println(colors);
    }

    // Structure
    public void setInput(SharedInput input) {
        this.input = input;
    }

    public void setLogic(MenuLogic logic) {
        this.logic = logic;
    }

    public void setStuff(MenuStuff stuff) {
        this.stuff = stuff;
    }
}
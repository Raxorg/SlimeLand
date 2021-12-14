package com.epicness.slimeland.menu.logic;

import static com.epicness.slimeland.menu.MenuConstants.COLORS_PREF_KEY;
import static com.epicness.slimeland.menu.MenuConstants.HIDDEN_X;
import static com.epicness.slimeland.menu.MenuConstants.HIDDEN_Y;
import static com.epicness.slimeland.menu.MenuConstants.PREFS_PATH;

import com.epicness.fundamentals.input.SharedInput;
import com.epicness.fundamentals.logic.SharedLogic;
import com.epicness.slimeland.game.GameInitializer;
import com.epicness.slimeland.menu.stuff.MenuStuff;

public class PlayerChecker {

    // Structure
    private SharedInput input;
    private SharedLogic sharedLogic;
    private MenuLogic logic;
    private MenuStuff stuff;
    // Logic
    private String colors;

    public void checkPlayer() {
        input.setEnabled(false);
        colors = logic.getPreferencesHandler().loadString(PREFS_PATH, COLORS_PREF_KEY);
        if (colors.equals("")) {
            stuff.getOverlay().setPosition(HIDDEN_X, HIDDEN_Y);
            input.setEnabled(true);
            return;
        }
        stuff.getOverlay().setText("Welcome back");
        stuff.getOverlay().setPosition(0f, 0f);
    }

    public void touchDown() {
        if (stuff.getOverlay().getText().equals("Welcome back")) {
            joinGame(colors);
        }
    }

    private void joinGame(String colors) {
        sharedLogic.getTransitionHandler().startTransition(new GameInitializer());
        sharedLogic.getTransitionHandler().allowTransition();
        System.out.println(colors);
    }

    // Structure
    public void setInput(SharedInput input) {
        this.input = input;
    }

    public void setSharedLogic(SharedLogic sharedLogic) {
        this.sharedLogic = sharedLogic;
    }

    public void setLogic(MenuLogic logic) {
        this.logic = logic;
    }

    public void setStuff(MenuStuff stuff) {
        this.stuff = stuff;
    }
}
package com.epicness.slimeland.menu.logic;

import com.epicness.fundamentals.input.SharedInput;
import com.epicness.slimeland.SlimeGame;
import com.epicness.slimeland.menu.stuff.MenuStuff;

public class VersionChecker {

    // Structure
    private SlimeGame slimeGame;
    private SharedInput input;
    private MenuLogic logic;
    private MenuStuff stuff;

    public void checkVersion() {
        input.setEnabled(false);
        slimeGame.getFirestore().fetchVersion(version -> {
            if (version == null) {
                stuff.getOverlay().setPosition(0f, 0f);
                stuff.getOverlay().setText("SOMETHING WENT WRONG");
                return;
            }
            if (!version.equals(slimeGame.getVersion())) {
                stuff.getOverlay().setPosition(0f, 0f);
                stuff.getOverlay().setText("NEW VERSION AVAILABLE");
                return;
            }
            logic.getPlayerChecker().checkPlayer();
        });
    }

    // Structure
    public void setSlimeGame(SlimeGame slimeGame) {
        this.slimeGame = slimeGame;
    }

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
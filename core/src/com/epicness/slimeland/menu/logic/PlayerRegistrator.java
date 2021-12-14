package com.epicness.slimeland.menu.logic;

import static com.epicness.slimeland.menu.MenuConstants.COLORS_PREF_KEY;
import static com.epicness.slimeland.menu.MenuConstants.HIDDEN_X;
import static com.epicness.slimeland.menu.MenuConstants.HIDDEN_Y;
import static com.epicness.slimeland.menu.MenuConstants.NAME_PREF_KEY;
import static com.epicness.slimeland.menu.MenuConstants.PREFS_PATH;

import com.epicness.fundamentals.input.SharedInput;
import com.epicness.fundamentals.logic.SharedLogic;
import com.epicness.slimeland.SlimeGame;
import com.epicness.slimeland.game.GameInitializer;
import com.epicness.slimeland.menu.stuff.MenuStuff;
import com.epicness.slimeland.menu.stuff.Player;

public class PlayerRegistrator {

    // Structure
    private SlimeGame game;
    private SharedInput input;
    private SharedLogic sharedLogic;
    private MenuLogic logic;
    private MenuStuff stuff;
    // Logic
    private Player player;
    private String error;

    public void init() {
        player = new Player();
    }

    public void assignPlayerName(String name) {
        player.setName(name);
    }

    public void assignPlayerColors(String colors) {
        player.setColors(colors);
    }

    public void registerPlayer() {
        awaitResponse();
        game.getFirestore().registerPlayer(player, success -> {
            if (success) {
                logic.getPreferencesHandler().saveString(PREFS_PATH, NAME_PREF_KEY, player.getName());
                logic.getPreferencesHandler().saveString(PREFS_PATH, COLORS_PREF_KEY, player.getColors());
                sharedLogic.getTransitionHandler().startTransition(new GameInitializer());
                sharedLogic.getTransitionHandler().allowTransition();
            }
        }, errorMessage -> {
            stuff.getOverlay().setText(errorMessage);
            error = errorMessage;
            input.setEnabled(true);
        });
    }

    private void awaitResponse() {
        input.setEnabled(false);
        stuff.getOverlay().setPosition(0f, 0f);
        stuff.getOverlay().setText("THONKING");
    }

    public void touchUp() {
        if (error == null) {
            return;
        }
        stuff.getOverlay().setPosition(HIDDEN_X, HIDDEN_Y);
        stuff.getOverlay().setText("");
        switch (error) {
            case "Duplicate name":
                logic.getNamePrompter().promptName();
                logic.getSlimeGridHandler().setup();
                break;
            case "Colors unavailable":
                logic.getSlimeGridHandler().setup();
        }
        error = null;
    }

    // Structure
    public void setGame(SlimeGame game) {
        this.game = game;
    }

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
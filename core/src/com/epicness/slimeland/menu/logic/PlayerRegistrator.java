package com.epicness.slimeland.menu.logic;

import static com.epicness.slimeland.SlimeConstants.BUILDING_PREFS_PATH;
import static com.epicness.slimeland.SlimeConstants.BUILD_CHARGES_PREF_KEY;
import static com.epicness.slimeland.SlimeConstants.COLORS_PREF_KEY;
import static com.epicness.slimeland.SlimeConstants.HIDDEN_X;
import static com.epicness.slimeland.SlimeConstants.HIDDEN_Y;
import static com.epicness.slimeland.SlimeConstants.NAME_PREF_KEY;
import static com.epicness.slimeland.SlimeConstants.PREFS_PATH;
import static com.epicness.slimeland.SlimeConstants.SLIME_AGILITY_PREF_KEY;
import static com.epicness.slimeland.SlimeConstants.SLIME_QUANTITY_PREF_KEY;
import static com.epicness.slimeland.SlimeConstants.SLIME_STRENGTH_PREF_KEY;
import static com.epicness.slimeland.game.GameConstants.ANTENNA_ID;

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
    private String playerName, playerColors;
    private String error;

    public void assignPlayerName(String name) {
        playerName = name;
    }

    public void assignPlayerColors(String colors) {
        playerColors = colors;
    }

    public void registerPlayer() {
        awaitResponse();
        Player player = new Player(playerName, playerColors, 1, 1, 1);
        game.getFirestore().registerPlayer(player, success -> {
            logic.getPreferencesHandler().saveString(PREFS_PATH, NAME_PREF_KEY, player.getName());
            logic.getPreferencesHandler().saveString(PREFS_PATH, COLORS_PREF_KEY, player.getColors());
            logic.getPreferencesHandler().saveInteger(PREFS_PATH, BUILD_CHARGES_PREF_KEY, 1);
            logic.getPreferencesHandler().saveInteger(PREFS_PATH, SLIME_QUANTITY_PREF_KEY, 1);
            logic.getPreferencesHandler().saveInteger(PREFS_PATH, SLIME_STRENGTH_PREF_KEY, 1);
            logic.getPreferencesHandler().saveInteger(PREFS_PATH, SLIME_AGILITY_PREF_KEY, 1);
            logic.getPreferencesHandler().saveInteger(BUILDING_PREFS_PATH, "3-3", ANTENNA_ID);
            sharedLogic.getTransitionHandler().startTransition(new GameInitializer(player));
            sharedLogic.getTransitionHandler().allowTransition();
        }, availableColors -> {
            String[] availableColorPairs = availableColors.split(",");
            logic.getSlimeGridHandler().updateAvailableColors(availableColorPairs);
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
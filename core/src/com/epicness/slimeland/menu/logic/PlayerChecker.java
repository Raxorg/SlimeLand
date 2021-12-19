package com.epicness.slimeland.menu.logic;

import static com.epicness.slimeland.SlimeConstants.COLORS_PREF_KEY;
import static com.epicness.slimeland.SlimeConstants.HIDDEN_X;
import static com.epicness.slimeland.SlimeConstants.HIDDEN_Y;
import static com.epicness.slimeland.SlimeConstants.NAME_PREF_KEY;
import static com.epicness.slimeland.SlimeConstants.PREFS_PATH;
import static com.epicness.slimeland.SlimeConstants.SLIME_AGILITY_PREF_KEY;
import static com.epicness.slimeland.SlimeConstants.SLIME_QUANTITY_PREF_KEY;
import static com.epicness.slimeland.SlimeConstants.SLIME_STRENGTH_PREF_KEY;
import static com.epicness.slimeland.menu.MenuConstants.WELCOME_BACK_MESSAGE;

import com.epicness.fundamentals.input.SharedInput;
import com.epicness.fundamentals.logic.SharedLogic;
import com.epicness.slimeland.game.GameInitializer;
import com.epicness.slimeland.menu.stuff.MenuStuff;
import com.epicness.slimeland.menu.stuff.Player;

public class PlayerChecker {

    // Structure
    private SharedInput input;
    private SharedLogic sharedLogic;
    private MenuLogic logic;
    private MenuStuff stuff;
    // Logic
    private String name;
    private String colors;
    private int slimeQuantity, slimeStrength, slimeAgility;

    public void checkPlayer() {
        input.setEnabled(false);
        colors = logic.getPreferencesHandler().loadString(PREFS_PATH, COLORS_PREF_KEY);
        if (colors.equals("")) {
            stuff.getOverlay().setPosition(HIDDEN_X, HIDDEN_Y);
            logic.getNamePrompter().promptName();
            return;
        }
        restorePlayerState();
    }

    private void restorePlayerState() {
        name = logic.getPreferencesHandler().loadString(PREFS_PATH, NAME_PREF_KEY);
        slimeQuantity = logic.getPreferencesHandler().loadInteger(PREFS_PATH, SLIME_QUANTITY_PREF_KEY);
        slimeStrength = logic.getPreferencesHandler().loadInteger(PREFS_PATH, SLIME_STRENGTH_PREF_KEY);
        slimeAgility = logic.getPreferencesHandler().loadInteger(PREFS_PATH, SLIME_AGILITY_PREF_KEY);
        stuff.getOverlay().setText(WELCOME_BACK_MESSAGE + " " + name);
        stuff.getOverlay().setPosition(0f, 0f);
        input.setEnabled(true);
        logic.getSlimeGridHandler().disableInput();
    }

    public void touchUp() {
        if (stuff.getOverlay().getText().startsWith(WELCOME_BACK_MESSAGE)) {
            Player player = new Player(name, colors, slimeQuantity, slimeStrength, slimeAgility);
            sharedLogic.getTransitionHandler().startTransition(new GameInitializer(player));
            sharedLogic.getTransitionHandler().allowTransition();
        }
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
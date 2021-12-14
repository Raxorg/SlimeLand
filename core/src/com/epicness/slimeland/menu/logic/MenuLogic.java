package com.epicness.slimeland.menu.logic;

import com.badlogic.gdx.Game;
import com.epicness.fundamentals.input.SharedInput;
import com.epicness.fundamentals.logic.Logic;
import com.epicness.fundamentals.logic.PreferencesHandler;
import com.epicness.fundamentals.logic.SharedLogic;
import com.epicness.fundamentals.logic.behaviors.ScrollBehavior;
import com.epicness.fundamentals.stuff.Stuff;
import com.epicness.slimeland.SlimeGame;
import com.epicness.slimeland.menu.stuff.MenuStuff;

public class MenuLogic extends Logic {

    private final ColorSelectionHandler colorSelectionHandler;
    private final MenuInputHandler menuInputHandler;
    private final PlayerChecker playerChecker;
    private final SlimeGridHandler slimeGridHandler;

    private final PreferencesHandler preferencesHandler;
    private final ScrollBehavior scrollBehavior;

    public MenuLogic(SharedLogic sharedLogic) {
        super(sharedLogic);
        colorSelectionHandler = new ColorSelectionHandler();
        menuInputHandler = new MenuInputHandler();
        playerChecker = new PlayerChecker();
        slimeGridHandler = new SlimeGridHandler();

        preferencesHandler = new PreferencesHandler();
        scrollBehavior = new ScrollBehavior();

        colorSelectionHandler.setSharedLogic(sharedLogic);
        playerChecker.setSharedLogic(sharedLogic);

        menuInputHandler.setLogic(this);
        playerChecker.setLogic(this);
        slimeGridHandler.setLogic(this);
    }

    @Override
    public void initialLogic() {
        menuInputHandler.setupInput();
        playerChecker.checkPlayer();
        slimeGridHandler.setup();
    }

    @Override
    public void update(float delta) {
        sharedLogic.getAssetLoader().update();
        sharedLogic.getTransitionHandler().update();

        scrollBehavior.update(delta);
        slimeGridHandler.update();
    }

    @Override
    public void setGame(Game game) {
        SlimeGame slimeGame = (SlimeGame) game;
        colorSelectionHandler.setGame(slimeGame);
    }

    @Override
    public void setInput(SharedInput input) {
        colorSelectionHandler.setInput(input);
        menuInputHandler.setInput(input);
        playerChecker.setInput(input);
    }

    @Override
    public void setStuff(Stuff stuff) {
        MenuStuff menuStuff = (MenuStuff) stuff;
        colorSelectionHandler.setStuff(menuStuff);
        playerChecker.setStuff(menuStuff);
        slimeGridHandler.setStuff(menuStuff);
    }

    public ColorSelectionHandler getColorSelectionHandler() {
        return colorSelectionHandler;
    }

    public PlayerChecker getPlayerChecker() {
        return playerChecker;
    }

    public SlimeGridHandler getSlimeGridHandler() {
        return slimeGridHandler;
    }

    public PreferencesHandler getPreferencesHandler() {
        return preferencesHandler;
    }

    public ScrollBehavior getScrollBehavior() {
        return scrollBehavior;
    }
}
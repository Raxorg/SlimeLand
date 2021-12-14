package com.epicness.slimeland.menu.logic;

import com.badlogic.gdx.Game;
import com.epicness.fundamentals.input.SharedInput;
import com.epicness.fundamentals.logic.Logic;
import com.epicness.fundamentals.logic.PreferencesHandler;
import com.epicness.fundamentals.logic.SharedLogic;
import com.epicness.fundamentals.logic.behaviors.ScrollBehavior;
import com.epicness.fundamentals.stuff.SharedStuff;
import com.epicness.fundamentals.stuff.Stuff;
import com.epicness.slimeland.SlimeGame;
import com.epicness.slimeland.menu.stuff.MenuStuff;

public class MenuLogic extends Logic {

    private final BackgroundUpdater backgroundUpdater;
    private final ColorSelectionHandler colorSelectionHandler;
    private final MenuInputHandler menuInputHandler;
    private final NamePrompter namePrompter;
    private final PlayerChecker playerChecker;
    private final PlayerRegistrator playerRegistrator;
    private final SlimeGridHandler slimeGridHandler;

    private final PreferencesHandler preferencesHandler;
    private final ScrollBehavior scrollBehavior;

    public MenuLogic(SharedLogic sharedLogic) {
        super(sharedLogic);
        backgroundUpdater = new BackgroundUpdater();
        colorSelectionHandler = new ColorSelectionHandler();
        menuInputHandler = new MenuInputHandler();
        namePrompter = new NamePrompter();
        playerChecker = new PlayerChecker();
        playerRegistrator = new PlayerRegistrator();
        slimeGridHandler = new SlimeGridHandler();

        preferencesHandler = new PreferencesHandler();
        scrollBehavior = new ScrollBehavior();

        playerChecker.setSharedLogic(sharedLogic);
        playerRegistrator.setSharedLogic(sharedLogic);

        colorSelectionHandler.setLogic(this);
        menuInputHandler.setLogic(this);
        namePrompter.setLogic(this);
        playerChecker.setLogic(this);
        playerRegistrator.setLogic(this);
        slimeGridHandler.setLogic(this);
    }

    @Override
    public void initialLogic() {
        menuInputHandler.setupInput();
        playerChecker.checkPlayer();
        playerRegistrator.init();
        slimeGridHandler.setup();
    }

    @Override
    public void update(float delta) {
        sharedLogic.getAssetLoader().update();
        sharedLogic.getTransitionHandler().update();

        backgroundUpdater.update(delta);
        scrollBehavior.update(delta);
        slimeGridHandler.update();
    }

    @Override
    public void setGame(Game game) {
        SlimeGame slimeGame = (SlimeGame) game;
        playerRegistrator.setGame(slimeGame);
    }

    @Override
    public void setInput(SharedInput input) {
        menuInputHandler.setInput(input);
        namePrompter.setInput(input);
        playerChecker.setInput(input);
        playerRegistrator.setInput(input);
    }

    @Override
    public void setSharedStuff(SharedStuff sharedStuff) {
        backgroundUpdater.setSharedStuff(sharedStuff);
    }

    @Override
    public void setStuff(Stuff stuff) {
        MenuStuff menuStuff = (MenuStuff) stuff;
        playerChecker.setStuff(menuStuff);
        playerRegistrator.setStuff(menuStuff);
        slimeGridHandler.setStuff(menuStuff);
    }

    public ColorSelectionHandler getColorSelectionHandler() {
        return colorSelectionHandler;
    }

    public NamePrompter getNamePrompter() {
        return namePrompter;
    }

    public PlayerChecker getPlayerChecker() {
        return playerChecker;
    }

    public PlayerRegistrator getPlayerRegistrator() {
        return playerRegistrator;
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
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
    private final MenuInputHandler menuInputHandler;
    private final NamePrompter namePrompter;
    private final PlayerChecker playerChecker;
    private final PlayerRegistrator playerRegistrator;
    private final SlimeGridHandler slimeGridHandler;
    private final VersionChecker versionChecker;

    private final PreferencesHandler preferencesHandler;
    private final ScrollBehavior scrollBehavior;

    public MenuLogic(SharedLogic sharedLogic) {
        super(sharedLogic);
        backgroundUpdater = new BackgroundUpdater();
        menuInputHandler = new MenuInputHandler();
        namePrompter = new NamePrompter();
        playerChecker = new PlayerChecker();
        playerRegistrator = new PlayerRegistrator();
        slimeGridHandler = new SlimeGridHandler();
        versionChecker = new VersionChecker();

        preferencesHandler = new PreferencesHandler();
        scrollBehavior = new ScrollBehavior();

        playerChecker.setSharedLogic(sharedLogic);
        playerRegistrator.setSharedLogic(sharedLogic);

        menuInputHandler.setLogic(this);
        namePrompter.setLogic(this);
        playerChecker.setLogic(this);
        playerRegistrator.setLogic(this);
        slimeGridHandler.setLogic(this);
        versionChecker.setLogic(this);
    }

    @Override
    public void initialLogic() {
        menuInputHandler.setupInput();
        versionChecker.checkVersion();
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
        versionChecker.setSlimeGame(slimeGame);
    }

    @Override
    public void setInput(SharedInput input) {
        menuInputHandler.setInput(input);
        namePrompter.setInput(input);
        playerChecker.setInput(input);
        playerRegistrator.setInput(input);
        versionChecker.setInput(input);
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
        versionChecker.setStuff(menuStuff);
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
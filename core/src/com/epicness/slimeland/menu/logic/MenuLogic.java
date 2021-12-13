package com.epicness.slimeland.menu.logic;

import com.epicness.fundamentals.input.SharedInput;
import com.epicness.fundamentals.logic.Logic;
import com.epicness.fundamentals.logic.PreferencesHandler;
import com.epicness.fundamentals.logic.SharedLogic;
import com.epicness.fundamentals.logic.behaviors.ScrollBehavior;
import com.epicness.fundamentals.stuff.Stuff;
import com.epicness.slimeland.menu.stuff.MenuStuff;

public class MenuLogic extends Logic {

    private final MenuInputHandler menuInputHandler;
    private final PlayerChecker playerChecker;
    private final SlimeGridHandler slimeGridHandler;

    private final PreferencesHandler preferencesHandler;
    private final ScrollBehavior scrollBehavior;

    public MenuLogic(SharedLogic sharedLogic) {
        super(sharedLogic);
        menuInputHandler = new MenuInputHandler();
        playerChecker = new PlayerChecker();
        slimeGridHandler = new SlimeGridHandler();

        preferencesHandler = new PreferencesHandler();
        scrollBehavior = new ScrollBehavior();

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
    public void setInput(SharedInput input) {
        menuInputHandler.setInput(input);
        playerChecker.setInput(input);
    }

    @Override
    public void setStuff(Stuff stuff) {
        MenuStuff menuStuff = (MenuStuff) stuff;
        playerChecker.setStuff(menuStuff);
        slimeGridHandler.setStuff(menuStuff);
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
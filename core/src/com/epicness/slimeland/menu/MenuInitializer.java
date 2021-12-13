package com.epicness.slimeland.menu;

import com.epicness.fundamentals.Initializer;
import com.epicness.fundamentals.SharedResources;
import com.epicness.slimeland.menu.logic.MenuLogic;
import com.epicness.slimeland.menu.stuff.MenuStuff;

public class MenuInitializer extends Initializer {

    public MenuInitializer(MenuAssets assets) {
        super(assets);
    }

    @Override
    public void initialize(SharedResources sharedResources) {
        logic = new MenuLogic(sharedResources.getLogic());
        renderer = new MenuRenderer();
        stuff = new MenuStuff();
        super.initialize(sharedResources);
    }
}
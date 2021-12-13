package com.epicness.slimeland.game;

import com.epicness.fundamentals.Initializer;
import com.epicness.fundamentals.SharedResources;
import com.epicness.fundamentals.assets.Assets;
import com.epicness.slimeland.game.logic.GameLogic;
import com.epicness.slimeland.game.stuff.GameStuff;

public class GameInitializer extends Initializer {


    public GameInitializer(GameAssets assets) {
        super(assets);
    }

    @Override
    public void initialize(SharedResources sharedResources) {
        logic = new GameLogic(sharedResources.getLogic());
        renderer = new GameRenderer();
        stuff = new GameStuff();
        super.initialize(sharedResources);
    }
}
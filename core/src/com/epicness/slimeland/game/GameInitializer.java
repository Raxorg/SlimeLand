package com.epicness.slimeland.game;

import com.epicness.fundamentals.Initializer;
import com.epicness.fundamentals.SharedResources;
import com.epicness.slimeland.game.logic.GameLogic;
import com.epicness.slimeland.game.stuff.GameStuff;
import com.epicness.slimeland.menu.stuff.Player;

public class GameInitializer extends Initializer {

    private final Player player;

    public GameInitializer(Player player) {
        super(new GameAssets());
        this.player = player;
    }

    @Override
    public void initialize(SharedResources sharedResources) {
        logic = new GameLogic(sharedResources.getLogic());
        renderer = new GameRenderer();
        stuff = new GameStuff();
        super.initialize(sharedResources);
        ((GameLogic) logic).initState(player);
    }
}
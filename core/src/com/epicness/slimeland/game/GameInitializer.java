package com.epicness.slimeland.game;

import static com.epicness.fundamentals.utils.ColorUtils.colorFromString;

import com.badlogic.gdx.graphics.Color;
import com.epicness.fundamentals.Initializer;
import com.epicness.fundamentals.SharedResources;
import com.epicness.slimeland.game.logic.GameLogic;
import com.epicness.slimeland.game.stuff.GameStuff;

public class GameInitializer extends Initializer {

    private final String name;
    private final Color color1, color2;

    public GameInitializer(String name, String colors) {
        super(new GameAssets());
        this.name = name;
        String[] colorArray = colors.split("-");
        color1 = colorFromString(colorArray[0]);
        color2 = colorFromString(colorArray[1]);
    }

    @Override
    public void initialize(SharedResources sharedResources) {
        logic = new GameLogic(sharedResources.getLogic());
        renderer = new GameRenderer();
        stuff = new GameStuff();
        super.initialize(sharedResources);
        ((GameLogic) logic).initState(name, color1, color2);
    }
}
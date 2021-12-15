package com.epicness.slimeland.game.logic;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.Color;
import com.epicness.fundamentals.input.SharedInput;
import com.epicness.fundamentals.logic.Logic;
import com.epicness.fundamentals.logic.SharedLogic;
import com.epicness.fundamentals.stuff.Stuff;
import com.epicness.slimeland.SlimeGame;
import com.epicness.slimeland.game.stuff.GameStuff;

public class GameLogic extends Logic {

    private final BuildMenuHandler buildMenuHandler;
    private final CloudHandler cloudHandler;
    private final GameInputHandler gameInputHandler;
    private final GridHandler gridHandler;
    private final SlimeHandler slimeHandler;
    private final StateHandler stateHandler;

    public GameLogic(SharedLogic sharedLogic) {
        super(sharedLogic);

        buildMenuHandler = new BuildMenuHandler();
        cloudHandler = new CloudHandler();
        gameInputHandler = new GameInputHandler();
        gridHandler = new GridHandler();
        slimeHandler = new SlimeHandler();
        stateHandler = new StateHandler();

        gameInputHandler.setLogic(this);
        gridHandler.setLogic(this);
    }

    @Override
    public void initialLogic() {
        buildMenuHandler.setup();
        gameInputHandler.setupInput();
        gridHandler.setup();
    }

    public void initState(String name, Color color1, Color color2) {
        stateHandler.setup(name, color1, color2);
    }

    @Override
    public void update(float delta) {
        buildMenuHandler.update(delta);
        cloudHandler.update(delta);
        slimeHandler.update(delta);
    }

    @Override
    public void setGame(Game game) {
        SlimeGame slimeGame = (SlimeGame) game;
    }

    @Override
    public void setInput(SharedInput input) {
        gameInputHandler.setInput(input);
    }

    @Override
    public void setStuff(Stuff stuff) {
        GameStuff gameStuff = (GameStuff) stuff;
        buildMenuHandler.setStuff(gameStuff);
        cloudHandler.setStuff(gameStuff);
        gridHandler.setStuff(gameStuff);
        slimeHandler.setStuff(gameStuff);
        stateHandler.setStuff(gameStuff);
    }

    public BuildMenuHandler getBuildMenuHandler() {
        return buildMenuHandler;
    }

    public GridHandler getGridHandler() {
        return gridHandler;
    }

    public StateHandler getStateHandler() {
        return stateHandler;
    }
}
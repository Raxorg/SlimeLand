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

    private final CloudHandler cloudHandler;
    private final GameInputHandler gameInputHandler;
    private final StateHandler stateHandler;

    public GameLogic(SharedLogic sharedLogic) {
        super(sharedLogic);

        cloudHandler = new CloudHandler();
        gameInputHandler = new GameInputHandler();
        stateHandler = new StateHandler();
    }

    @Override
    public void initialLogic() {
        gameInputHandler.setupInput();
    }

    public void initState(String name, Color color1, Color color2) {
        stateHandler.setup(name, color1, color2);
    }

    @Override
    public void update(float delta) {
        cloudHandler.update(delta);
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
        cloudHandler.setStuff(gameStuff);
        stateHandler.setStuff(gameStuff);
    }

    public StateHandler getStateHandler() {
        return stateHandler;
    }
}
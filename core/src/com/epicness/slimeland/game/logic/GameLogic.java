package com.epicness.slimeland.game.logic;

import com.badlogic.gdx.Game;
import com.epicness.fundamentals.input.SharedInput;
import com.epicness.fundamentals.logic.Logic;
import com.epicness.fundamentals.logic.SharedLogic;
import com.epicness.slimeland.SlimeGame;

public class GameLogic extends Logic {

    private final GameInputHandler gameInputHandler;

    public GameLogic(SharedLogic sharedLogic) {
        super(sharedLogic);

        gameInputHandler = new GameInputHandler();
    }

    @Override
    public void initialLogic() {
        gameInputHandler.setupInput();
    }

    @Override
    public void update(float delta) {

    }

    @Override
    public void setGame(Game game) {
        SlimeGame slimeGame = (SlimeGame) game;
    }

    @Override
    public void setInput(SharedInput input) {
        gameInputHandler.setInput(input);
    }
}
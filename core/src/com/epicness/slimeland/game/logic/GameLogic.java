package com.epicness.slimeland.game.logic;

import com.badlogic.gdx.Game;
import com.epicness.fundamentals.input.SharedInput;
import com.epicness.fundamentals.logic.Logic;
import com.epicness.fundamentals.logic.SharedLogic;
import com.epicness.fundamentals.stuff.Stuff;
import com.epicness.slimeland.SlimeGame;
import com.epicness.slimeland.game.stuff.GameStuff;

public class GameLogic extends Logic {

    private final CloudHandler cloudHandler;
    private final GameInputHandler gameInputHandler;

    public GameLogic(SharedLogic sharedLogic) {
        super(sharedLogic);

        cloudHandler = new CloudHandler();
        gameInputHandler = new GameInputHandler();
    }

    @Override
    public void initialLogic() {
        gameInputHandler.setupInput();
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
    }
}
package com.epicness.slimeland.game.logic;

import com.badlogic.gdx.Game;
import com.epicness.fundamentals.logic.Logic;
import com.epicness.fundamentals.logic.SharedLogic;
import com.epicness.slimeland.SlimeGame;

public class GameLogic extends Logic {

    private final PlayerRegistrator playerRegistrator;

    public GameLogic(SharedLogic sharedLogic) {
        super(sharedLogic);

        playerRegistrator = new PlayerRegistrator();
    }

    @Override
    public void initialLogic() {

    }

    @Override
    public void update(float delta) {

    }

    @Override
    public void setGame(Game game) {
        SlimeGame slimeGame = (SlimeGame) game;
        playerRegistrator.setGame(slimeGame);
    }

    public PlayerRegistrator getPlayerRegistrator() {
        return playerRegistrator;
    }
}
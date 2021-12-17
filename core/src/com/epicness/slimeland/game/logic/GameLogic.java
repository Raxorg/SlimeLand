package com.epicness.slimeland.game.logic;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.epicness.fundamentals.assets.Assets;
import com.epicness.fundamentals.input.SharedInput;
import com.epicness.fundamentals.logic.Logic;
import com.epicness.fundamentals.logic.SharedLogic;
import com.epicness.fundamentals.stuff.Stuff;
import com.epicness.slimeland.SlimeGame;
import com.epicness.slimeland.game.GameAssets;
import com.epicness.slimeland.game.logic.decorative.CloudHandler;
import com.epicness.slimeland.game.logic.decorative.MusicHandler;
import com.epicness.slimeland.game.logic.machines.BuildMenuHandler;
import com.epicness.slimeland.game.logic.machines.BuildingHandler;
import com.epicness.slimeland.game.logic.slimes.HidingHandler;
import com.epicness.slimeland.game.logic.slimes.RoamingHandler;
import com.epicness.slimeland.game.logic.slimes.SlimeHandler;
import com.epicness.slimeland.game.logic.towerdefense.WaveHandler;
import com.epicness.slimeland.game.stuff.GameStuff;

public class GameLogic extends Logic {

    private final CloudHandler cloudHandler;
    private final MusicHandler musicHandler;

    private final BuildingHandler buildingHandler;
    private final BuildMenuHandler buildMenuHandler;

    private final HidingHandler hidingHandler;
    private final RoamingHandler roamingHandler;
    private final SlimeHandler slimeHandler;

    private final WaveHandler waveHandler;

    private final GameInputHandler gameInputHandler;
    private final GridHandler gridHandler;
    private final StateHandler stateHandler;

    public GameLogic(SharedLogic sharedLogic) {
        super(sharedLogic);

        cloudHandler = new CloudHandler();
        musicHandler = new MusicHandler();

        buildingHandler = new BuildingHandler();
        buildMenuHandler = new BuildMenuHandler();

        hidingHandler = new HidingHandler();
        roamingHandler = new RoamingHandler();
        slimeHandler = new SlimeHandler();

        waveHandler = new WaveHandler();

        gameInputHandler = new GameInputHandler();
        gridHandler = new GridHandler();
        stateHandler = new StateHandler();

        buildingHandler.setSharedLogic(sharedLogic);

        buildingHandler.setLogic(this);
        buildMenuHandler.setLogic(this);

        slimeHandler.setLogic(this);

        gameInputHandler.setLogic(this);
        gridHandler.setLogic(this);
    }
    /*
     * "Chill" Kevin MacLeod (incompetech.com)
     * Licensed under Creative Commons: By Attribution 4.0 License
     * http://creativecommons.org/licenses/by/4.0/
     * */

    @Override
    public void initialLogic() {
        musicHandler.playMusic();

        buildingHandler.loadState();
        buildMenuHandler.setup();

        slimeHandler.spawnSlimes();

        gameInputHandler.setupInput();
        gridHandler.setup();
    }

    public void initState(String name, Color color1, Color color2) {
        stateHandler.setup(name, color1, color2);
    }

    @Override
    public void update(float delta) {
        cloudHandler.update(delta);

        buildMenuHandler.update(delta);

        waveHandler.update(delta);

        slimeHandler.update(delta);

        if (Gdx.input.justTouched()) {
            waveHandler.startWave();
        }
    }

    @Override
    public void setGame(Game game) {
        SlimeGame slimeGame = (SlimeGame) game;
    }

    @Override
    public void setAssets(Assets assets) {
        GameAssets gameAssets = (GameAssets) assets;

        musicHandler.setAssets(gameAssets);

        buildingHandler.setAssets(gameAssets);

        slimeHandler.setAssets(gameAssets);

        waveHandler.setAssets(gameAssets);
    }

    @Override
    public void setInput(SharedInput input) {
        gameInputHandler.setInput(input);
    }

    @Override
    public void setStuff(Stuff stuff) {
        GameStuff gameStuff = (GameStuff) stuff;
        cloudHandler.setStuff(gameStuff);

        buildingHandler.setStuff(gameStuff);
        buildMenuHandler.setStuff(gameStuff);

        waveHandler.setStuff(gameStuff);

        gridHandler.setStuff(gameStuff);
        slimeHandler.setStuff(gameStuff);
        stateHandler.setStuff(gameStuff);
    }

    public BuildingHandler getBuildingHandler() {
        return buildingHandler;
    }

    public BuildMenuHandler getBuildMenuHandler() {
        return buildMenuHandler;
    }

    public HidingHandler getHidingHandler() {
        return hidingHandler;
    }

    public RoamingHandler getRoamingHandler() {
        return roamingHandler;
    }

    public GridHandler getGridHandler() {
        return gridHandler;
    }

    public StateHandler getStateHandler() {
        return stateHandler;
    }
}
package com.epicness.slimeland.game.logic;

import com.badlogic.gdx.Game;
import com.epicness.fundamentals.assets.Assets;
import com.epicness.fundamentals.assets.SharedAssets;
import com.epicness.fundamentals.input.SharedInput;
import com.epicness.fundamentals.logic.Logic;
import com.epicness.fundamentals.logic.SharedLogic;
import com.epicness.fundamentals.logic.behaviors.ScrollBehavior;
import com.epicness.fundamentals.stuff.Stuff;
import com.epicness.slimeland.SlimeGame;
import com.epicness.slimeland.game.GameAssets;
import com.epicness.slimeland.game.logic.decorative.CloudHandler;
import com.epicness.slimeland.game.logic.decorative.MusicHandler;
import com.epicness.slimeland.game.logic.machines.BuildMenuHandler;
import com.epicness.slimeland.game.logic.machines.BuildingHandler;
import com.epicness.slimeland.game.logic.multiplayer.MultiplayerHandler;
import com.epicness.slimeland.game.logic.multiplayer.PlayerListHandler;
import com.epicness.slimeland.game.logic.slimes.HidingHandler;
import com.epicness.slimeland.game.logic.slimes.RoamingHandler;
import com.epicness.slimeland.game.logic.slimes.SlimeHandler;
import com.epicness.slimeland.game.logic.towerdefense.BulletHandler;
import com.epicness.slimeland.game.logic.towerdefense.WaveHandler;
import com.epicness.slimeland.game.stuff.GameStuff;
import com.epicness.slimeland.menu.stuff.Player;

public class GameLogic extends Logic {

    // Decorative
    private final CloudHandler cloudHandler;
    private final MusicHandler musicHandler;
    // Machines
    private final BuildingHandler buildingHandler;
    private final BuildMenuHandler buildMenuHandler;
    // Multiplayer
    private final MultiplayerHandler multiplayerHandler;
    private final PlayerListHandler playerListHandler;
    // Slimes
    private final HidingHandler hidingHandler;
    private final RoamingHandler roamingHandler;
    private final SlimeHandler slimeHandler;
    // Tower Defense
    private final BulletHandler bulletHandler;
    private final WaveHandler waveHandler;

    private final GameInputHandler gameInputHandler;
    private final GridHandler gridHandler;
    private final StateHandler stateHandler;
    // Behaviors
    private final ScrollBehavior scrollBehavior;

    public GameLogic(SharedLogic sharedLogic) {
        super(sharedLogic);
        // Decorative
        cloudHandler = new CloudHandler();
        musicHandler = new MusicHandler();
        // Machines
        buildingHandler = new BuildingHandler();
        buildMenuHandler = new BuildMenuHandler();
        // Multiplayer
        multiplayerHandler = new MultiplayerHandler();
        playerListHandler = new PlayerListHandler();
        // Slimes
        hidingHandler = new HidingHandler();
        roamingHandler = new RoamingHandler();
        slimeHandler = new SlimeHandler();
        // Tower Defense
        bulletHandler = new BulletHandler();
        waveHandler = new WaveHandler();

        gameInputHandler = new GameInputHandler();
        gridHandler = new GridHandler();
        stateHandler = new StateHandler();

        scrollBehavior = new ScrollBehavior();

        stateHandler.setSharedLogic(sharedLogic);

        // Machines
        buildingHandler.setLogic(this);
        buildMenuHandler.setLogic(this);
        // Multiplayer
        multiplayerHandler.setLogic(this);
        playerListHandler.setLogic(this);
        // Slimes
        slimeHandler.setLogic(this);

        gameInputHandler.setLogic(this);
        gridHandler.setLogic(this);
        stateHandler.setLogic(this);
    }
    /*
     * "Chill" Kevin MacLeod (incompetech.com)
     * Licensed under Creative Commons: By Attribution 4.0 License
     * http://creativecommons.org/licenses/by/4.0/
     * */

    @Override
    public void initialLogic() {
        musicHandler.playMusic();
        // Machines
        buildingHandler.loadState();
        buildMenuHandler.setup();
        // Multiplayer
        multiplayerHandler.fetchPlayerInfo();
        playerListHandler.hide();
        // Slimes
        slimeHandler.spawnSlimes();

        gameInputHandler.setupInput();
        gridHandler.setup();
    }

    public void initState(Player player) {
        stateHandler.loadPlayerState(player);
    }

    @Override
    public void update(float delta) {
        // Decorative
        cloudHandler.update(delta);
        // Machines
        buildMenuHandler.update(delta);
        // Multiplayer
        multiplayerHandler.update();
        // Slimes
        slimeHandler.update(delta);
        // Tower Defense
        bulletHandler.update(delta);
        waveHandler.update(delta);
        // Behaviors
        scrollBehavior.update(delta);
    }

    @Override
    public void setGame(Game game) {
        SlimeGame slimeGame = (SlimeGame) game;
        multiplayerHandler.setGame(slimeGame);
    }

    @Override
    public void setSharedAssets(SharedAssets sharedAssets) {
        playerListHandler.setSharedAssets(sharedAssets);
    }

    @Override
    public void setAssets(Assets assets) {
        GameAssets gameAssets = (GameAssets) assets;

        musicHandler.setAssets(gameAssets);

        buildingHandler.setAssets(gameAssets);
        // Multiplayer
        playerListHandler.setAssets(gameAssets);
        // Slimes
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
        // Multiplayer
        multiplayerHandler.setStuff(gameStuff);
        playerListHandler.setStuff(gameStuff);
        // Tower Defense
        bulletHandler.setStuff(gameStuff);
        waveHandler.setStuff(gameStuff);

        gridHandler.setStuff(gameStuff);
        slimeHandler.setStuff(gameStuff);
        stateHandler.setStuff(gameStuff);
    }

    public CloudHandler getCloudHandler() {
        return cloudHandler;
    }

    public BuildingHandler getBuildingHandler() {
        return buildingHandler;
    }

    public BuildMenuHandler getBuildMenuHandler() {
        return buildMenuHandler;
    }

    // Multiplayer
    public MultiplayerHandler getMultiplayerHandler() {
        return multiplayerHandler;
    }

    public PlayerListHandler getPlayerListHandler() {
        return playerListHandler;
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

    public ScrollBehavior getScrollBehavior() {
        return scrollBehavior;
    }
}
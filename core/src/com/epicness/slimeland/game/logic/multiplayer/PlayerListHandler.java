package com.epicness.slimeland.game.logic.multiplayer;

import com.epicness.slimeland.game.logic.GameLogic;
import com.epicness.slimeland.game.stuff.GameStuff;
import com.epicness.slimeland.game.stuff.playerlist.PlayerList;

public class PlayerListHandler {

    // Structure
    private GameLogic logic;
    private GameStuff stuff;

    public void show() {
        PlayerList playerList = stuff.getPlayerList();
    }

    public void touchDown() {

    }

    public void touchDragged() {

    }

    public void hide() {
        PlayerList playerList = stuff.getPlayerList();
    }

    // Structure
    public void setLogic(GameLogic logic) {
        this.logic = logic;
    }

    public void setStuff(GameStuff stuff) {
        this.stuff = stuff;
    }
}
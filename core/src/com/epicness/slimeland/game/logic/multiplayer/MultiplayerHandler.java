package com.epicness.slimeland.game.logic.multiplayer;

import com.epicness.slimeland.SlimeGame;
import com.epicness.slimeland.game.stuff.GameStuff;

import java.util.Map;

public class MultiplayerHandler {

    private SlimeGame game;
    private GameStuff stuff;

    public void fetchPlayerInfo() {
        game.getFirestore().fetchPlayerData(playerData -> {
            if (playerData == null) {
                handleFailure();
                return;
            }
            updatePlayerData(playerData);
        });
    }

    private void handleFailure() {
        System.out.println("FAILURE FETCHING PLAYER DATA");
    }

    private void updatePlayerData(Map<String, Object> playerData) {
        for (Map.Entry<String, Object> entry : playerData.entrySet()) {
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }
    }

    public void setGame(SlimeGame game) {
        this.game = game;
    }

    public void setStuff(GameStuff stuff) {
        this.stuff = stuff;
    }
}
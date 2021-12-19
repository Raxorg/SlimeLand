package com.epicness.slimeland.game.logic.multiplayer;

import static com.epicness.fundamentals.utils.ColorUtils.colorFromString;

import com.badlogic.gdx.graphics.Color;
import com.epicness.slimeland.SlimeGame;
import com.epicness.slimeland.game.logic.GameLogic;
import com.epicness.slimeland.game.stuff.GameStuff;

import java.util.Map;

public class MultiplayerHandler {

    // Structure
    private SlimeGame game;
    private GameLogic logic;
    private GameStuff stuff;
    // Logic
    private Map<String, Object> playerData;
    private boolean update;

    public void fetchPlayerInfo() {
        game.getFirestore().fetchPlayerData(playerData -> {
            if (playerData == null) {
                handleFailure();
                return;
            }
            this.playerData = playerData;
            update = true;
        });
    }

    public void update() {
        if (!update) {
            return;
        }
        updatePlayerData(playerData);
        update = false;
    }

    private void handleFailure() {
        System.out.println("FAILURE FETCHING PLAYER DATA");
        System.out.println("SOMETHING WENT WRONG");
    }

    private void updatePlayerData(Map<String, Object> playerData) {
        stuff.getPlayerList().getPlayerInfos().begin();
        stuff.getPlayerList().getPlayerInfos().clear();
        for (Map.Entry<String, Object> entry : playerData.entrySet()) {
            String playerName = entry.getKey();
            String[] playerInfo = ((String) entry.getValue()).split(",");
            String[] colors = playerInfo[0].split("-");
            Color color1 = colorFromString(colors[0]);
            Color color2 = colorFromString(colors[1]);
            int slimeQuantity = Integer.parseInt(playerInfo[1]);
            int slimeStrength = Integer.parseInt(playerInfo[2]);
            int slimeAgility = Integer.parseInt(playerInfo[3]);
            logic.getPlayerListHandler().addPlayer(playerName, color1, color2, slimeQuantity, slimeStrength, slimeAgility);
        }
        stuff.getPlayerList().getPlayerInfos().end();
        logic.getPlayerListHandler().updateScrolling();
    }

    // Structure
    public void setGame(SlimeGame game) {
        this.game = game;
    }

    public void setLogic(GameLogic logic) {
        this.logic = logic;
    }

    public void setStuff(GameStuff stuff) {
        this.stuff = stuff;
    }
}
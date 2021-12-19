package com.epicness.slimeland.game.logic.multiplayer;

import static com.epicness.fundamentals.SharedConstants.CAMERA_HEIGHT;
import static com.epicness.fundamentals.SharedConstants.OPAQUE_TRANSPARENT;
import static com.epicness.fundamentals.SharedConstants.TRANSPARENT;
import static com.epicness.fundamentals.SharedConstants.WHITE_OPAQUE_TRANSPARENT;
import static com.epicness.slimeland.SlimeConstants.HIDDEN_X;
import static com.epicness.slimeland.game.GameConstants.PLAYER_INFO_HEIGHT;
import static com.epicness.slimeland.game.GameConstants.PLAYER_INFO_X;
import static com.epicness.slimeland.game.GameConstants.PLAYER_LIST_MIN_Y;
import static com.epicness.slimeland.game.GameConstants.PLAYER_LIST_X;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.utils.DelayedRemovalArray;
import com.epicness.fundamentals.assets.SharedAssets;
import com.epicness.slimeland.game.GameAssets;
import com.epicness.slimeland.game.logic.GameLogic;
import com.epicness.slimeland.game.stuff.GameStuff;
import com.epicness.slimeland.game.stuff.playerlist.PlayerInfo;
import com.epicness.slimeland.game.stuff.playerlist.PlayerList;

public class PlayerListHandler {

    // Structure
    private SharedAssets sharedAssets;
    private GameAssets assets;
    private GameLogic logic;
    private GameStuff stuff;
    // Logic
    private boolean showingList;

    public void updateScrolling() {
        float maxY = stuff.getPlayerList().getPlayerInfos().size * PLAYER_INFO_HEIGHT - PLAYER_INFO_HEIGHT;
        logic.getScrollBehavior().setup(stuff.getPlayerList(), PLAYER_LIST_MIN_Y, maxY);
    }

    public void addPlayer(String playerName, Color color1, Color color2, int slimeQuantity, int slimeStrength, int slimeAgility) {
        DelayedRemovalArray<PlayerInfo> playerInfos = stuff.getPlayerList().getPlayerInfos();
        Color backgroundColor = playerInfos.size % 2 == 0 ? TRANSPARENT : OPAQUE_TRANSPARENT;
        boolean thisPlayer = logic.getStateHandler().getPlayerName().equals(playerName);
        if (thisPlayer) {
            backgroundColor = backgroundColor.cpy().lerp(WHITE_OPAQUE_TRANSPARENT, 0.6f);
        }
        PlayerInfo playerInfo = new PlayerInfo(
                sharedAssets.getPixel(),
                assets.getBigPixelFont(),
                assets.getLeftSlime(), assets.getRightSlime(),
                playerName,
                color1, color2,
                slimeQuantity, slimeStrength, slimeAgility,
                backgroundColor
        );
        playerInfo.setX(showingList ? PLAYER_INFO_X : HIDDEN_X);
        playerInfo.setY(CAMERA_HEIGHT - PLAYER_INFO_HEIGHT * 2f - PLAYER_INFO_HEIGHT * playerInfos.size);
        playerInfos.add(playerInfo);
    }

    public void show() {
        PlayerList playerList = stuff.getPlayerList();
        playerList.setX(PLAYER_LIST_X);
        showingList = true;
    }

    public void hide() {
        PlayerList playerList = stuff.getPlayerList();
        playerList.setX(HIDDEN_X);
        showingList = false;
    }

    public boolean touchUp(float x, float y) {
        if (!showingList) {
            return false;
        }
        if (!stuff.getPlayerList().contains(x, y)) {
            hide();
            return false;
        }
        return true;
    }

    // Structure
    public void setSharedAssets(SharedAssets sharedAssets) {
        this.sharedAssets = sharedAssets;
    }

    public void setAssets(GameAssets assets) {
        this.assets = assets;
    }

    public void setLogic(GameLogic logic) {
        this.logic = logic;
    }

    public void setStuff(GameStuff stuff) {
        this.stuff = stuff;
    }
}
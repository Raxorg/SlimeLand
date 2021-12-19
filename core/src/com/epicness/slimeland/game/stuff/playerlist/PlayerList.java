package com.epicness.slimeland.game.stuff.playerlist;

import static com.epicness.fundamentals.SharedConstants.TRANSPARENT;
import static com.epicness.slimeland.game.GameConstants.PLAYER_INFO_HEIGHT;
import static com.epicness.slimeland.game.GameConstants.PLAYER_LIST_HEIGHT;
import static com.epicness.slimeland.game.GameConstants.PLAYER_LIST_WIDTH;
import static com.epicness.slimeland.game.GameConstants.PLAYER_LIST_X;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.DelayedRemovalArray;
import com.epicness.fundamentals.assets.SharedAssets;
import com.epicness.fundamentals.stuff.Buttonable;
import com.epicness.fundamentals.stuff.Scrollable;
import com.epicness.fundamentals.stuff.Sprited;
import com.epicness.slimeland.game.GameAssets;

public class PlayerList implements Buttonable, Scrollable {

    private final Sprited background;
    private final PlayerListHeader playerListHeader;
    private final DelayedRemovalArray<PlayerInfo> playerInfos;

    public PlayerList(SharedAssets sharedAssets, GameAssets assets) {
        background = new Sprited(sharedAssets.getPixel());
        background.setX(PLAYER_LIST_X);
        background.setSize(PLAYER_LIST_WIDTH, PLAYER_LIST_HEIGHT);
        background.setColor(TRANSPARENT);

        playerListHeader = new PlayerListHeader(sharedAssets.getPixel(), assets.getMediumPixelFont());

        playerInfos = new DelayedRemovalArray<>();
    }

    public void draw(SpriteBatch spriteBatch) {
        background.draw(spriteBatch);
        for (int i = 0; i < playerInfos.size; i++) {
            playerInfos.get(i).draw(spriteBatch);
        }
        playerListHeader.draw(spriteBatch);
    }

    @Override
    public boolean contains(float x, float y) {
        return background.contains(x, y);
    }

    @Override
    public float getY() {
        return playerInfos.get(0).getY();
    }

    @Override
    public void setY(float y) {
        for (int i = 0; i < playerInfos.size; i++) {
            playerInfos.get(i).setY(y - PLAYER_INFO_HEIGHT * i);
        }
    }

    @Override
    public void translateY(float y) {
        for (int i = 0; i < playerInfos.size; i++) {
            playerInfos.get(i).translateY(y);
        }
    }

    public void setX(float x) {
        background.setX(x);
        for (int i = 0; i < playerInfos.size; i++) {
            playerInfos.get(i).setX(x);
        }
        playerListHeader.setX(x);
    }

    public DelayedRemovalArray<PlayerInfo> getPlayerInfos() {
        return playerInfos;
    }
}
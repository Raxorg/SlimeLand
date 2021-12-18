package com.epicness.slimeland.game.stuff.playerlist;

import static com.epicness.slimeland.game.GameConstants.PLAYER_INFO_HEIGHT;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.DelayedRemovalArray;
import com.epicness.fundamentals.stuff.Scrollable;
import com.epicness.fundamentals.stuff.Sprited;

public class PlayerList implements Scrollable {

    private final Sprited background;
    private final DelayedRemovalArray<PlayerInfo> playerInfos;

    public PlayerList(Sprite backgroundSprite) {
        background = new Sprited(backgroundSprite);
        playerInfos = new DelayedRemovalArray<>();
    }

    public void draw(SpriteBatch spriteBatch) {
        background.draw(spriteBatch);
        for (int i = 0; i < playerInfos.size; i++) {
            playerInfos.get(i).draw(spriteBatch);
        }
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

    public DelayedRemovalArray<PlayerInfo> getPlayerInfos() {
        return playerInfos;
    }
}
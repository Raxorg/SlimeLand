package com.epicness.slimeland.game.stuff.playerlist;

import static com.epicness.slimeland.game.GameConstants.PLAYER_INFO_AGILITY_OFFSET_X;
import static com.epicness.slimeland.game.GameConstants.PLAYER_INFO_AGILITY_WIDTH;
import static com.epicness.slimeland.game.GameConstants.PLAYER_INFO_HEIGHT;
import static com.epicness.slimeland.game.GameConstants.PLAYER_INFO_NAME_OFFSET_X;
import static com.epicness.slimeland.game.GameConstants.PLAYER_INFO_NAME_WIDTH;
import static com.epicness.slimeland.game.GameConstants.PLAYER_INFO_QUANTITY_OFFSET_X;
import static com.epicness.slimeland.game.GameConstants.PLAYER_INFO_QUANTITY_WIDTH;
import static com.epicness.slimeland.game.GameConstants.PLAYER_INFO_SLIME_OFFSET_X;
import static com.epicness.slimeland.game.GameConstants.PLAYER_INFO_STRENGTH_OFFSET_X;
import static com.epicness.slimeland.game.GameConstants.PLAYER_INFO_STRENGTH_WIDTH;
import static com.epicness.slimeland.game.GameConstants.PLAYER_INFO_WIDTH;
import static com.epicness.slimeland.game.GameConstants.SLIME_HEIGHT;
import static com.epicness.slimeland.game.GameConstants.SLIME_WIDTH;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Align;
import com.epicness.fundamentals.stuff.DualSprited;
import com.epicness.fundamentals.stuff.Scrollable;
import com.epicness.fundamentals.stuff.Sprited;
import com.epicness.fundamentals.stuff.Text;

public class PlayerInfo implements Scrollable {

    private final Sprited background;
    private final Text name, quantity, strength, agility;
    private final DualSprited slime;

    public PlayerInfo(Sprite backgroundSprite, BitmapFont font, Sprite leftSlime, Sprite rightSlime, String playerName,
                      Color leftColor, Color rightColor, int slimeQuantity, int slimeStrength, int slimeAgility,
                      Color backgroundColor) {
        background = new Sprited(backgroundSprite);
        background.setSize(PLAYER_INFO_WIDTH, PLAYER_INFO_HEIGHT);
        background.setColor(backgroundColor);

        name = new Text(font);
        name.setText(playerName);
        name.setTextTargetWidth(PLAYER_INFO_NAME_WIDTH);
        name.setHorizontalAlignment(Align.center);
        name.setCenterVertical(true);
        name.setColor(Color.YELLOW.cpy().lerp(Color.WHITE, 0.7f));

        slime = new DualSprited(leftSlime, rightSlime);
        slime.setSize(SLIME_WIDTH, SLIME_HEIGHT);
        slime.setBackgroundColor(leftColor);
        slime.setForegroundColor(rightColor);

        quantity = new Text(font);
        quantity.setText(slimeQuantity + "");
        quantity.setTextTargetWidth(PLAYER_INFO_QUANTITY_WIDTH);
        quantity.setHorizontalAlignment(Align.center);
        quantity.setCenterVertical(true);
        quantity.setColor(Color.BLUE.cpy().lerp(Color.WHITE, 0.7f));

        strength = new Text(font);
        strength.setText(slimeStrength + "");
        strength.setTextTargetWidth(PLAYER_INFO_STRENGTH_WIDTH);
        strength.setHorizontalAlignment(Align.center);
        strength.setCenterVertical(true);
        strength.setColor(Color.RED.cpy().lerp(Color.WHITE, 0.7f));

        agility = new Text(font);
        agility.setText(slimeAgility + "");
        agility.setTextTargetWidth(PLAYER_INFO_AGILITY_WIDTH);
        agility.setHorizontalAlignment(Align.center);
        agility.setCenterVertical(true);
        agility.setColor(Color.GREEN.cpy().lerp(Color.WHITE, 0.7f));
    }

    public void draw(SpriteBatch spriteBatch) {
        background.draw(spriteBatch);
        name.draw(spriteBatch);
        slime.draw(spriteBatch);
        quantity.draw(spriteBatch);
        strength.draw(spriteBatch);
        agility.draw(spriteBatch);
    }

    @Override
    public float getY() {
        return background.getY();
    }

    @Override
    public void setY(float y) {
        background.setY(y);
        name.setY(y + PLAYER_INFO_HEIGHT / 2f);
        slime.setY(y + PLAYER_INFO_HEIGHT / 2f - slime.getHeight() / 2f);
        quantity.setY(y + PLAYER_INFO_HEIGHT / 2f);
        strength.setY(y + PLAYER_INFO_HEIGHT / 2f);
        agility.setY(y + PLAYER_INFO_HEIGHT / 2f);
    }

    @Override
    public void translateY(float y) {
        background.translateY(y);
        name.translateY(y);
        slime.translateY(y);
        quantity.translateY(y);
        strength.translateY(y);
        agility.translateY(y);
    }

    public void setX(float x) {
        background.setX(x);
        name.setX(x + PLAYER_INFO_NAME_OFFSET_X);
        slime.setX(x + PLAYER_INFO_SLIME_OFFSET_X);
        quantity.setX(x + PLAYER_INFO_QUANTITY_OFFSET_X);
        strength.setX(x + PLAYER_INFO_STRENGTH_OFFSET_X);
        agility.setX(x + PLAYER_INFO_AGILITY_OFFSET_X);
    }
}
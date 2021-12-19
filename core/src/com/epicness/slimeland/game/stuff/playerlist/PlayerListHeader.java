package com.epicness.slimeland.game.stuff.playerlist;

import static com.epicness.fundamentals.SharedConstants.OPAQUE_TRANSPARENT;
import static com.epicness.slimeland.game.GameConstants.LIST_AGILITY_LABEL_OFFSET_X;
import static com.epicness.slimeland.game.GameConstants.LIST_AGILITY_LABEL_WIDTH;
import static com.epicness.slimeland.game.GameConstants.LIST_ARMY_LABEL_OFFSET_X;
import static com.epicness.slimeland.game.GameConstants.LIST_ARMY_LABEL_WIDTH;
import static com.epicness.slimeland.game.GameConstants.LIST_COLORS_LABEL_OFFSET_X;
import static com.epicness.slimeland.game.GameConstants.LIST_COLORS_LABEL_WIDTH;
import static com.epicness.slimeland.game.GameConstants.LIST_HEADER_HEIGHT;
import static com.epicness.slimeland.game.GameConstants.LIST_HEADER_Y;
import static com.epicness.slimeland.game.GameConstants.LIST_PLAYER_LABEL_OFFSET_X;
import static com.epicness.slimeland.game.GameConstants.LIST_PLAYER_LABEL_WIDTH;
import static com.epicness.slimeland.game.GameConstants.LIST_STRENGTH_LABEL_OFFSET_X;
import static com.epicness.slimeland.game.GameConstants.LIST_STRENGTH_LABEL_WIDTH;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.epicness.fundamentals.stuff.SpritedText;

public class PlayerListHeader {

    private final SpritedText playerLabel, colorsLabel, armyLabel, strengthLabel, agilityLabel;

    public PlayerListHeader(Sprite backgroundSprite, BitmapFont font) {
        playerLabel = new SpritedText(backgroundSprite, font);
        playerLabel.setY(LIST_HEADER_Y);
        playerLabel.setSize(LIST_PLAYER_LABEL_WIDTH, LIST_HEADER_HEIGHT);
        playerLabel.setText("Player");
        playerLabel.setTextColor(Color.YELLOW.cpy().lerp(Color.WHITE, 0.7f));
        playerLabel.setColor(OPAQUE_TRANSPARENT);

        colorsLabel = new SpritedText(backgroundSprite, font);
        colorsLabel.setY(LIST_HEADER_Y);
        colorsLabel.setSize(LIST_COLORS_LABEL_WIDTH, LIST_HEADER_HEIGHT);
        colorsLabel.setText("Colors");
        colorsLabel.setTextColor(Color.ORANGE.cpy().lerp(Color.WHITE, 0.7f));
        colorsLabel.setColor(OPAQUE_TRANSPARENT);

        armyLabel = new SpritedText(backgroundSprite, font);
        armyLabel.setY(LIST_HEADER_Y);
        armyLabel.setSize(LIST_ARMY_LABEL_WIDTH, LIST_HEADER_HEIGHT);
        armyLabel.setText("Army");
        armyLabel.setTextColor(Color.BLUE.cpy().lerp(Color.WHITE, 0.7f));
        armyLabel.setColor(OPAQUE_TRANSPARENT);

        strengthLabel = new SpritedText(backgroundSprite, font);
        strengthLabel.setY(LIST_HEADER_Y);
        strengthLabel.setSize(LIST_STRENGTH_LABEL_WIDTH, LIST_HEADER_HEIGHT);
        strengthLabel.setText("Strength");
        strengthLabel.setTextColor(Color.RED.cpy().lerp(Color.WHITE, 0.7f));
        strengthLabel.setColor(OPAQUE_TRANSPARENT);

        agilityLabel = new SpritedText(backgroundSprite, font);
        agilityLabel.setY(LIST_HEADER_Y);
        agilityLabel.setSize(LIST_AGILITY_LABEL_WIDTH, LIST_HEADER_HEIGHT);
        agilityLabel.setText("Agility");
        agilityLabel.setTextColor(Color.GREEN.cpy().lerp(Color.WHITE, 0.7f));
        agilityLabel.setColor(OPAQUE_TRANSPARENT);
    }

    public void draw(SpriteBatch spriteBatch) {
        playerLabel.draw(spriteBatch);
        colorsLabel.draw(spriteBatch);
        armyLabel.draw(spriteBatch);
        strengthLabel.draw(spriteBatch);
        agilityLabel.draw(spriteBatch);
    }

    public void setX(float x) {
        playerLabel.setX(x + LIST_PLAYER_LABEL_OFFSET_X);
        colorsLabel.setX(x + LIST_COLORS_LABEL_OFFSET_X);
        armyLabel.setX(x + LIST_ARMY_LABEL_OFFSET_X);
        strengthLabel.setX(x + LIST_STRENGTH_LABEL_OFFSET_X);
        agilityLabel.setX(x + LIST_AGILITY_LABEL_OFFSET_X);
    }
}
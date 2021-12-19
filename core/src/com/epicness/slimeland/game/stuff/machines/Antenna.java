package com.epicness.slimeland.game.stuff.machines;

import static com.epicness.slimeland.game.GameConstants.MACHINE_SIZE;
import static com.epicness.slimeland.game.stuff.machines.MachineType.ANTENNA;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.Align;
import com.epicness.fundamentals.stuff.Text;

public class Antenna extends Machine {

    private final Text countdown;
    private float timer;

    public Antenna(Sprite sprite1, Sprite sprite2, BitmapFont font) {
        super(ANTENNA, sprite1, sprite2);
        countdown = new Text(font);
        countdown.setTextTargetWidth(MACHINE_SIZE);
        countdown.setHorizontalAlignment(Align.center);
        countdown.setCenterVertical(true);
    }

    @Override
    public void draw(SpriteBatch spriteBatch) {
        super.draw(spriteBatch);
        countdown.draw(spriteBatch);
    }

    @Override
    public void setPosition(float x, float y) {
        super.setPosition(x, y);
        countdown.setPosition(x, y + MACHINE_SIZE / 2f);
    }

    public float getTimer() {
        return timer;
    }

    public void setTimer(float timer) {
        this.timer = timer;
        if (timer <= 0f) {
            countdown.setText("");
            return;
        }
        countdown.setText(MathUtils.ceil(timer) + "");
    }
}
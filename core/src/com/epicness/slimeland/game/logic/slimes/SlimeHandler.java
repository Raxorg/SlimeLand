package com.epicness.slimeland.game.logic.slimes;

import static com.epicness.fundamentals.SharedConstants.CAMERA_HEIGHT;
import static com.epicness.fundamentals.SharedConstants.CAMERA_WIDTH;
import static com.epicness.slimeland.game.GameConstants.SLIME_HEIGHT;
import static com.epicness.slimeland.game.GameConstants.SLIME_WIDTH;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.DelayedRemovalArray;
import com.epicness.slimeland.game.GameAssets;
import com.epicness.slimeland.game.logic.GameLogic;
import com.epicness.slimeland.game.stuff.GameStuff;
import com.epicness.slimeland.game.stuff.slimes.Slime;

public class SlimeHandler {

    // Structure
    private GameAssets assets;
    private GameLogic logic;
    private GameStuff stuff;
    // Logic
    private Color color1, color2;

    public void spawnSlimes(int quantity) {
        DelayedRemovalArray<Slime> slimes = stuff.getSlimes();
        for (int i = 0; i < quantity; i++) {
            Slime slime = new Slime(assets.getLeftSlime(), assets.getRightSlime());
            float x = MathUtils.random(0, CAMERA_WIDTH - SLIME_WIDTH);
            float y = MathUtils.random(0, CAMERA_HEIGHT - SLIME_HEIGHT);
            slime.setPosition(x, y);
            slime.setSize(SLIME_WIDTH, SLIME_HEIGHT);
            slime.setColors(color1, color2);
            slimes.add(slime);
        }
    }

    public void update(float delta) {
        DelayedRemovalArray<Slime> slimes = stuff.getSlimes();
        for (int i = 0; i < slimes.size; i++) {
            Slime slime = slimes.get(i);
            switch (slime.getBehavior()) {
                case ROAMING:
                    logic.getRoamingHandler().handleSlimeRoaming(slime, delta);
                    break;
                case HIDING:
                    logic.getHidingHandler().handleSlimeHiding(slime, delta);
                    break;
                case RACING:
                    break;
            }
        }
    }

    public void setColors(Color color1, Color color2) {
        this.color1 = color1;
        this.color2 = color2;
    }

    public void saveSlimeQuantity() {
        logic.getStateHandler().setSlimeQuantity(stuff.getSlimes().size);
    }

    // Structure
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
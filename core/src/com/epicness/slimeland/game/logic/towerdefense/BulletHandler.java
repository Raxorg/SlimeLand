package com.epicness.slimeland.game.logic.towerdefense;

import static com.epicness.slimeland.game.GameConstants.BULLET_GROWTH_RATE;
import static com.epicness.slimeland.game.GameConstants.BULLET_MAX_SIZE;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.DelayedRemovalArray;
import com.epicness.slimeland.game.GameAssets;
import com.epicness.slimeland.game.logic.GameLogic;
import com.epicness.slimeland.game.stuff.GameStuff;
import com.epicness.slimeland.game.stuff.machines.Bullet;
import com.epicness.slimeland.game.stuff.machines.Tower;
import com.epicness.slimeland.game.stuff.slimes.ForeignSlime;

public class BulletHandler {

    // Structure
    private GameAssets assets;
    private GameLogic logic;
    private GameStuff stuff;
    // Logic
    private Color color1, color2;

    public void spawnBullet(Tower tower) {
        float originX = tower.getX() + tower.getWidth() / 2f;
        float originY = tower.getY() + tower.getHeight() * 0.725f;
        Bullet bullet = new Bullet(assets.getTowerBullet(), new Vector2(originX, originY));
        if (color1 != null && color2 != null) {
            bullet.setColor(MathUtils.randomBoolean() ? color1 : color2);
        }
        stuff.getBullets().add(bullet);
    }

    public void update(float delta) {
        DelayedRemovalArray<Bullet> bullets = stuff.getBullets();
        stuff.getForeignSlimes().begin();
        for (int i = 0; i < bullets.size; i++) {
            growBullet(bullets.get(i), delta);
            selectTarget(bullets.get(i));
            handleShot(bullets.get(i), delta);
        }
        stuff.getForeignSlimes().end();
    }

    private void growBullet(Bullet bullet, float delta) {
        if (bullet.getSize() < BULLET_MAX_SIZE) {
            bullet.setSize(bullet.getSize() + delta * BULLET_GROWTH_RATE);
        } else if (bullet.getProgress() == 0f) {
            bullet.setSize(BULLET_MAX_SIZE);
        }
    }

    private void selectTarget(Bullet bullet) {
        DelayedRemovalArray<ForeignSlime> foreignSlimes = stuff.getForeignSlimes();
        if (foreignSlimes.isEmpty()) {
            return;
        }
        if (bullet.getTarget() != null) {
            return;
        }
        bullet.setTarget(foreignSlimes.random());
    }

    private void handleShot(Bullet bullet, float delta) {
        if (bullet.getSize() != BULLET_MAX_SIZE) {
            return;
        }
        ForeignSlime target = bullet.getTarget();
        if (target == null) {
            return;
        }
        if (target.isDead()) {
            bullet.setSize(0f);
            bullet.setProgress(0f);
            bullet.setTarget(null);
            return;
        }
        if (target.getY() + target.getHeight() < 0f) {
            bullet.setSize(0f);
            bullet.setProgress(0f);
            bullet.setTarget(null);
            return;
        }
        bullet.setProgress(bullet.getProgress() + delta / 1.5f);
        float targetX = target.getX() + target.getWidth() / 2f;
        float x = MathUtils.lerp(bullet.getOrigin().x - bullet.getSize() / 2f, targetX, bullet.getProgress());
        float targetY = target.getY() + target.getHeight() / 2f;
        float y = MathUtils.lerp(bullet.getOrigin().y - bullet.getSize() / 2f, targetY, bullet.getProgress());
        bullet.setPosition(x, y);
        if (bullet.getProgress() >= 1f) {
            bullet.setSize(0f);
            bullet.setProgress(0f);
            Color color = MathUtils.randomBoolean() ? color1 : color2;
            bullet.setColor(color);
            stuff.getForeignSlimes().removeValue(target, true);
            bullet.getTarget().setDead(true);
            bullet.setTarget(null);
            logic.getTowerStatsHandler().increaseKills();
        }
    }

    public void setColors(Color color1, Color color2) {
        this.color1 = color1;
        this.color2 = color2;
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
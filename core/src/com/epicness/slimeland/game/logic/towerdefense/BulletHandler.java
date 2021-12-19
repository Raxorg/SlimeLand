package com.epicness.slimeland.game.logic.towerdefense;

import static com.epicness.slimeland.game.GameConstants.BULLET_GROWTH_RATE;
import static com.epicness.slimeland.game.GameConstants.BULLET_MAX_SIZE;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.DelayedRemovalArray;
import com.epicness.slimeland.game.stuff.GameStuff;
import com.epicness.slimeland.game.stuff.machines.Bullet;
import com.epicness.slimeland.game.stuff.machines.Tower;
import com.epicness.slimeland.game.stuff.slimes.ForeignSlime;

public class BulletHandler {

    // Structure
    private GameStuff stuff;
    // Logic
    private Color color1, color2;

    public void setupBullets() {
        for (int i = 0; i < stuff.getBullets().size; i++) {
            Bullet bullet = stuff.getBullets().get(i);
            Tower tower = bullet.getTower();
            float originX = tower.getX() + tower.getWidth() / 2f - BULLET_MAX_SIZE / 2f;
            float originY = tower.getY() + tower.getHeight() * 0.725f - BULLET_MAX_SIZE / 2f;
            bullet.setOrigin(originX, originY);
        }
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
        if (bullet.getTarget() == null) {
            return;
        }
        bullet.setProgress(bullet.getProgress() + delta / 1.5f);
        float targetX = bullet.getTarget().getX() + bullet.getTarget().getWidth() / 2f;
        float x = MathUtils.lerp(bullet.getOrigin().x, targetX, bullet.getProgress());
        float targetY = bullet.getTarget().getY() + bullet.getTarget().getHeight() / 2f;
        float y = MathUtils.lerp(bullet.getOrigin().y, targetY, bullet.getProgress());
        bullet.setPosition(x, y);
        if (bullet.getProgress() >= 1f) {
            bullet.setSize(0f);
            bullet.setProgress(0f);
            Color color = MathUtils.randomBoolean() ? color1 : color2;
            bullet.setColor(color);
            stuff.getForeignSlimes().removeValue(bullet.getTarget(), true);
            bullet.setTarget(null);
        }
    }

    public void setColors(Color color1, Color color2) {
        this.color1 = color1;
        this.color2 = color2;
    }

    // Structure
    public void setStuff(GameStuff stuff) {
        this.stuff = stuff;
    }
}
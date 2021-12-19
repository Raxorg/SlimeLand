package com.epicness.slimeland.game.logic.towerdefense;

import static com.epicness.slimeland.game.GameConstants.BULLET_GROWTH_RATE;
import static com.epicness.slimeland.game.GameConstants.BULLET_MAX_SIZE;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.DelayedRemovalArray;
import com.epicness.slimeland.game.stuff.GameStuff;
import com.epicness.slimeland.game.stuff.machines.Bullet;

public class BulletHandler {

    // Structure
    private GameStuff stuff;

    public void update(float delta) {
        DelayedRemovalArray<Bullet> bullets = stuff.getBullets();
        for (int i = 0; i < bullets.size; i++) {
            growBullet(bullets.get(i), delta);
            handleShot(bullets.get(i), delta);
        }
    }

    private void growBullet(Bullet bullet, float delta) {
        if (bullet.getSize() < BULLET_MAX_SIZE) {
            bullet.setSize(bullet.getSize() + delta * BULLET_GROWTH_RATE);
        } else if (bullet.getProgress() == 0f) {
            bullet.setSize(BULLET_MAX_SIZE);
            bullet.updateOrigin();
        }
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
        }
    }

    // Structure

    public void setStuff(GameStuff stuff) {
        this.stuff = stuff;
    }
}
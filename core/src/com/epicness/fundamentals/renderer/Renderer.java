package com.epicness.fundamentals.renderer;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.epicness.fundamentals.SharedScreen;
import com.epicness.fundamentals.stuff.SharedStuff;
import com.epicness.fundamentals.stuff.Stuff;

public abstract class Renderer {

    // Structure
    protected SharedScreen screen;
    protected SharedStuff sharedStuff;
    protected Stuff stuff;
    // Rendering related
    protected final SpriteBatch spriteBatch;
    protected final ShapeRenderer shapeRenderer;

    public Renderer() {
        spriteBatch = new SpriteBatch();
        shapeRenderer = new ShapeRenderer();
        shapeRenderer.setAutoShapeType(true);
    }

    public void setProjectionMatrix() {
        spriteBatch.setProjectionMatrix(screen.getStaticCamera().combined);
        shapeRenderer.setProjectionMatrix(screen.getStaticCamera().combined);
    }

    public abstract void render();

    // Structure
    public void setScreen(SharedScreen screen) {
        this.screen = screen;
    }

    public void setSharedStuff(SharedStuff sharedStuff) {
        this.sharedStuff = sharedStuff;
    }

    public void setStuff(Stuff stuff) {
        this.stuff = stuff;
    }
}
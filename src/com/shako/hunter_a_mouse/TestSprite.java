package com.shako.hunter_a_mouse;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

/**
 * Тестовый спрайт.
 *
 * @author Timur Kashapov aka shako.
 * @since 1.0
 * 03-Sep-17
 */
public class TestSprite extends GameSprite {

    /** */
    private Texture texture = new Texture(Gdx.files.internal("assets\\testing\\test-square.png"));

    /** */
    public TestSprite() {
        super();

    } // testSprite()

    @Override
    public Texture getTexture() {
        return this.texture;
    }
} // TestSprite

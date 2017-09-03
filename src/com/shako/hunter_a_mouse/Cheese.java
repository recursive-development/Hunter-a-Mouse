package com.shako.hunter_a_mouse;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

/**
 * Драгоценный сыр.
 *
 * @author Timur Kashapov aka shako.
 * @since 1.0
 * 03-Sep-17
 */
public class Cheese extends GameSprite {

    /** */
    private Texture texture = new Texture(Gdx.files.internal("assets\\cheese01.png"));

    /** */
    public Cheese() {

        super();

        setX(400.0f);
        setY(250.0f);

    } // Cheese()

    @Override
    public Texture getTexture() {
        return this.texture;
    }
} // Cheese

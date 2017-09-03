package com.shako.hunter_a_mouse;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

/**
 * Главный герой - мышонок Моисей.
 *
 * @author Timur Kashapov aka shako.
 * @since 1.0
 * 03-Sep-17
 */
public class Mouse extends GameSprite {

    /** */
    private Texture texture = new Texture(Gdx.files.internal("assets\\mouse.png"));

    /** */
    public Mouse() {
        super();

        setX(0.0f);
        setY(0.0f);
        setV(5.0f);

    } // Mouse()

    @Override
    public Texture getTexture() {
        return this.texture;
    }
} // Mouse

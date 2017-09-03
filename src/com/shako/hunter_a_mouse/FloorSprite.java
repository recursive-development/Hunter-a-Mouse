package com.shako.hunter_a_mouse;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

/**
 * Фон.
 *
 * @author Timur Kashapov aka shako.
 * @since 1.0
 * 03-Sep-17
 */
public class FloorSprite extends GameSprite {

    /** */
    private Texture texture = new Texture(Gdx.files.internal("assets/floor.png"));

    /** */
    public FloorSprite() {

        super();

        setX(0.0f);
        setY(0.0f);

    } // FloorSprite()

} // FloorSprite

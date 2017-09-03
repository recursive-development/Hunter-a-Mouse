package com.shako.hunter_a_mouse;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

/**
 * Игровой спрайт.
 *
 * @author Timur Kashapov aka shako.
 * @since 1.0
 * 03-Sep-17
 */
public class GameSprite extends Sprite {

    /** */
    private float
            x, y, v,
            acceleration,
            mass,
            power;

    /** */
    private Texture texture;

    /** */
    public GameSprite() {

        this.x            = 0.0f;
        this.y            = 0.0f;
        this.v = 0.0f;
        this.acceleration = 0.0f;
        this.mass         = 0.0f;
        this.power        = 0.0f;
    } // GameSprite()


    @Override
    public float getX() {
        return x;
    }

    @Override
    public void setX(float x) {
        this.x = x;
    }

    @Override
    public float getY() {
        return y;
    }

    @Override
    public void setY(float y) {
        this.y = y;
    }

    /** */
    @Override
    public float getV() {
        return v;
    }

    /** */
    @Override
    public void setV(float v) {
        this.v = v;
    }

} // GameSprite




































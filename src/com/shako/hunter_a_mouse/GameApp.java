package com.shako.hunter_a_mouse;

 import com.badlogic.gdx.Game;
 import com.badlogic.gdx.Gdx;
 import com.badlogic.gdx.graphics.Texture;
 import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 *
 * @author Timur Kashapov aka shako.
 * @since 1.0
 * 03-Sep-17
 */
public class GameApp extends Game{

    /** */
    private SpriteBatch batch;

    /** */
    private Texture
            mouseTexture,
            floorTexture,
            cheeseTexture,
            winMessage;

    /** */
    private float
            mouseX,
            mouseY;

    /** */
    private boolean win;

    /** */
    GameApp() {

        // TO-DO

    } // GameApp()


    @Override
    public void create() {

        //
        //
        batch = new SpriteBatch();
        win = false;

        mouseTexture = new Texture(Gdx.files.internal("assets/mouse.png"));
        cheeseTexture = new Texture(Gdx.files.internal("assets/cheese01.png"));
        floorTexture = new Texture(Gdx.files.internal("assets/floor.png"));
        winMessage   = new Texture(Gdx.files.internal());

        mouseX       = 20;
        mouseY       = 20;

    } // create()


    @Override
    public void render() {
        super.render();


        //
        //
        batch.begin();


        batch.end();



    } // render()
} // GameApp




















































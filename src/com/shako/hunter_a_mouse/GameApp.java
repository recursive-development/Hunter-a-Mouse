package com.shako.hunter_a_mouse;

 import com.badlogic.gdx.Game;
 import com.badlogic.gdx.Gdx;
 import com.badlogic.gdx.Input;
 import com.badlogic.gdx.graphics.GL20;
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
            mouseY,
            cheeseX,
            cheeseY;

    /** */
    private boolean win;

    /** */
    GameApp() {

        // TO-DO

    } // GameApp()

    /** */
    @Override
    public void create() {

        //
        //
        batch = new SpriteBatch();

        //
        //
        mouseTexture  = new Texture(Gdx.files.internal("assets/mouse.png"));
        cheeseTexture = new Texture(Gdx.files.internal("assets/cheese01.png"));
        floorTexture  = new Texture(Gdx.files.internal("assets/floor.png"));
        winMessage    = new Texture(Gdx.files.internal("assets/winner.png"));

        //
        //
        mouseX        = 20;
        mouseY        = 20;
        cheeseX       = 400;
        cheeseY       = 300;

        //
        //
        win           = false;


    } // create()

    @Override
    public void render() {
        super.render();

        // Перемещение героя игры.
        //
        if (Gdx.input.isKeyPressed(Input.Keys.UP))    mouseY++;
        if (Gdx.input.isKeyPressed(Input.Keys.DOWN))  mouseY--;
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) mouseX++;
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT))  mouseX--;

        // Непонятное условие ...
        //
        if (mouseX > cheeseX && ( mouseY > cheeseY )
                && ( mouseX + mouseTexture.getWidth()  < cheeseX + cheeseTexture.getWidth() )
                && ( mouseY + mouseTexture.getHeight() < cheeseY + cheeseTexture.getHeight() ))
        {
            win = true;
            System.out.println("Win");
        }


        // Очиста экрана сплошным цветом и рисование графики при каждой отрисовке.
        //
        Gdx.gl.glClearColor(0.8f, 0.8f, 1.0f, 1.0f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        // Начало отрисовки упоковщика спрайтов.
        //
        //-------------------------------------------
        batch.begin();
        batch.draw(floorTexture,0, 0);
        batch.draw(cheeseTexture, cheeseX, cheeseY, 100, 100);
        batch.draw(mouseTexture,   mouseX,  mouseY, 100, 100);

        if (win) batch.draw(winMessage, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

        batch.end();
        // ------------------------------------------



    } // render()
} // GameApp




















































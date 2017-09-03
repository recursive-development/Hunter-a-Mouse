package com.shako.hunter_a_mouse;

 import com.badlogic.gdx.Game;
 import com.badlogic.gdx.Gdx;
 import com.badlogic.gdx.Input;
 import com.badlogic.gdx.graphics.GL20;
 import com.badlogic.gdx.graphics.Texture;
 import com.badlogic.gdx.graphics.g2d.Sprite;
 import com.badlogic.gdx.graphics.g2d.SpriteBatch;

 // --- shako ---
 import com.shako.jcli.ANSI;

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

            testTexture,

            mouseTexture,
            floorTexture,
            cheeseTexture,
            winMessage;

    /** */
    private Sprite

            testSprite,

            mouseSprite,
            cheeseSprite;

    /** */
    private boolean win;


    // Первичная конфигурация игрового приложения.
    //
    static {

        // Отмена изменения размеров окна экрана игрового приложения.
        //
        Gdx.graphics.setResizable(false);

    }

    /** */
    GameApp() {


    } // GameApp()

    /** */
    @Override
    public void create() {


        batch = new SpriteBatch();

        winMessage    = new Texture(Gdx.files.internal("assets/winner.png"));
    } // create()

    @Override
    public void render() {
        super.render();

        // Перемещение героя игры.
        //
        //moveMouse();

        // Тестирование перемещения посредством тестовой текстуры.
        //
        //moveTestTexture();

        // Вывод статистики в консоль.
        //
        // showStatistics();

        // Проверяем столкновения.
        //
//        if ( detectCollusions() ) {
//            Gdx.app.log("Collisions", ANSI.GREEN + "DETECT");
//            win = true;
//        } else {
//            Gdx.app.log("Collisions", ANSI.WHITE + "DETECT");
//            win = false;
//        }

        Gdx.app.log("Collisions", ANSI.GREEN + "DETECT");


        // Очиста экрана сплошным цветом и рисование графики при каждой отрисовке.
        //
        Gdx.gl.glClearColor(0.8f, 0.8f, 1.0f, 1.0f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        // Начало отрисовки упоковщика спрайтов.
        //
        //-------------------------------------------------------------------------------
        batch.begin();
        batch.draw(floorTexture,0, 0);
        //batch.draw(cheeseTexture, cheeseX, cheeseY, 100, 100);
        //batch.draw(mouseTexture,   mouseX,  mouseY, 100, 100);
        //batch.draw(testTexture, testX, testY);

        if (win) batch.draw(winMessage, 640 / 3 , winMessage.getWidth() / 5 );

        batch.end();
        //-------------------------------------------------------------------------------



    } // render()

    /**
     * Пермещение мышки.
     *
     */
    private void moveMouse() {

        //
        //
        if (Gdx.input.isKeyPressed(Input.Keys.UP))    mouseY += 5.0f;
        if (Gdx.input.isKeyPressed(Input.Keys.DOWN))  mouseY -= 5.0f;
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) mouseX += 5.0f;
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT))  mouseX -= 5.0f;

        if( mouseX <= 0 ) mouseX = 0;
        //if( mouseX >= ...  - mouseTexture.getWidth() ) mouseX = ... - mouseTexture.getWidth();

        if ( mouseY  <= 0 ) mouseY = 0; // mouseTexture.getHeight()
        //if ( mouseY >= ... - mouseTexture.getHeight() ) mouseY = mouseTexture.getHeight();

        // Проверка столкновения с текстурой "сыр"
        //
        if ( detectCollusions() ) {

            win = true;
            System.out.println("Win");
        }

    } // moveMouse()

    /**
     * Тестовое перемещение тестовой тектуры.
     *
     */
    private void moveTestTexture() {

        // Увеличение / уменьшение скорости перемещения и
        // ограничение на изменение скорости.
        //
        if ( Gdx.input.isKeyPressed( Input.Keys.MINUS ) ) testVelosity--;
        if (  testVelosity <= 0 ) testVelosity = 0.5f;

        if ( Gdx.input.isKeyPressed( Input.Keys.PLUS  ) ) testVelosity++;
        if ( testVelosity >= 100.0f ) testVelosity = 100.0f;

        // Перемещение по игровой области.
        //
        if (Gdx.input.isKeyPressed(Input.Keys.UP))    testY += testVelosity;
        if (Gdx.input.isKeyPressed(Input.Keys.DOWN))  testY -= testVelosity;
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) testX += testVelosity;
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT))  testX -= testVelosity;

        if( testX <= 0 ) testX = 0;
        if( testX >= 640 - testTexture.getWidth() ) testX = 640 - testTexture.getWidth();

        if ( testY  <= 0 ) testY = 0; // mouseTexture.getHeight()
        if ( testY >= 480 - testTexture.getHeight() ) testY = 480 - testTexture.getHeight();

        // Столкновение с текстурой сыра
        //
        // if (mouseX >= cheeseX && ( mouseX + mouseTexture.getWidth()  < cheeseX + cheeseTexture.getWidth() )
        //         && ( mouseY >= cheeseY ) && ( mouseY + mouseTexture.getHeight() < cheeseY + cheeseTexture.getHeight() ))
        // {
        //     win = true;
        //     System.out.println("Win");
        // }
    }

    /**
     * Проверка столкновений.
     *
     */
    private boolean detectCollusions() {

        return testX >= cheeseX
                && (testX + testTexture.getWidth() <= cheeseX + cheeseTexture.getWidth() * 2)
                && (testY >= cheeseY)
                && (testY + testTexture.getHeight() <= cheeseY + cheeseTexture.getHeight() * 2);
    } // detectCollusions()

    /** */
    private void showStatistics() {

        System.out.printf("test [%.1f][%.1f]:[%.1f]\n", testX, testY, testVelosity);

    } // showStatistics()
} // GameApp




















































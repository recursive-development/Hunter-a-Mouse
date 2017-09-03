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
    private Texture winMessage;

    /** */
    private Sprite
            testSprite,
            mouseSprite,
            cheeseSprite,
            floorSprite;

    /** */
    private boolean win;

    // Первичная конфигурация игрового приложения.
    //
    static {

        // Отмена изменения размеров окна экрана игрового приложения.
        //
        Gdx.graphics.setResizable(false);

    }

    /**
     * Инициализация игрового приложения.
     *
     */
    GameApp() {


    } // GameApp()

    /**
     * Инициализация игрового простанстава
     *
     */
    @Override
    public void create() {

        batch = new SpriteBatch();

        winMessage   = new Texture(Gdx.files.internal("assets/winner.png"));

        testSprite   = new TestSprite();

        mouseSprite  = new Mouse();
        cheeseSprite = new Cheese();
        floorSprite  = new FloorSprite();

    } // create()

    @Override
    public void render() {

        // super.render();

        // Перемещение героя игры.
        //
        //moveMouse();

        // Тестирование перемещения посредством тестового спрайта.
        //
        moveTestSprite();

        // Вывод статистики в консоль.
        //
        showStatistics();

        // Проверяем столкновения.
        //
        if ( detectCollisions() ) {
            Gdx.app.log("Collisions", ANSI.GREEN + "DETECT");
            win = true;
        } else {
            Gdx.app.log("Collisions", ANSI.WHITE + "DETECT");
            win = false;
        }


        // Очиста экрана сплошным цветом и рисование графики при каждой отрисовке.
        //
        Gdx.gl.glClearColor(0.8f, 0.8f, 1.0f, 1.0f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        // Начало отрисовки упоковщика спрайтов.
        //
        //-------------------------------------------------------------------------------
        batch.begin();

        batch.draw(floorSprite.getTexture(),0, 0);
        batch.draw(cheeseSprite.getTexture(), cheeseSprite.getX(), cheeseSprite.getY(), 100, 100);
        batch.draw(mouseSprite.getTexture(), mouseSprite.getX(), mouseSprite.getY(), 100, 100);
        batch.draw(testSprite.getTexture(), testSprite.getX(), testSprite.getY());

        if (win) batch.draw(winMessage, 640 / 3 , winMessage.getWidth() / 5 );

        batch.end();
        //-------------------------------------------------------------------------------
    } // render()

    /**
     * Пермещение главного героя - мышонка Моисея.
     *
     */
    private void moveMouse() {

        // Перемещение главного героя.
        //
        if (Gdx.input.isKeyPressed(Input.Keys.UP))    mouseSprite.setY(mouseSprite.getY() + mouseSprite.getV());
        if (Gdx.input.isKeyPressed(Input.Keys.DOWN))  mouseSprite.setY(mouseSprite.getY() - mouseSprite.getV());
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) mouseSprite.setX(mouseSprite.getX() + mouseSprite.getV());
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT))  mouseSprite.setX(mouseSprite.getX() - mouseSprite.getV());

        // Ограничение выхода за пределы игрового поля.
        //
        if ( mouseSprite.getX() <= 0 ) mouseSprite.setX(0.0f);
        if ( mouseSprite.getX() >= 640 - mouseSprite.getWidth() ) mouseSprite.setX( 640 - mouseSprite.getWidth() );
        if ( mouseSprite.getY() <= 0 ) mouseSprite.setY(0.0f);
        if ( mouseSprite.getY() >= 480 - mouseSprite.getHeight() ) mouseSprite.setY( 480 - mouseSprite.getHeight() );

        // Проверка столкновения с текстурой "сыр"
        //
        if ( detectCollisions() ) {

            win = true;
            System.out.println("Win");
        }

    } // moveMouse()

    /**
     * Тестирование перемещения тестового спрайта.
     *
     */
    private void moveTestSprite() {

        // Увеличение / уменьшение скорости перемещения и
        // ограничение на изменение скорости.
        //
        if ( Gdx.input.isKeyPressed( Input.Keys.MINUS ) ) testSprite.setV(testSprite.getV() - 1);
        if (  testSprite.getV() <= 0 ) testSprite.setV(0.5f);

        if ( Gdx.input.isKeyPressed( Input.Keys.PLUS  ) ) testSprite.setV(testSprite.getV() + 1);
        if ( testSprite.getV() >= 100.0f ) testSprite.setV(100.0f);

        // Перемещение тестового спрайта по игровой области.
        //
        if (Gdx.input.isKeyPressed(Input.Keys.UP))    testSprite.setY(testSprite.getY() + testSprite.getV());
        if (Gdx.input.isKeyPressed(Input.Keys.DOWN))  testSprite.setY(testSprite.getY() - testSprite.getV());
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) testSprite.setX(testSprite.getX() + testSprite.getV());
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT))  testSprite.setX(testSprite.getX() - testSprite.getV());

        // Ограничение перемещения тестового спрайта размерами экрана (игровой области).
        //
        if( testSprite.getX() <= 0 ) testSprite.setX(0.0f);
        if( testSprite.getX() >= 640 - testSprite.getWidth() ) testSprite.setX(640 - testSprite.getWidth());

        if ( testSprite.getY() <= 0 ) testSprite.setY(0.0f);
        if ( testSprite.getY() >= 480 - testSprite.getHeight() ) testSprite.setX(480 - testSprite.getHeight());
    } // moveTestSprite()

    /**
     * Проверка столкновений.
     *
     * тестовы спрайт + сыр ...
     *
     */
    private boolean detectCollisions() {

        return testSprite.getX() >= cheeseSprite.getX()
                && (testSprite.getX() + testSprite.getWidth() <= cheeseSprite.getX() + cheeseSprite.getWidth() * 2)
                && (testSprite.getY() >= cheeseSprite.getY())
                && (testSprite.getY() + testSprite.getHeight() <= cheeseSprite.getY() + cheeseSprite.getHeight() * 2);
    } // detectCollisions()

    /**
     * Вывод статистики в системную консоль.
     *
     */
    private void showStatistics() {
        System.out.printf(
                ANSI.BACKGROUND_BLUE + "test [%.1f][%.1f]:[%.1f]\n",
                testSprite.getX(),
                testSprite.getY(),
                testSprite.getV());
    } // showStatistics()
} // GameApp




















































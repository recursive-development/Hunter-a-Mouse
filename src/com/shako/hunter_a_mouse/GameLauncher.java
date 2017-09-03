package com.shako.hunter_a_mouse;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;

/**
 * Класс запуска игрового приложения.
 *
 * @author Timur Kashapov aka shako.
 * @since 1.0
 * 03-Sep-17
 */
public class GameLauncher {

    /** */
    public static void main(String[] args) {

        GameApp game =  new GameApp();
        LwjglApplication launcher = new LwjglApplication(game);

    } // main()

} // GameLauncher

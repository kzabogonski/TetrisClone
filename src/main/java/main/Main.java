package main;

import enums.ShiftDirection;
import graphics.GraphicsModule;
import graphics.lwjhlmodule.LwjglGraphicsModule;
import keyboard.KeyboardHandleModule;
import keyboard.lwjglmodule.LwjglKeyboardHandleModule;

import java.io.File;

import static constant.Constants.*;

public class Main {

    private static boolean endOfGame;
    private static GraphicsModule graphicsModule;
    private static KeyboardHandleModule keyBoardModule;
    private static GameField gameField;
    private static ShiftDirection shiftDirection;
    private static boolean isRotateRequested;
    private static boolean isBoostRequested;

    /** Номер игровой итерации по модулю FRAMES_PER_MOVE.
     * Падение фигуры вних происходит если loopNumber % FRAMES_PER_MOVE == 0
     * Т.е. 1 раз ха FRAMES_PER_MOVE итераций.
    */
    private static int loopNumber;

    public static void main(String[] args) {
        System.setProperty("org.lwjgl.librarypath", new File("lib/native").getAbsolutePath());
        initFields();

        while(!endOfGame){
            input();
            logic();

            graphicsModule.draw(gameField);
            graphicsModule.sync(FPS);
        }

        graphicsModule.destroy();
    }

    private static void initFields(){
        loopNumber = 0;
        endOfGame = false;
        shiftDirection = ShiftDirection.AWAITING;
        isRotateRequested = false;
        graphicsModule = new LwjglGraphicsModule();
        keyBoardModule = new LwjglKeyboardHandleModule();
        gameField = new GameField();
    }

    public static void input(){

        //Обновляем данные модуля входа
        keyBoardModule.update();

        // Считываем из модуля ввода направление для сдвига падающей фигурки
        shiftDirection = keyBoardModule.getShiftDirection();

        // Считываем из модуля ввода, хочет ли пользователь повернуть фигурку
        isRotateRequested = keyBoardModule.wasRotateRequested();

        // Считаем из модуля ввода, хочет ли пользователь "уронить" фигурку вниз
        isBoostRequested = keyBoardModule.wasBoostRequested();

        endOfGame = endOfGame || keyBoardModule.wasEscPressed() || graphicsModule.isCloseRequested();
    }

    public static void logic(){
        if (shiftDirection != ShiftDirection.AWAITING){ //Есть ли запрос на сдвиг

            // Пробоем сдвинуть
            gameField.tryShiftFigure(shiftDirection);
            // Ожидаем нового запроса
            shiftDirection = ShiftDirection.AWAITING;
        }

        if(isRotateRequested){// Если есть запрос на поворот фигуры
            // Пробуем повернуть
            gameField.tryRotateFigure();
            // Ожидаем нового запроса
            isRotateRequested = false;
        }

        /*
         * Падение фигуры вних происходит если loopNumber % FRAMES_PER_MOVE == 0
         * Т.е. 1 рах ха FRAMES_PER_MOVE итераций
         * */
        if ((loopNumber % (FRAMES_PER_MOVE / (isBoostRequested ? BOOST_MULTIPLIER : 1))) == 0) gameField.leftFallDown();

        //Увеличение номера итерации (по модулю FPM)
        loopNumber = (loopNumber+1) % (FRAMES_PER_MOVE);
        endOfGame = endOfGame || gameField.isOverfilled();
    }
}

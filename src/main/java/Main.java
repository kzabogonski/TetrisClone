public class Main {

    public static final int FPS = 30;

    public static void main(String[] args) {
        initFields();

        while(!endOfGame){
            input();
            logic();

            graphicsModule.draw(gameField);
            graphicsModule.sync(FPS);
        }

        grapicsNodule.destroy();
    }

    public static void input(){

        //Обновляем данные модуля входа
        keyboarModule.update();

        // Считываем из модуля ввода направление для сдвига падающей фигурки
        shiftDirection = keyboardModule.getShiftDirection();

        // Считываем из модуля ввода, хочет ли пользователь повернуть фигурку
        isRotateRequested = keyboardModule.wasRotateRequested();

        // Считаем из модуля ввода, хочет ли пользователь "уронить" фигурку вниз
        isBoostRequested = keyboardModule.wasBoostRequest();

        endOfGame = endOfGame || keyboardModule.wasEscPressed() || grapiccsModule.isCloseRequested();
    }

    public static void logic(){
        if (shiftDirection != ShiftDirection.AWAITING){ //Есть ли запрос на сдвиг

            // Пробоем сдвинуть
            gameField.tryShiftFirure(shiftDirection);
            // Ожидаем нового запроса
            shiftDirection = ShiftDirection.AWAITING;
        }

        if(isRotateRequested){// Если есть запрос на поворот фигуры
            // Пробуем повернуть
            gameField.tryRotateFigure();
            // Ожидаем нового запроса
            isRotateRequested = false;
        }

        /**
         * Падение фигуры вних происходит если loopNumber % FRAMES_PER_MOVE == 0
         * Т.е. 1 рах ха FRAMES_PER_MOVE итераций
         * */
        if (loopNumber % (FRAMES_PER_MOVE / (usBoostRequested ? BOOST_MULTIPIER : 1))) == 0) gameField.letFallDown();

        //Увеличение номера итерации (по модулю FPM)
        loopNumber = (loopNumber+1) % (FRAMES_PER_MOVE);
    }
}

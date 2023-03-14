package grapics;

import main.GameField;

public interface GraphicsModule {
    /**
     * Отрисовывает переданное игровое поле
     * @param field Игровое поле, котороое необходимо отрисовать
    */
    void draw(GameField field);
    /**
     * @return Возращает true, если в окне нажат "крестик
     * */
    boolean isCloseRequested();
    /**
     *  Заключительные действия, на случай, если модулю нужно подчистить за собой
     * */
    void destroy();
    /**
     * Заставляет программу немного поспать, если последний раз метод вызывался
     * менее чем 1/fps секунд назад
     * */
    void sync(int fps);
}

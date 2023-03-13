package constant;

import enums.ReadableColor;

public class Constants {

    //Размер одной плитки
    public static final int CELL_SIZE = 24;

    // Количество ячеек по горизонтали и вертикали
    public static final int COUNT_CELLS_X = 30;
    public static final int COUNT_CELLS_Y = 2 * COUNT_CELLS_X;

    //Невидимое пространство с верху,  в котором создаются фигуры
    public static final int OFFSET_TOP = 3;

    //Параметры окна
    public static final int SCREEN_WIDTH = COUNT_CELLS_X * CELL_SIZE;
    public static final int SCREEN_HEIGHT = COUNT_CELLS_Y * CELL_SIZE;
    public static final String SCREEN_NAME = "TETRIS";

    //Количество раз, в котороу увеличивается скорость падения, если пользователь нажал соответствующую клавушу
    public static final int BOOST_MULTIPLIER = 5;

    //Количество клеток. на которое в секунду смещается вниз фугура
    public static final int MOVE_DOWNS_PER_SECONDS = 3;

    //Количество игровых циклов в секунду
    public static final int FPS = 60;

    // Количество игровых циклов, за которое фигура сместиться вниз на одну клетку
    public static final int FRAMES_PER_MOVE = FPS / MOVE_DOWNS_PER_SECONDS;

    //Цвет, в котором поле обозначается пустота
    public static final ReadableColor EMPTINESS_COLOR = ReadableColor.BLACK;

    //Колличество линий, заполненых блоками в начале
    public static final int BLOCKS_INITIAL_LEVEL = COUNT_CELLS_Y / 3;

    // Максимальное и минимальное колличество блоков в линиях, созданных в начале игры
    public static final int MISSING_BLOCKS_IN_INITIAL_LINE_MIN = COUNT_CELLS_X / 3;
    public static final int MISSING_BLOCKS_IN_INITIAL_LINE_MAX = COUNT_CELLS_X / 2;

    //Максимальное возможная ширина фигуры
    public static final int MAX_FIGURE_WIDTH = 4;

}

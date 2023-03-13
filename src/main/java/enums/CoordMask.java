package enums;

import exception.ErrorCatcher;
import main.Coord;

/**
 * Каждая маска -- шаблон, который по мнимой координате фигуры и
 * состоянию её поворота возразает 4 координаты реальных блоков
 * фигуры, которые должны отображаться.
 * Т.е. маска задаёт геометрическую форму фигуры.
 */
public enum CoordMask {

    // Кирпичик [][][][]
    I_FORM(
            new GenerationDelegate() {
                @Override
                public Coord[] generationFigure(Coord initialCoord, RotationMode rotation) {
                    Coord[] ret = new Coord[4];

                    switch (rotation){
                        case NORMAL:
                        case INVERT:
                            ret[0] = initialCoord;
                            ret[1] = new Coord(initialCoord.x, initialCoord.y - 1);
                            ret[2] = new Coord(initialCoord.x, initialCoord.y - 2);
                            ret[3] = new Coord(initialCoord.x, initialCoord.y - 3);
                            break;
                        case FLIP_CCW:
                        case FLIP_CW:
                            ret[0] = initialCoord;
                            ret[1] = new Coord(initialCoord.x + 1, initialCoord.y);
                            ret[2] = new Coord(initialCoord.x + 2, initialCoord.y);
                            ret[3] = new Coord(initialCoord.x + 3, initialCoord.y);
                            break;
                        default:
                            ErrorCatcher.wrongParametr("rotation", "CoordMask");
                    }
                    return ret;
                }
            }
    ),

    /* Кирпичик []
                [][][]
     */
    J_FORM(new GenerationDelegate(){
        @Override
        public Coord[] generationFigure(Coord initialCoord, RotationMode rotation) {
            Coord[] ret = new Coord[4];

            switch (rotation){
                case NORMAL:
                    ret[0] = new Coord(initialCoord.x + 1,initialCoord.y);
                    ret[1] = new Coord(initialCoord.x +1 , initialCoord.y - 1);
                    ret[2] = new Coord(initialCoord.x + 1, initialCoord.y - 2);
                    ret[3] = new Coord(initialCoord.x, initialCoord.y - 2);
                    break;
                case INVERT:
                    ret[0] = new Coord(initialCoord.x + 1,initialCoord.y);
                    ret[1] = initialCoord;
                    ret[2] = new Coord(initialCoord.x, initialCoord.y - 1);
                    ret[3] = new Coord(initialCoord.x, initialCoord.y - 2);
                    break;
                case FLIP_CCW:
                    ret[0] = initialCoord;
                    ret[1] = new Coord(initialCoord.x + 1, initialCoord.y);
                    ret[2] = new Coord(initialCoord.x + 2, initialCoord.y);
                    ret[3] = new Coord(initialCoord.x + 2, initialCoord.y - 1);
                    break;
                case FLIP_CW:
                    ret[0] = initialCoord;
                    ret[1] = new Coord(initialCoord.x, initialCoord.y - 1);
                    ret[2] = new Coord(initialCoord.x + 1, initialCoord.y - 1);
                    ret[3] = new Coord(initialCoord.x + 2, initialCoord.y - 1);
                    break;
            }
                return ret;
        }
    }),

    /**
     * Кирпичик []
     *      [][][]
     */
    L_FORM(
            new GenerationDelegate() {

                @Override
                public Coord[] generationFigure(Coord initialCoord, RotationMode rotation) {
                    Coord[] ret = new Coord[4];

                    switch (rotation){
                        case NORMAL:
                            ret[0] = initialCoord;
                            ret[1] = new Coord(initialCoord.x, initialCoord.y - 1);
                            ret[2] = new Coord(initialCoord.x, initialCoord.y - 2);
                            ret[3] = new Coord(initialCoord.x + 1, initialCoord.y - 2);
                            break;
                        case INVERT:
                            ret[0] = initialCoord;
                            ret[1] = new Coord(initialCoord.x + 1, initialCoord.y);
                            ret[2] = new Coord(initialCoord.x + 1, initialCoord.y - 1);
                            ret[3] = new Coord(initialCoord.x + 1, initialCoord.y - 2);
                            break;
                        case FLIP_CCW:
                            ret[0] = new Coord(initialCoord.x, initialCoord.y - 1);
                            ret[1] = new Coord(initialCoord.x + 1, initialCoord.y - 1);
                            ret[2] = new Coord(initialCoord.x + 2, initialCoord.y - 1);
                            ret[3] = new Coord(initialCoord.x + 2, initialCoord.y);
                            break;
                        case FLIP_CW:
                            ret[0] = new Coord(initialCoord.x, initialCoord.y - 1);
                            ret[1] = initialCoord;
                            ret[2] = new Coord(initialCoord.x + 1, initialCoord.y);
                            ret[3] = new Coord(initialCoord.x + 2, initialCoord.y);
                            break;
                        default:
                            ErrorCatcher.wrongParametr("rotation", "CoordMask");
                    }

                    return ret;
                }
            }
    ),

    /** Кирпичик [][]
     *           [][]
     */
    O_FORM(
            new GenerationDelegate() {
                @Override
                public Coord[] generationFigure(Coord initialCoord, RotationMode rotation) {
                    Coord[] ret = new Coord[4];

                    ret[0] = initialCoord;
                    ret[1] = new Coord(initialCoord.x, initialCoord.y - 1);
                    ret[2] = new Coord(initialCoord.x + 1, initialCoord.y - 1);
                    ret[3] = new Coord(initialCoord.x + 1, initialCoord.y);

                    return ret;
                }
            }
    ),

    /** Кирпичик    [][]
     *            [][]
     */
    S_FORM(
            new GenerationDelegate() {
                @Override
                public Coord[] generationFigure(Coord initialCoord, RotationMode rotation) {
                    Coord[] ret = new Coord[4];

                    switch (rotation){
                        case NORMAL:
                        case INVERT:
                            ret[0] = new Coord(initialCoord.x, initialCoord.y - 1);
                            ret[1] = new Coord(initialCoord.x + 1, initialCoord.y - 1);
                            ret[2] = new Coord(initialCoord.x + 1, initialCoord.y);
                            ret[3] = new Coord(initialCoord.x + 2, initialCoord.y);
                            break;
                        case FLIP_CCW:
                        case FLIP_CW:
                            ret[0] = initialCoord;
                            ret[1] = new Coord(initialCoord.x, initialCoord.y - 1);
                            ret[2] = new Coord(initialCoord.x + 1, initialCoord.y - 1);
                            ret[3] = new Coord(initialCoord.x + 1, initialCoord.y - 2);
                            break;
                        default:
                            ErrorCatcher.wrongParametr("rotation", "CoordMask");
                    }
                    return ret;
                }
            }
    ),

    /** Кирпичик [][]
     *             [][]
     */
    Z_FORM(
            new GenerationDelegate() {
                @Override
                public Coord[] generationFigure(Coord initialCoord, RotationMode rotation) {
                    Coord[] ret = new Coord[4];

                    switch (rotation){
                        case NORMAL:
                        case INVERT:
                            ret[0] = initialCoord;
                            ret[1] = new Coord(initialCoord.x + 1, initialCoord.y);
                            ret[2] = new Coord(initialCoord.x + 1, initialCoord.y - 1);
                            ret[3] = new Coord(initialCoord.x + 2, initialCoord.y - 1);
                            break;
                        case FLIP_CCW:
                        case FLIP_CW:
                            ret[0] = new Coord(initialCoord.x + 1, initialCoord.y);
                            ret[1] = new Coord(initialCoord.x + 1, initialCoord.y - 1);
                            ret[2] = new Coord(initialCoord.x, initialCoord.y - 1);
                            ret[3] = new Coord(initialCoord.x, initialCoord.y - 2);
                            break;
                        default:
                            ErrorCatcher.wrongParametr("rotation", "CoordMask");
                    }
                    return ret;
                }
            }
    ),

    /** Кирпичик [][][]
     *             []
     */
    T_FORM(
            new GenerationDelegate() {
                @Override
                public Coord[] generationFigure(Coord initialCoord, RotationMode rotation) {
                    Coord[] ret = new Coord[4];

                    switch (rotation){
                        case NORMAL:
                            ret[0] = initialCoord;
                            ret[1] = new Coord(initialCoord.x + 1, initialCoord.y);
                            ret[2] = new Coord(initialCoord.x + 1, initialCoord.y - 1);
                            ret[3] = new Coord(initialCoord.x + 2, initialCoord.y);
                            break;
                        case INVERT:
                            ret[0] = new Coord(initialCoord.x, initialCoord.y - 1);
                            ret[1] = new Coord(initialCoord.x + 1, initialCoord.y - 1);
                            ret[2] = new Coord(initialCoord.x + 1, initialCoord.y);
                            ret[3] = new Coord(initialCoord.x + 2, initialCoord.y - 1);
                            break;
                        case FLIP_CCW:
                            ret[0] = initialCoord;
                            ret[1] = new Coord(initialCoord.x, initialCoord.y - 1);
                            ret[2] = new Coord(initialCoord.x + 1, initialCoord.y - 1);
                            ret[3] = new Coord(initialCoord.x, initialCoord.y - 2);
                            break;
                        case FLIP_CW:
                            ret[0] = new Coord(initialCoord.x + 1, initialCoord.y);
                            ret[1] = new Coord(initialCoord.x + 1, initialCoord.y - 1);
                            ret[2] = new Coord(initialCoord.x, initialCoord.y - 1);
                            ret[3] = new Coord(initialCoord.x + 1, initialCoord.y - 2);
                            break;
                        default:
                            ErrorCatcher.wrongParametr("rotation", "CoordMask");
                    }
                    return ret;
                }
            }
    );

    /**
     * Делегат с методом, который должен определять алгоритм для generateFigure().
     * Спецефичен для каждого объекта enum`a
     */
    private GenerationDelegate forms;

    /**
     * Делегат, содержащий метод,
     * который должен определять алгоритм для generationFigure()
     */
    private interface GenerationDelegate{
        /**
         * По мнимой координате фигуры и состоянию её поворота
         * возвращает 4 координаты реальных блоков фигуры, которые должны отображаться
         *
         * @param initialCoord Мнимая координата
         * @param rotation Состояние поворота
         * @return 4 реальных координаты
         */
        Coord[] generationFigure(Coord initialCoord, RotationMode rotation);
    }

    /**
     * Конструктор
     * @param forms Делегат с методом, который должен определять алгоритм для generateFigure()
     */
    CoordMask(GenerationDelegate forms){
        this.forms = forms;
    }

    /**
     * По мнимой координате фигуры и состоянию её поворота
     * возвращается 4 координаты реальных блоков фигуры, которые должны отображаться.
     *
     * Запрос передается делегату, спецефичному для каждого объекта enum`a
     *
     * @param initialCoord Мнимая координата
     * @param rotation состояние поворота
     * @return 4 реальные координаты
     */
    public Coord[] generateFigure(Coord initialCoord, RotationMode rotation){
        return this.forms.generationFigure(initialCoord, rotation);
    }

}

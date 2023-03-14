package main;

import enums.FigureForm;
import enums.KzReadableColor;
import enums.RotationMode;
import enums.ShiftDirection;
import exception.ErrorCatcher;

public class Figure {

    //Текущее состояния повроота фигуры
    private Coord metaPointCoords;

    //Текущее состояние поворота фигуры
    private RotationMode currentRotation;

    //Форма фигуры
    private FigureForm form;

    /**
     * Конструктор
     * Состояние поворота по умолчанию: RotationMode.NORMAL
     * Форма задаётся случайная
     * @param metaPointCoords Мнимая координата фигуры
     */
    public Figure(Coord metaPointCoords){
        this(metaPointCoords, RotationMode.NORMAL, FigureForm.getRandomForm());
    }

    /**
     * @param metaPointCoords мнимая координата фигуры
     * @param rotation состояние поворота
     * @param form форма фигуры
     */
    public Figure(Coord metaPointCoords, RotationMode rotation, FigureForm form){
        this.metaPointCoords = metaPointCoords;
        this.currentRotation = rotation;
        this.form = form;
    }

    /**
     * @return Координаты реальных ячеек фигуры в текущем состоянии
     */
    public Coord[] getCoords(){
        return form.getMask().generateFigure(metaPointCoords, currentRotation);
    }

    /**
     * @return Координаты ячеек фигуры, как если бы
     * она была перевёрнута против часовой стреклуи от текущего положения
     */
    public Coord[] getRotatedCoords(){
        return form.getMask().generateFigure(metaPointCoords, RotationMode.getNextRotationForm(currentRotation));
    }

    //Поворачивает фигуры против часовой стрелки
    public void rotate(){
        this.currentRotation = RotationMode.getNextRotationForm(currentRotation);
    }

    /**
     * @param direction Направление сдвига
     * @return Координаты ячеек фигуры, как если бы она была сдвинута в указано направлении
     */
    public Coord[] getShiftedCoords(ShiftDirection direction) {
        Coord newFirstCell = null;
        switch (direction) {
            case LEFT:
                newFirstCell = new Coord(metaPointCoords.x - 1, metaPointCoords.y);
                break;
            case RIGHT:
                newFirstCell = new Coord(metaPointCoords.x + 1, metaPointCoords.y);
                break;
            default:
                ErrorCatcher.wrongParametr("direction (for getShiftedCoords)", "Figure");
        }
        return form.getMask().generateFigure(newFirstCell, currentRotation);
    }

    /**
     * Меняем мнимую Х-координату фигуры
     * для сдвига в указаном направлении
     * @param direction Направление сдвига
     */
    public void shift(ShiftDirection direction){
        switch (direction){
            case LEFT:
                metaPointCoords.x--;
                break;
            case RIGHT:
                metaPointCoords.x++;
                break;
            default:
                ErrorCatcher.wrongParametr("direction (for shift)", "Figure");
        }
    }

    /**
     * @return Координаты ячеек фигуры, как если бы она была сдвинута вниз на обну ячейку
     */
    public Coord[] getFallenCoords(){
        Coord newFirstCell = new Coord(metaPointCoords.x, metaPointCoords.y - 1);
        return form.getMask().generateFigure(newFirstCell, currentRotation);
    }

    /**
     * Меняем мнимую У-координаты фигуры
     * для сдвига на одну ячейку вниз
     */
    public void fall(){
        metaPointCoords.y--;
    }

    /**
     * @return Цвет фигуры
     */
    public KzReadableColor getColor(){
        return form.getColor();
    }
}

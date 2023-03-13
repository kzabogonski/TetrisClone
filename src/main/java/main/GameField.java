package main;


import enums.ReadableColor;

/** Хранит информацию и поле о падающей фигуре.
 * Содержит методы для их обновления, и получения о них и информации.
 *
 * @author Zabogonski
 * @version 1.0
 */
public class GameField {

    //Цвет ячеек поляю Для пустых ячеек используется константа EMPTINESS_COLOR
    private ReadableColor[][] theField;

    // Колличество непустых ячеек строки
    private int[] countFilledCellsInLine;

    //Информация о падающей в данный момент фигуре
    private Figure figure;
}

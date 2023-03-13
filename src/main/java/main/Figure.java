package main;

import enums.FigureForm;
import enums.RotationMode;

public class Figure {

    //Текущее состояния повроота фигуры
    private Coord metaPointCoords;

    //Текущее состояние поворота фигуры
    private RotationMode currentRotation;

    //Форма фигуры
    private FigureForm form;
}

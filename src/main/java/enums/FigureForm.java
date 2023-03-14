package enums;

import java.util.Random;

/**
 * Связывает все формоспецефичные параметры фигуры.
 * Маска, коорпдинаты, цвет
 */
public enum FigureForm {

    I_FORM (CoordMask.I_FORM, KzReadableColor.BLUE),
    J_FORM (CoordMask.J_FORM, KzReadableColor.ORANGE),
    L_FORM (CoordMask.L_FORM, KzReadableColor.YELLOW),
    O_FORM (CoordMask.O_FORM, KzReadableColor.RED),
    S_FORM (CoordMask.S_FORM, KzReadableColor.AQUA),
    Z_FORM (CoordMask.Z_FORM, KzReadableColor.PURPLE),
    T_FORM (CoordMask.T_FORM, KzReadableColor.GREEN);

    //Маска координат (задает геометрическую форму)
    private CoordMask mask;

    //Цвет, характерный для этой формы
    private KzReadableColor color;


    /**
     * Конструктор
     * @param mask маска координат (задает геометрическую форму)
     * @param color цвет, характерный для этой формы
     */
    FigureForm(CoordMask mask, KzReadableColor color){
        this.mask = mask;
        this.color = color;
    }

    //Массив со всеми объектами этого типа enum`a (для удобной реализации getRandomForm())
    private static final FigureForm[] formByNumber = {I_FORM, J_FORM, L_FORM, O_FORM, S_FORM, Z_FORM, T_FORM,};

    /**
     * @return координаты данной формы
     */
    public CoordMask getMask(){
        return this.mask;
    }

    /**
     * @return цвет для данной формы
     */
    public KzReadableColor getColor(){
        return this.color;
    }

    public static FigureForm getRandomForm() {
        int fromNumber = new Random().nextInt(formByNumber.length);
        return formByNumber[fromNumber];
    }

}

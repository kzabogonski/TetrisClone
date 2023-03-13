package enums;

/**
 * Все возможные состояния фигуры после поворотов:
 * не была повёрнута, повёрнута, против часовой стрелки 1 раз, 2 раза, 3 раза.
 * Поворото против часовой стрелки 4 раза соответствует возвращению в начальное положение.
 * Считается что фигура может поворачиваться только против часовой стрелки.
 *
 * @author Zabogonski
 * @version 1.0
 */
public enum RotationMode {

    //Нормальное положение
    NORMAL(0),

    //Положение, соответсвующее повороту против часовой стрелки
    FLIP_CCW(1),

    //Положение, соответствующее зеркальному отражению
    INVERT(2),

    //Положение, соответствующее повороту по часовой стрелки (или трём поворотам против)
    FLIP_CW(3);

    //Количество поворотов против часовой стрелки, необходимое для принятия положения
    private int number;

    /**
     * Конструтор
     * @param number Количество поворотов против часовой стрелки, необходимое для принятия положения
     */
    RotationMode(int number){
        this.number = number;
    }

    /**
     * Хранит объекты enum`а. Индекс в массиве соответствует полю number.
     * Для более удобной работы getNextRotationForm().
     */
    private static RotationMode[] rotationByNumber = {NORMAL, FLIP_CCW, INVERT, FLIP_CW};

    /**
     * Возвращает положение, образованное в результате поворота по часовой стрелке
     * из положения previousRotation
     * @param previousRotation положение из которого был совершён поворот
     * @return положение, образованное в результате поворота
     */
    public static RotationMode getNextRotationForm(RotationMode previousRotation){
        int newRotationIndex = (previousRotation.number + 1) % rotationByNumber.length;
        return rotationByNumber[newRotationIndex];
    }
}

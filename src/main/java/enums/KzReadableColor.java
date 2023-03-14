package enums;

import java.util.Random;

public enum KzReadableColor {
    BLACK,
    RED,
    GREEN,
    BLUE,
    AQUA,
    YELLOW,
    ORANGE,
    PURPLE;

    private static KzReadableColor[] colorByNumber = {BLACK, RED, GREEN, BLUE, AQUA, YELLOW, ORANGE, PURPLE,};

    public static KzReadableColor getRandomColor() {
        int colorNumber = new Random().nextInt(colorByNumber.length);
        return colorByNumber[colorNumber];
    }
}

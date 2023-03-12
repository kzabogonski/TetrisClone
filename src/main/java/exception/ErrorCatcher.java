package exception;

import org.lwjgl.Sys;

public class ErrorCatcher {

    /**
     * Внутрення ошибка графического модуля
     * @param e Выброшеное исключение
    * */
    public static void graphicsFailure(Exception e){
        System.err.println("Graphic module failed :(");
        e.printStackTrace();
        System.exit(-3);
    }
}

package exception;

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

    /**
     * Передан неверный параметр
     *
     * @param eparametr описание неверного параметра
     * @param eclass описание класса, в котором встретилась ошибка
     */
    public static void wrongParametr(String eparametr, String eclass){
        System.err.println("Wrong parameter " + eparametr + " occurred in class " + eclass);
        System.exit(-2);
    }
}

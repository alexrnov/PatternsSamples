package strategy;

/**
 * Класс реализует поведение трехцветного светофора
 */
public class SequenceTricolor implements LightBehavior {
    private int greenLight;
    private int yellowLight;
    private int redLight;

    public SequenceTricolor() {
        this(1000, 150, 1000);//использовать режим свечения по умолчанию
    }

    public SequenceTricolor(int g, int y, int r) {
        greenLight = g;
        yellowLight = y;
        redLight = r;
    }

    /**
     * Выполнять свечение светофора (инкапсулированный алгоритм, который
     * делегируется классу светофора)
     */
    @Override
    public void runShift() {
        System.out.println("sequence shifting for tricolor traffic light: "
                + greenLight + " msec, " + yellowLight
                + " msec, " + redLight + " msec");
    }
}

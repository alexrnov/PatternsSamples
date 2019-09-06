package strategy;

/**
Класс реализует поведение трамвайного светофора
 */
public class SequenceTram implements LightBehavior {

    /**
     * Выполнить свечение светофора (инкапсулированный алгоритм, который
     * делегируется классу светофора)
     */
    @Override
    public void runShift() {
        System.out.println("sequence shifting for tram traffic light");
    }
}

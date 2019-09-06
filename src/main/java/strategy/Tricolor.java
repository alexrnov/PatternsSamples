package strategy;

/**
 * трехцветный светофор
 */
public class Tricolor extends TrafficLight {
    public Tricolor() {
        //режим переключения по умолчанию
        lightBehavior = new SequenceTricolor();
    }
}

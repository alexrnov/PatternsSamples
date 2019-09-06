package strategy;

/**
 * трамвайный светофор
 */
public class Tram extends TrafficLight {
    public Tram() {
        //режим переключения по умолчанию
        lightBehavior = new SequenceTram();
    }
}

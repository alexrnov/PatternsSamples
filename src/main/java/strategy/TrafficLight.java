package strategy;

/**
 * суперкласс - светофор, которому методом композиции делигируется
 * поведение свечения
 */
public class TrafficLight {
    protected LightBehavior lightBehavior;//режим свечения светофора

    public void setLightBehavior(LightBehavior lightBehavior) {
        this.lightBehavior = lightBehavior;
    }

    public void performLight() {
        //запустить свечение светофора в определенном режиме переключения
        lightBehavior.runShift();
    }
}

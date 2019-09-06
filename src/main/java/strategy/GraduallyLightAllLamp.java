package strategy;

/**
 * Класс инкапсулирует поведение, при котором происходит постепенное
 * загорание всех ламп
 */
public class GraduallyLightAllLamp implements LightBehavior{
    public void runShift() {
        //Постепенно загораются все лампы
        System.out.println("gradually light all lamp");
    }
}

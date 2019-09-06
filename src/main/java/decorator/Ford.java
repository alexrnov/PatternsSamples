package decorator;

/**
 * Класс конкретной марки автомобиля
 */
public class Ford extends Automobile {
    public Ford() {
        description = "Ford";
    }

    public double cost() {
        return 700;
    }
}

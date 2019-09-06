package decorator;

/**
 * Абстрактный класс для автомобиля
 */
public abstract class Automobile {
    protected String description = "Unknown";

    public String getDescription() {
        return description;
    }

    public abstract double cost();
}

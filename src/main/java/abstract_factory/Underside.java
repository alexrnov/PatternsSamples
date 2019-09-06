package abstract_factory;

/**
 * Класс нижней одежды
 */
public abstract class Underside extends Garmen {
    public Underside(String description) {
        super(description);
    }
    public String getDescription() {
        return "Underside: " + super.description;
    }
}

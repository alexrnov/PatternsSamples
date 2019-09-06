package abstract_factory;

/**
 * Класс верхней одежы
 */
public abstract class Top extends Garmen {
    public Top(String description) {
        super(description);
    }
    public String getDescription() {
        return "Top: " + super.description;
    }
}

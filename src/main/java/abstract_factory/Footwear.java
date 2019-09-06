package abstract_factory;

/**
 * суперкласс для обуви
 */
public abstract class Footwear extends Garmen {
    public Footwear(String description) {
        super(description);
    }
    public String getDescription() {
        return "Footwear: " + super.description;
    }
}

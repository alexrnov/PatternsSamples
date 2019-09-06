package abstract_factory;

/**
 * Суперкласс для одежды, на его основе создаются: класс верней одежды,
 * класс нижней одежды и класс обуви
 */
public abstract class Garmen {
    protected String description;
    public Garmen(String description) {
        this.description = description;
    }
    abstract public String getDescription();
}

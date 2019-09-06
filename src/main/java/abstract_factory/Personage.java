package abstract_factory;

/**
 * Класс персонажа, для которого подбирается одежда
 */
public class Personage {
    private String name;
    private Top top;
    private Underside underside;
    private Footwear footwear;

    /**
     * Созжает персонажа с именем и одеждой
     * @param name имя персонажа
     * @param garmenFactory реализация абстрактной фабрики, определяющая стиль одежды
     */
    public Personage(String name, GarmenFactory garmenFactory) {
        this.name = name;
        top = garmenFactory.createTop();
        underside = garmenFactory.createUnderside();
        footwear = garmenFactory.createFootwear();
    }

    @Override
    public String toString() {
        return name + "; " + top.getDescription()
                + ", " + underside.getDescription()
                + ", " + footwear.getDescription();
    }
}

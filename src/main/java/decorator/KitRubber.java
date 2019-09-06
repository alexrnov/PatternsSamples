package decorator;

/**
 * Декоратор для добавления комплекта резины в комплектацию
 */
public class KitRubber extends OptionDecorator {
    //декоратор хранит ссылку на декорируемый объект
    private Automobile automobile;

    public KitRubber(Automobile automobile) {
        this.automobile = automobile;
    }

    public String getDescription() {
        return automobile.getDescription() + ", KitRubber";
    }

    public double cost() {
        return 30 + automobile.cost();
    }
}

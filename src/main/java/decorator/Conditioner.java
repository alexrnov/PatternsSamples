package decorator;

/**
 * Декоратор для добавления кондиционера в комплектацию
 */
public class Conditioner extends OptionDecorator {
    //декоратор хранит ссылку на декорируемый объект
    private Automobile automobile;

    public Conditioner(Automobile automobile) {
        this.automobile = automobile;
    }

    public String getDescription() {
        return automobile.getDescription() + ", conditioner";
    }

    public double cost() {
        return 15 + automobile.cost();
    }
}

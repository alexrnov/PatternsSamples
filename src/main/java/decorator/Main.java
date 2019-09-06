package decorator;

/**
 * На примере комплектации автомобиля раскрывается принцип
 * работы паттерна ДЕКОРАТОР. Паттерн ДЕКОРАТОР динамически наделяет объект
 * новыми возможностями и является гибкой альтернативой субклассированию
 * в области расширения функциональности.
 */
public class Main {
    public static void main(String[] args) {
        Automobile ford = new Ford();
        System.out.println(ford.getDescription());
        System.out.println("total sum: " + ford.cost());
        System.out.println("--------------------");
        ford = new Conditioner(ford); //завернуть в декоратор кондиционера
        System.out.println(ford.getDescription());
        System.out.println("total sum: " + ford.cost());
        System.out.println("--------------------");
        ford = new KitRubber(ford);//завернуть в декоратор комплекта резины
        ford = new KitRubber(ford);//завернуть в декоратор комплекта резины
        System.out.println(ford.getDescription());
        System.out.println("total sum: " + ford.cost());
        System.out.println("--------------------");

        Automobile ford2 = new Ford();
        //другая форма записи вызова декораторов
        ford2 = new KitRubber(new KitRubber(new Conditioner(ford2)));
        System.out.println(ford2.getDescription());
        System.out.println("total sum: " + ford2.cost());
    }
}

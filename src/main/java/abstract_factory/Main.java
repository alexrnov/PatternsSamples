package abstract_factory;

/**
 * На примере создания персонажей с определенным стилем одежды
 * демонстрируется принцип работы паттерна АБСТРАКТНАЯ ФАБРИКА.
 * Паттерн АБСТРАКТНАЯ ФАБРИКА предоставляет интерфейс создания
 * семейств взаимосвязанных или взаимозависимых объектов
 * без указания их конкретных классов.
 */
public class Main {
    public static void main(String[] args) {
        ////при создании стиля одежды используется паттерн "абстрактная фабрика"
        GarmenFactory businessStyle = new BusinessStyle();
        GarmenFactory freeStyle = new FreeStyle();
        Personage jhon = new Personage("John", businessStyle);
        Personage jim = new Personage("Jim", businessStyle);
        Personage jacob = new Personage("Jacob", freeStyle);
        Personage johan = new Personage("Johan", freeStyle);
        System.out.println(jhon.toString());
        System.out.println(jim.toString());
        System.out.println(jacob.toString());
        System.out.println(johan.toString());
    }
}

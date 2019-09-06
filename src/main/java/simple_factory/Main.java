package simple_factory;

/**
 * На примере создания воинов разных типов демонстрируется работа паттерна
 * простая фабрика. Строго говоря ПРОСТАЯ ФАБРИКА не является паттерном
 * проектирования; скррее это идиома программирования.ПРОСТАЯ ФАБРИКА
 * обеспечивает простой механизм изоляции клиентов от конкретных классов.
 */
public class Main {
    public static void main(String[] args) {
        Soldier s1 = SoldierFactory.createSoldier("Swordman");
        Soldier s2 = SoldierFactory.createSoldier("Bowman");
        Soldier s3 = SoldierFactory.createSoldier("Spearman");
        s1.walk();
        s2.walk();
        s3.walk();
        s1.run();
        s2.run();
        s3.run();
        s1.stop();
        s2.stop();
        s3.stop();
    }
}

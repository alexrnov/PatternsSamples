package adapter;

/**
 * На примере использования единой абстракции для мобильных телефонов
 * разных поколений (смартфон и кнопочный телефоны) демонстрируется
 * работа паттерна АДАПТЕР. Паттерн АДАПТЕР преобразует интерфейс класса
 * к другому интерфейсу, на который рассчитан клиент.
 * АДАПТЕР обеспечивает совместную работу классов,
 * невозможную в обычных условиях из-за несовместимости интерфейсов.
 */
public class Main {
    public static void main(String[] args) {
        SmartPhone iPhone7 = new IPhone7();//смартфон
        MobilePhone motorola = new Motorola();//кнопочный мобильный телефон
        //объекты имеют разные интерфейсы
        if (!(motorola instanceof SmartPhone)) {
            System.out.println("different interfaces");
        }
        System.out.println("--------------------");
        //для того, чтобы мобильным телефоном можно было оперировать
        //в контексте современных смартфонов, следует использовать
        //специальный адаптер
        MobilePhoneAdapter adaptedMotorola = new MobilePhoneAdapter(motorola);
        if (adaptedMotorola instanceof SmartPhone) {
            System.out.println("one and the same interfaces");
        }
        System.out.println("--------------------");
        System.out.println("Вызываем методы смартфона для iphone7:");
        iPhone7.pressTouchScreen();
        iPhone7.cellUp();
        iPhone7.photograph();
        iPhone7.changeOrientationDisplay();
        System.out.println("--------------------");
        System.out.println("Вызываем методы смартфона для моторолы:");
        adaptedMotorola.pressTouchScreen();
        adaptedMotorola.cellUp();
        adaptedMotorola.photograph();
        adaptedMotorola.changeOrientationDisplay();
    }
}

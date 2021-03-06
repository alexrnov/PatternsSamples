package strategy;

/**
 * На примере изменяемого поведения свечения светофоров приводится
 * пример работы паттерна СТРАТЕГИЯ. Паттерн СТРАТЕГИЯ определяет
 * семейство алгоритмов, инкапсулирует каждый из них и обеспечивает
 * их взаимозаменяемость. Он позволяет модифицировать алгоритмы
 * независимо от их использования на стороне клиента.
 */
public class Main {
    public static void main(String[] args) {
        Tricolor tricolor = new Tricolor();//трехцветный светофор
        //запустить свечение светофора в режиме переключения по умолчанию
        tricolor.performLight();

        //изменить режим переключения цветов
        tricolor.setLightBehavior(new SequenceTricolor(0, 100, 0));
        //запустить свечение светофора в настроенном режиме переключения
        tricolor.performLight();

        //изменить режим на постепенное загорание всех цветов
        tricolor.setLightBehavior(new GraduallyLightAllLamp());
        //запустить свечение светофора в настроенном режиме переключения
        tricolor.performLight();

        System.out.println("--------------------------------");
        Tram tram = new Tram();//трамвайный светофор
        //запустить свечение светофора в режиме переключения по умолчанию
        tram.performLight();
    }
}

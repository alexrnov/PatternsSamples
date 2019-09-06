package tempate_method;

/**
 * На примере двух алгоритмов, определяющих порядок действий
 * при различных стрижках, демонстрируется паттерн ШАБЛОННЫЙ МЕТОД
 * Паттерн ШАБЛОННЫЙ МЕТОД задает "скелет" алгоритма в методе,
 * оставляя определение реализации некоторых шагов субклассам.
 * Субклассы могут переопределять некоторые части алгоритма
 * без изменения его структуры.
 */

public class Main {
    public static void main(String[] args) {
        ModelHaircutCash haircut1 = new ModelHaircutCash();//модельная стрижка
        System.out.println("алгоритм для модельной стрижки: ");
        haircut1.perform();
        System.out.println("-------------------");
        System.out.println("алгоритм для стрижки под машинку: ");
        CrewCutCard haircut2 = new CrewCutCard();//стрижка под машинку
        haircut2.perform();
    }
}

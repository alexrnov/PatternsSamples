package singleton;

/**
 * Паттерн ОДИНОЧКА гарантирует, что класс имеет только один экземпляр,
 * и предоставляет глобальную точку доступа к этому экземпляру.
 */
public class Main {
    public static void main(String[] args) {
        //создать новый синглетон
        Singleton singleton = Singleton.getInstance("Class - singleton");
        System.out.println(singleton.getDescription());
        System.out.println("--------------------");
        //новый синглетон создан не будет, а вернется ссылка на синглетон,
        //созданный ранее
        Singleton singleton2 = Singleton.getInstance("Class - singleton2");
        System.out.println(singleton.getDescription());
        System.out.println("--------------------");
        //также вернется ссылка на созданный в начале программы объект
        Singleton singleton3 = Singleton.getInstance();
        System.out.println(singleton.getDescription());
        System.out.println("--------------------");
        //изменить состояние синглетона
        singleton3.setDescription("change singleton");
        System.out.println(singleton.getDescription());
        System.out.println("--------------------");
        if (singleton == singleton2 && singleton == singleton3) {
            System.out.println("One and the same object");
        }
    }
}

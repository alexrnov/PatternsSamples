package singleton;

public class Singleton {
    private static Singleton instance;//синглетон содержит ссылку на объект того же класса
    private String description;

    /**
     * Синглетон должен содержать только закрытый конструктор, который
     * может быть вызван только из самого класса, это обеспечивает уникальность класса
     */
    private Singleton() {
        description = "Unknown";
    }

    private Singleton(String description) {
        this.description = description;
    }

    /**
     * благодоря синхронизации, каждый поток дожидается своей очереди для входа
     * в метод. Приводит к лишним затратам ресурсов при втором и последущими вызовами
     * метода. Это происходит потому, что при первом вызове getInstance() переменной
     * экземпляра instance будет присвоен объект, содержащий синхронизированный метод,
     * а последующие вызовы getInstance() все равно будут синхронизироваться, хотя в этом
     * нет необходимости.
     * @return
     */
    public static synchronized Singleton getInstance() {
        if (instance == null) { //если объект ранее не был создан
            instance = new Singleton();//создать синглетон, вызвав закрытый конструктор
        } //в ином случае возвращается экземпляр созданного ранее объекта в этом экземпляре класса
        return instance;
    }

    public static synchronized Singleton getInstance(String description) {
        if (instance == null) {
            instance = new Singleton(description);
        }
        return instance;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

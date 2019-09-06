package simple_factory;

public class Soldier {
    protected String typeSoldier = "Unknown type";
    public String getTypeSoldier() {
        return typeSoldier;
    }
    public void walk() { //идти
        System.out.println(typeSoldier + " walk");
    }
    public void stop() { //остановится
        System.out.println(typeSoldier + " stop");
    }
    public void run() { //бежать
        System.out.println(typeSoldier + " run");
    }
}

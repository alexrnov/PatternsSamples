package composer;

/**
 * Рабочий организации. Является классом листового узла и реализует
 * поведение листа.
 */
public class Worker extends StructureComponent {
    private String name;
    private int old;

    public Worker(String name, int old) {
        this.name = name;
        this.old = old;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getOld() {
        return old;
    }

    @Override
    public boolean isYoungSpecialist() {
        return (old <= 30) ? true : false;
    }

    @Override
    public void print() {
        System.out.print("Сотрудник: name: " + getName() + ", old: " + getOld());
        if (isYoungSpecialist()) {
            System.out.println(", young specialist.");
        } else {
            System.out.println();
        }
        System.out.println("--------------------");
    }
}

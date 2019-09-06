package composer;

/**
 * Интерфейс как для листьев, так и для комбинационных узлов
 */
public abstract class StructureComponent {
    /*
    так как одни методы имеют смысл только для Subdivision, а другие -
    только для worker, реализация по умолчанию инициирует UnsupportedOperationException.
    Если объект Subdivision или Worker не поддерживает операцию, ему не нужно
    ничего делать - он просто наследует реализацию по умолчанию.
     */

    //группа из трех "комбинационных" методов - то есть методов для добавления,
    //удаления и получения Subdivision
    public void add(StructureComponent structureComponent) {
        throw new UnsupportedOperationException();
    }

    public void remove(StructureComponent structureComponent) {
        throw new UnsupportedOperationException();
    }

    public StructureComponent getChild(int i) {
        throw new UnsupportedOperationException();
    }

    //группа методов "операций" используемых Worker, метод
    //getName() может использоваться и в Subdivision
    public String getName() {
        throw new UnsupportedOperationException();
    }

    public int getOld() {
        throw new UnsupportedOperationException();
    }

    public boolean isYoungSpecialist() {
        throw new UnsupportedOperationException();
    }

    //метод print испоользуется как в Subdivision так и в Worker,
    //но при этом используется реализация по умолчанию
    public void print() {
        throw new UnsupportedOperationException();
    }
}


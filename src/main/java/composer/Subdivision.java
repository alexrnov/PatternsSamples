package composer;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Подразделение(основная организация, дочерняя организация, отдел).
 * Является классом комбинационного узла, который может содержать
 * как листья(Worker), так и комбинации(Subdivision). Этот класс
 * не реализут методы getOld() и isYoungEngineer(), потому что эти методы
 * не имеют особого смысла для подразделения
 */
public class Subdivision extends StructureComponent {
    //здесь храняться элементы комбинации, которые могут быть
    //как комбинационными узлами, так и листьями
    ArrayList structureComponents = new ArrayList();
    String name; //название подразделения
    public Subdivision(String name) {
        this.name = name;
    }

    //следующие три метода для включения в подразделение объектов
    //сотрудников или других подразделений, удаления и получения этих объектов.
    //Так как и worker и Subdivision расширяют один интерфейс,
    //для них используются одинаковые методы
    @Override
    public void add(StructureComponent structureComponent) {
        structureComponents.add(structureComponent);
    }

    @Override
    public void remove(StructureComponent structureComponent) {
        structureComponents.remove(structureComponent);
    }

    @Override
    public StructureComponent getChild(int i) {
        return (StructureComponent)structureComponents.get(i);
    }

    @Override
    public String getName() {
        return name;
    }

    public void print() {
        System.out.println("____________________");
        System.out.println("Подразделение: " + getName());
        /*
        Мы используем итератор для перебора всех компонентов объекта Subdivision
        Ими могут быть другие объекты Subdivision или объекты Worker.
        Так как и Subdivision и Worker реализуют метод print(), мы просто вызываем
        print(), а все остальное они сделают сами. Если в процессе перебора мы
        встретим другой объект подразделения, его метод print() начнет
        новый перебор и т.д. (то есть здесь организуется рекурсия)
         */
        Iterator iterator = structureComponents.iterator();
        while (iterator.hasNext()) {
            StructureComponent structureComponent = (StructureComponent) iterator.next();
            structureComponent.print();
        }

    }






}

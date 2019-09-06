package composer;

/**
 * На примере создания структуры организации демонстрируется концепция
 * паттерна КОМПОНОВЩИК. Паттерн КОМПОНОВЩИК объединяет объекты в
 * древовидные структуры для представления иерархий «часть-целое».
 */
public class Main {
    public static void main(String[] args) {
        //главная организация
        StructureComponent generalOrganization = new Subdivision("Основная организация");
        //дочернии организации
        StructureComponent childOrganization1 = new Subdivision("Дочерняя организация N1");
        StructureComponent childOrganization2 = new Subdivision("Дочерняя организация N2");
        StructureComponent childOrganization3 = new Subdivision("Дочерняя организация N3");
        //отделы
        StructureComponent department1 = new Subdivision("Отдел N1");
        StructureComponent department2 = new Subdivision("Отдел N2");
        StructureComponent department3 = new Subdivision("Отдел N3");

        //в главной организации есть директор
        generalOrganization.add(new Worker("director",67));
        //в главной организации три дочерних организации
        generalOrganization.add(childOrganization1);
        generalOrganization.add(childOrganization2);
        generalOrganization.add(childOrganization3);

        //в первой дочерней организации два отдела
        childOrganization1.add(department1);
        childOrganization1.add(department2);
        //во второй дочерней организации один отдел
        childOrganization2.add(department3);
        //в третьей дочерней организации нет отделов, только сотрудники
        childOrganization3.add(new Worker("worker5", 67));
        childOrganization3.add(new Worker("worker6", 70));

        //добавлние работников в подразделения
        department1.add(new Worker("worker1", 45));
        department1.add(new Worker("worker2", 23));
        department2.add(new Worker("worker3", 46));
        department3.add(new Worker("worker4", 24));

        //рекурсивно вывести информацию обо всех элементах иерархии,
        //таких как подразделения(комбинационные узлы) и сотрудники(листья)
        generalOrganization.print();

    }
}

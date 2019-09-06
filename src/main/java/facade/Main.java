package facade;

/**
 * На примере подсистем автомобиля демонстрируется концепция паттерна ФАСАД.
 * Паттерн ФАСАД предоставляет унифицированный интерфейс к группе
 * интерфейсов подсистемы. ФАСАД определяет высокоуровневый интерфейс,
 * упрощающий работу с подсистемой.
 */

public class Main {
    public static void main(String[] args) {
        FuelSystem fuelSystem = new FuelSystem();//топливная подсистема
        //электрическая подсистема
        ElectricalSystem electricalSystem = new ElectricalSystem();
        //охлаждающая подсистема
        RefrigeratingSystem refrigeratingSystem = new RefrigeratingSystem();
        //автомобиль, в данном случае, является высокоуровневым интерфейсом,
        //упрощающим работу с подсистемами
        AutomobileFacade automobile = new AutomobileFacade(fuelSystem,
                                                           electricalSystem,
                                                           refrigeratingSystem);
        //при запуске двигателя автомобиля все подсистемы запускаются одной инструкцией
        automobile.start();
        System.out.println("-------------------");
        //при остановке двигателя автомобиля все подсистемы останавливаются одной инструкцией
        automobile.stop();
        //получается, что вместо шести команд разным подсистемам, используется
        //только две - start() и stop()
    }
}

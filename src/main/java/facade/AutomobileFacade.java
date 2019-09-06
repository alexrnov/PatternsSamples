package facade;

/**
 * Экземпляр данного класса предоставляет высокоуровневый
 * интерфейс для управления подсистемами автомобиля
 */
public class AutomobileFacade {
    FuelSystem fuelSystem;
    ElectricalSystem electricalSystem;
    RefrigeratingSystem refrigeratingSystem;

    public AutomobileFacade(FuelSystem fuelSystem,
                            ElectricalSystem electricalSystem,
                            RefrigeratingSystem refrigeratingSystem) {
        this.fuelSystem = fuelSystem;
        this.electricalSystem = electricalSystem;
        this.refrigeratingSystem = refrigeratingSystem;
    }

    public void start() { //при запуске двигателя все системы начинают работать
        electricalSystem.turnOnIgnition();
        fuelSystem.beginSupplyFuel();
        refrigeratingSystem.turnOn();
    }

    public void stop() { //при остановке двигателя все системы заканчивают работу
        electricalSystem.turnOffIgnition();
        fuelSystem.stopSupplyFuel();
        refrigeratingSystem.turnOff();
    }
}

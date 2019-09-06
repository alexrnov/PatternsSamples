package observer;

/**
 * Классы, реализуеющие интерфейс, являются наблюдаемыми объектами
 */
public interface Observable {
    void registerObserver(Observer observer); //регистрирует наблюдателей
    void removeObserver(Observer observer); //удаляет наблюдателей
    void notifyObservers(); //оповещает наблюдателей
}

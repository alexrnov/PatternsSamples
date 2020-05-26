package observer;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс осуществляет рассылку сообщений адресатам
 */
public class Mailer implements Observable {
    //список наблюдателей (адресатов)
    private List<Observer> observers = new ArrayList<>();
    private Message message;
    private boolean changed = false;

    public Mailer() {

    }

    @Override
    public void registerObserver(Observer observer) {
        if (observers.contains(observer)) {

        }
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        int i = observers.indexOf(observer);
        if (i >= 0) {
            observers.remove(i);
        }
    }

    /**
     * триггер определяет, нужно ли вносить изменения
     */
    public void setChanged() {
        changed = true;
    }

    @Override
    public void notifyObservers() {
        if (changed) {
            //оповестить наблюдателей (разослать сообщение адресатам)
            for (Observer observer: observers) {
                observer.update(message);
            }
            changed = false;
        }
    }

    public void setMessage(Message message) {
        this.message = message;
    }
}

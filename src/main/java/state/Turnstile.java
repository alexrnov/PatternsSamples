package state;


/**
 * Класс турникета, принимающий различные состояния.
 * На примере изменений состояния турникета демонстрируется концепция
 * паттерна СОСТОЯНИЕ. Паттерн СОСТОЯНИЕ управляет изменением поведения
 * объекта при изменении его внутреннего состояния.
 * Внешне это выглядит так, словно объект меняет свой класс.
 * Переходами между состояниями могут управлять как классы состояний,
 * так и классы контекстов.
 */
public class Turnstile {
    /*
    Все возможные состояния
     */
    private State closedState; //турникет закрыт (пока не брошен жетон)
    private State openState; //турникет открыт (пока не прошел человек)
    private State overfillState; //турникет переполнен жетонами
    private State alwaysCloseState; //все время закрыт
    private State alwaysOpenState; //все время открыт

    /* переменная для хранения текущего состояния */
    private State currentState;
    private int amountJettons = 0;


    public Turnstile() {
        closedState = new ClosedState(this);
        openState = new OpenState(this);
        overfillState = new OverfillState(this);
        alwaysCloseState = new AlwaysCloseState(this);
        alwaysOpenState = new AlwaysOpenState(this);
        currentState = closedState;//установить текущее состояние
    }

    /*
    действия делегируются объекту текущего состояния
     */
    public void insertJetton() {
        currentState.insertJetton();
    }

    public void walk() {
        currentState.walk();
    }

    /*
    get-методы для получения объектов состояний
     */
    public State getClosedState() {
        return closedState;
    }

    public State getOpenState() {
        return openState;
    }

    public State getOverfillState() {
        return overfillState;
    }

    /*
    Эти методы позволяют клиенту явно изменять состояние турникета
     */
    public void clearTurnstile() {
        if (amountJettons > 2) {
            amountJettons = 0;
            currentState = closedState;
            System.out.println("Турникет освобожден от жетонов");
        }
    }

    public void close() {
        System.out.println("Турникет всегда закрыт");
        currentState = alwaysCloseState;
    }

    public void open() {
        System.out.println("Турникет всегда открыт");
        currentState = alwaysOpenState;
    }

    public void work() {
        System.out.println("Турникет начал работать");
        if (amountJettons > 2) {
            currentState = overfillState;
        } else {
            currentState = closedState;
        }
    }

    /*
    Этот метод позволяет другим объектам состояний перевести
    турникет в другое состояние
     */
    public void setCurrentState(State currentState) {
        this.currentState = currentState;
    }

    public int getAmountJettons() {
        return amountJettons;
    }

    public void addJetton() {
        amountJettons++;
    }
}

package state;

/**
 * Состояние постоянно открытого турникета
 */
public class AlwaysOpenState implements State {

    private Turnstile turnstile;

    public AlwaysOpenState(Turnstile turnstile) {
        this.turnstile = turnstile;
    }

    @Override
    public void insertJetton() {
        System.out.println("Нельзя вставить жетон, турникет и так постоянно открыт");
    }

    @Override
    public void walk() {
        System.out.println("Можно пройти, турникет открыт все время");
    }
}

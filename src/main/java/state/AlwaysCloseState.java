package state;

/**
 * Состояние постоянно закрытого турникета
 */
public class AlwaysCloseState implements State {

    private Turnstile turnstile;

    public AlwaysCloseState(Turnstile turnstile) {
        this.turnstile = turnstile;
    }

    @Override
    public void insertJetton() {
        System.out.println("Нельзя вставить жетон, турникет постоянно закрыт");
    }

    @Override
    public void walk() {
        System.out.println("нельзя пройти, турникет всегда закрыт");
    }
}

package state;

/**
 * Закрытое состояние турникета - ни кого не впускать, приемник жетонов открыт
 */
public class ClosedState implements State {

    private Turnstile turnstile;

    public ClosedState(Turnstile turnstile) {
        this.turnstile = turnstile;
    }

    @Override
    public void insertJetton() {
        //перейти в сосотяние открытого турникета
        System.out.println("В турникет брошена монетка");
        turnstile.addJetton();
        turnstile.setCurrentState(turnstile.getOpenState());

    }

    @Override
    public void walk() {
        System.out.println("Сначала нужно вставить жетон");
    }
}

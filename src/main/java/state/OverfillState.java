package state;

/**
 * Состояние переполенного турникета - турникет закрыт, приемник жетонов закрыт
 */
public class OverfillState implements State {

    private Turnstile turnstile;

    public OverfillState(Turnstile turnstile) {
        this.turnstile = turnstile;
    }

    @Override
    public void insertJetton() {
        System.out.println("Не принимать жетон - автомат переполен");
    }

    @Override
    public void walk() {
        System.out.println("Проход закрыт - автомат переполнен");
    }
}

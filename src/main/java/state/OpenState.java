package state;

/**
 * Открытое состояние турникета - проход открыт, приемник жетонов закрыт
 */
public class OpenState implements State {

    private Turnstile turnstile;

    public OpenState(Turnstile turnstile) {
        this.turnstile = turnstile;
    }

    @Override
    public void insertJetton() {
        System.out.println("Не принимать жетон");
    }

    @Override
    public void walk() {
        System.out.println("Пропустить одного человека");
        if (turnstile.getAmountJettons() > 2) { //если максимальное количество жетонов в турникете (здесь условно 3)
            //перейти в состояние переполненного турникета
            turnstile.setCurrentState(turnstile.getOverfillState());
        } else { //если максимальное количесвто жетонов в турникете еще не достигнуто
            turnstile.setCurrentState(turnstile.getClosedState());
        }
    }
}

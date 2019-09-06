package state;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class StateTest {

    private Turnstile turnstile;

    @Before
    public void setUp() throws Exception {
        turnstile = new Turnstile();
    }

    @After
    public void tearDown() throws Exception {
        turnstile = null;
    }

    @Test
    public void stateTest() {
        turnstile.walk();//попытаться пройти
        turnstile.insertJetton();//вставить жетон
        turnstile.walk();
        turnstile.walk();
        System.out.println("Количество жетонов в автомате = " + turnstile.getAmountJettons());
        System.out.println("-----------------------");
        turnstile.insertJetton();
        turnstile.walk();
        System.out.println("Количество жетонов в автомате = " + turnstile.getAmountJettons());
        System.out.println("-----------------------");
        turnstile.insertJetton();
        turnstile.walk();
        System.out.println("Количество жетонов в автомате = " + turnstile.getAmountJettons());
        System.out.println("-----------------------");
        turnstile.insertJetton();
        turnstile.walk();
        System.out.println("-----------------------");
        turnstile.clearTurnstile(); //освободить турникет от жетонов
        turnstile.walk();
        turnstile.insertJetton();
        turnstile.walk();
        System.out.println("Количество жетонов в автомате = " + turnstile.getAmountJettons());
        System.out.println("-----------------------");
        turnstile.insertJetton();
        turnstile.walk();
        System.out.println("Количество жетонов в автомате = " + turnstile.getAmountJettons());
        System.out.println("-----------------------");
        turnstile.insertJetton();
        turnstile.walk();
        System.out.println("Количество жетонов в автомате = " + turnstile.getAmountJettons());
        System.out.println("-----------------------");
        turnstile.insertJetton();
        turnstile.close(); //закрыть турникет, чтобы он был закрыт постоянно
        turnstile.insertJetton();
        turnstile.walk();
        System.out.println("-----------------------");
        turnstile.open(); //открыть турникет, чтобы он был открыт постоянно
        turnstile.walk();
        turnstile.insertJetton();
        System.out.println("-----------------------");
        turnstile.work();
        turnstile.insertJetton();
        turnstile.clearTurnstile();
        System.out.println("-----------------------");
        turnstile.insertJetton();
        turnstile.walk();
        System.out.println("Количество жетонов в автомате = " + turnstile.getAmountJettons());
    }
}
package simple_factory;

/**
 * Класс представляет собой простую фабрику
 */
public class SoldierFactory {
    public static Soldier createSoldier(String typeSoldier) {
        Soldier soldier = null;
        if (typeSoldier.equals("Bowman")) {
            soldier = new Bowman();
        } else if (typeSoldier.equals("Swordman")) {
            soldier = new Swordman();
        } else if (typeSoldier.equals("Spearman")) {
            soldier = new Spearman();
        }
        return soldier;
    }
}

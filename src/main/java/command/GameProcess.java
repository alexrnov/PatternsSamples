package command;

/**
 * Игровое время. Может убыстряться, замедляться, останавливаться
 */
public class GameProcess {
    enum GameRate {STOP, VERYSLOW, SLOW, NORMAL,
        QUICK, VERYQUICK}
    private GameRate currentRate = GameRate.NORMAL;

    public void stop() {
        currentRate = GameRate.STOP;
        System.out.println(currentRate);
    }

    /**
     * замедляет игровое время
     */
    public void reduceGameRate() {
        if (currentRate == GameRate.VERYQUICK) {
            currentRate = GameRate.QUICK;
        } else if (currentRate == GameRate.QUICK) {
            currentRate = GameRate.NORMAL;
        } else if (currentRate == GameRate.NORMAL) {
            currentRate = GameRate.SLOW;
        } else if (currentRate == GameRate.SLOW) {
            currentRate = GameRate.VERYSLOW;
        } else if (currentRate == GameRate.VERYSLOW) {
            currentRate = GameRate.STOP;
        }
        System.out.println(currentRate);
    }

    /**
     * убыстряет игровое время
     */
    public void enhanceGameRate() {
        if (currentRate == GameRate.STOP) {
            currentRate =  GameRate.VERYSLOW;
        } else if (currentRate == GameRate.VERYSLOW) {
            currentRate = GameRate.SLOW;
        } else if (currentRate == GameRate.SLOW) {
            currentRate = GameRate.NORMAL;
        } else if (currentRate == GameRate.NORMAL) {
            currentRate = GameRate.QUICK;
        } else if (currentRate == GameRate.QUICK) {
            currentRate = GameRate.VERYQUICK;
        }
        System.out.println(currentRate);
    }
}

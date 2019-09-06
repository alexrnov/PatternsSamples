package command;

/**
 * класс-команда для убыстрения игрового времени
 */
public class GameEnhanceCommand implements Command {
    private GameProcess gameProcess;
    public GameEnhanceCommand(GameProcess gameProcess) {
        this.gameProcess = gameProcess;
    }
    public void execute() {
        gameProcess.enhanceGameRate();
    }
    public void undo() {

    }
}

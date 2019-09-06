package command;

/**
 * класс-команда для замедления игрового времени
 */
public class GameReduceCommand implements Command {
    private GameProcess gameProcess;
    public GameReduceCommand(GameProcess gameProcess) {
        this.gameProcess = gameProcess;
    }
    public void execute() {
        gameProcess.reduceGameRate();
    }
    public void undo() {

    }
}

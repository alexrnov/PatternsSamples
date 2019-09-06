package command;

/**
 * класс-команда для остановки игрового времени
 */
public class GameStopCommand implements Command {
    private GameProcess gameProcess;
    public GameStopCommand(GameProcess gameProcess) {
        this.gameProcess = gameProcess;
    }
    public void execute() {
        gameProcess.stop();
    }
    public void undo() {

    }
}

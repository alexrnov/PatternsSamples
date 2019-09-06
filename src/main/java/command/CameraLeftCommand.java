package command;

/**
 * Команда - двигающая камеру влево
 */
public class CameraLeftCommand implements Command {
    private Camera camera;
    public CameraLeftCommand(Camera camera) {
        this.camera = camera;
    }
    public void execute() {
        camera.moveLeft();
    }
    public void undo() {
        camera.fixity();
    }
}

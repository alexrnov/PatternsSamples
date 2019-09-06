package command;

/**
 * Команда - двигающая камеру вверх
 */
public class CameraUpCommand implements Command {
    Camera camera;
    public CameraUpCommand(Camera camera) {
        this.camera = camera;
    }
    public void execute() {
        camera.moveUp();
    }
    public void undo() {
        camera.fixity();
    }
}

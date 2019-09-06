package command;

/**
 * Команда - двигающая камеру вниз
 */
public class CameraDownCommand implements Command {
    Camera camera;
    public CameraDownCommand(Camera camera) {
        this.camera = camera;
    }
    public void execute() {
        camera.moveDown();
    }
    public void undo() {
        camera.fixity();
    }
}

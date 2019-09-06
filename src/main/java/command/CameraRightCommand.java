package command;

/**
 * команда двигающая камеру вправо
 */
public class CameraRightCommand implements Command {
    private Camera camera;

    public CameraRightCommand(Camera camera) {
        this.camera = camera;
    }

    public void execute() {
        camera.moveRight();
    }

    public void undo() {
        camera.fixity();
    }
}

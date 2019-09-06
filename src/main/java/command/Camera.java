package command;

/**
 * Камера в игре. Она может двигаться в разные стороны,
 * а также фиксироваться
 */
public class Camera {
    enum CameraStatus {FIXITY, MOVERIGHT,
        MOVELEFT, MOVETOP, MOVEDOWN}
    CameraStatus cameraStatus = CameraStatus.FIXITY;
    public void moveRight() {
        cameraStatus = CameraStatus.MOVERIGHT;
        System.out.println("Camera move right");
    }
    public void moveLeft() {
        cameraStatus = CameraStatus.MOVELEFT;
        System.out.println("Camera move left");
    }
    public void moveUp() {
        cameraStatus = CameraStatus.MOVELEFT;
        System.out.println("Camera move up");
    }
    public void moveDown() {
        cameraStatus = CameraStatus.MOVEDOWN;
        System.out.println("Camera move down");
    }
    public void fixity() {
        cameraStatus = CameraStatus.FIXITY;
        System.out.println("Camera is fixity");
    }
}

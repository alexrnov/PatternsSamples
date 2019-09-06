package adapter;

/**
 * IPhone, исходя из интерфейса, позволяет нажимать на тачскрин,
 * звонить, фотографировать, и менять ориентацию экрана
 */
public class IPhone7 implements SmartPhone {
    @Override
    public void pressTouchScreen() {
        System.out.println("press touch screen");
    }
    @Override
    public void cellUp() {
        System.out.println("cell up");
    }
    @Override
    public void photograph() {
        System.out.println("photograph");
    }
    @Override
    public void changeOrientationDisplay() {
        System.out.println("change orientation display");
    }
}

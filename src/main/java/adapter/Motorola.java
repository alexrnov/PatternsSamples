package adapter;

/**
 * Motorola, исходя из интерфейса, позволяет нажимать на кнопки,
 * звонить и фотографировать
 */
public class Motorola implements MobilePhone {
    @Override
    public void pressKey() {
        System.out.println("press key");
    }
    @Override
    public void cellUp() {
        System.out.println("cell up");
    }
    @Override
    public void photograph() {
        System.out.println("photograph");
    }
}

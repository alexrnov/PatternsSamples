package method_factory;

/**
 * суперкласс для номера отеля
 */
public abstract class Room {
    public boolean hasFreeRoom() {
        return true;
    }
    public void booking() {
        System.out.println("room is booking");
    }
    public abstract void getDescription();
}

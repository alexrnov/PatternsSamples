package method_factory;

public class PlazaHotel extends Hotel {

    /**
     * реализуется фабричный метод, объявленный абстрактным в суперклассе.
     * В зависимости от типа номера возвращается объект номера
     * @param typeOfRoom тип номера
     * @return объект номера
     */
    @Override
    protected Room createRoom(String typeOfRoom) {
        if (typeOfRoom.equalsIgnoreCase("econom")) {
            return new EconomPlaza();
        } else if (typeOfRoom.equalsIgnoreCase("standard")) {
            return new StandardPlaza();
        } else if (typeOfRoom.equalsIgnoreCase("lux")) {
            return new LuxPlaza();
        } else {
            return null;
        }
    }
}

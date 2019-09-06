package method_factory;

public class BlossomHotel extends Hotel {

    /**
     * реализуется фабричный метод, объявленный абстрактным в суперклассе.
     * В зависимости от типа номера возвращается объект номера
     * @param typeOfRoom тип номера
     * @return объект номера
     */
    @Override
    protected Room createRoom(String typeOfRoom) {
        if (typeOfRoom.equalsIgnoreCase("econom")) {
            return new EconomBlossom();
        } else if (typeOfRoom.equalsIgnoreCase("standard")){
            return new StandardBlossom();
        } else if (typeOfRoom.equalsIgnoreCase("lux")) {
            return new LuxBlossom();
        } else {
            return null;
        }
    }
}

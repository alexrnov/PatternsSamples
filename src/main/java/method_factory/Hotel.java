package method_factory;

/**
 * суперкласс класс для отеля содержит абстрактный фабричный метод,
 * который должны реализовывать субклассы. Фабричный метод возвращает объект,
 * с которым продолжает работать суперкласс в методе booking.
 * При этом суперкласс даже не знает, с каким конкретным объектом он работает.
 * Ему достаточно лишь информации о том, что этот объект реализует интерфейс Room
 */
public abstract class Hotel {
    public Room bookingRoom(String typeOfRoom) {
        //вызывается реализованный метод субкласса (фабричный метод)
        Room room = createRoom(typeOfRoom);
        if (room.hasFreeRoom()) { //далее с ним продолжается работа в суперклассе
            room.booking(); //бронировать номер
        }
        return room;
    }

    /**
     * данный фабричный метод реализуется в субклассах
     * @param typeOfRoom тип номера
     * @return объект номера
     */
    protected abstract Room createRoom(String typeOfRoom);
}

package method_factory;

/**
 * На примере бронирования отелей показан принцип действия паттерна
 * фабричный метод. Паттерн ФАБРИЧНЫЙ МЕТОД определяет интерфейс
 * создания объекта, но позволяет субклассам выбрать класс создаваемого
 * экземпляра. Таким образом, ФАБРИЧНЫЙ МЕТОД делегирует операцию
 * создания экземпляра субклассам.
 */
public class Main {
    public static void main(String[] args) {
        BlossomHotel blossomHotel = new BlossomHotel();
        //сначала вызывается метод суперкласса(booking), затем в зависимости от типа
        //субкласса(BlossomHotel) вызывается переопределенный фабричный метод субкласса(createRoom),
        //далее объект номера возвращается методу суперкласса(booking), и происходит
        //бронирование номера(room.booking())
        Room room1 = blossomHotel.bookingRoom("econom");
        room1.getDescription();//показать тип забронированного номера
        System.out.println("-----------------------");
        Room room2 = blossomHotel.bookingRoom("standard");
        room2.getDescription();
        System.out.println("-----------------------");
        Room room3 = blossomHotel.bookingRoom("lux");
        room3.getDescription();
        System.out.println("-----------------------");
        PlazaHotel plazaHotel = new PlazaHotel();
        Room room4 = plazaHotel.bookingRoom("econom");
        room4.getDescription();
        System.out.println("-----------------------");
        Room room5 = plazaHotel.bookingRoom("standard");
        room5.getDescription();
        System.out.println("-----------------------");
        Room room6 = plazaHotel.bookingRoom("lux");
        room6.getDescription();
    }
}

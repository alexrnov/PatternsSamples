package protector_proxy;

import java.lang.reflect.Proxy;

/**
 * Демонстрируется работа паттерна ЗАЩИТНЫЙ ЗАМЕСТИТЕЛЬ. Этот паттерн
 * управляет доступом к методам объекта, в зависимости от привилегий
 * вызывающей стороны.
 * Данный паттерн является динамическим заместителем, потому-что класс
 * заместителя создается во время выполнения.
 */
public class InvokesTest {
  public static void main(String[] args) {
    //создание объекта с данными и с методами для манипулирования с ними
    Information information = new InformationImpl();
    //первый пользователь имеет права только на чтение свободных данных
    Information user1 = getReadFreeInfoProxy(information);

    //для первого пользователя доступно только чтение открытых данных
    try {
      System.out.println("Read free data = " + user1.getData("b"));
      System.out.println(user1.getSecretData("s1"));
    } catch(Exception e) {
      System.out.println("method getSecretData not access for current user");
    }

    System.out.println("-----------------------------------------");
    //для второго пользователя доступно также чтение закрытых данных
    Information user2 = getReadSeckretInfoProxy(information);
    try {
      System.out.println("Read seckret data = " + user2.getSecretData("s3"));
      user2.setData("d", "thing 4");
    } catch(Exception e) {
      System.out.println("set-methods not available for user 2");
    }

    System.out.println("-----------------------------------------");
    //для третьего пользователя доступны все действия: чтение и запись
    //открытой и закрытой информации
    Information user3 = getReadAndWriteAllInfoProxy(information);
    System.out.println("All methods for user 3 available:");
    user3.setData("e", "thing 5");
    user3.setSecretData("s4", "secret thing 4");
    System.out.println(user3.getData("e"));
    System.out.println(user3.getSecretData("s4"));

  }

  /**
   * Создает заместителя с правами для чтения свободных данных
   * Метод получает реальный объект с данными и методами для их обработки
   * и возвращает для него заместителя. Так как заместитель обладает тем же
   * интерфейсом, что и реальный объект, мы возвращаем Information
   * @param information реальный объект
   * @return заместитель реального объекта
   */
  private static Information getReadFreeInfoProxy(Information information) {
    /*
     * Для создания заместителя используется статический метод
     * newProxyInstance класс Proxy
     */
    return (Information) Proxy.newProxyInstance(
            information.getClass().getClassLoader(), //передаем ему загрузчик класса для нашего реального объекта
            information.getClass().getInterfaces(), //и набор интерфейсов, который должен реализовывать заместитель
            new ReadFreeInvocationHandler(information)); //конструктору обработчика передается реальный объект
  }

  //создает заместителя для чтения секретных данных
  private static Information getReadSeckretInfoProxy(Information information) {
    return (Information) Proxy.newProxyInstance(
            information.getClass().getClassLoader(),
            information.getClass().getInterfaces(),
            new ReadSecretInvocationHandler(information));
  }

  //создает заместителя для чтения и записи любых данных
  private static Information getReadAndWriteAllInfoProxy(Information information) {
    return (Information) Proxy.newProxyInstance(
            information.getClass().getClassLoader(),
            information.getClass().getInterfaces(),
            new ReadAndWriteAllInvocationHandler(information));
  }


}

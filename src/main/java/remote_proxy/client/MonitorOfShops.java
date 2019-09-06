package remote_proxy.client;

//импорт серверных классов. Если к примеру в пакете client создать
//свой собственный интерфейс Shop, то при выполнении схемы удаленного
//доступа возникнет ошибка преобразования типов
import remote_proxy.server.Shop;
import remote_proxy.server.Thing;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NameClassPair;
import javax.naming.NamingException;
import java.rmi.RemoteException;
import java.util.Enumeration;

/**
 * Классы пакета remote_proxy демонстрируют паттерн УДАЛЕННЫЙ ЗАМЕСТИТЕЛЬ.
 * Паттерн УДАЛЕННЫЙ ЗАМЕСТИТЕЛЬ представляет суррогатный объект,
 * управляющий доступом к другому объекту. В частности, УДАЛЕННЫЙ ЗАМЕСТИТЕЛЬ
 * управляет взаимодействием клиента с удаленным объектом.
 */

/**
 * Клиент, вызывающий удаленный метод. Этот клиент осуществляет
 * мониторинг: проверят наличие товара по штрихкоду
 */
public class MonitorOfShops {
  public static void main(String[] args) {
    try {
      System.out.println("Run monitor of shop.");
      Context namingContext = new InitialContext();
      System.out.println("RMI registry bindings: ");
      /*
       * возвращает массив символьных строк с URL из реестра, расположенного
       * по указанному URL. Этот массив содержит моментальный снимок
       * всех представленных в реестре имен
       */
      Enumeration<NameClassPair> e = namingContext.list("rmi://localhost/");
      while(e.hasMoreElements()) {
        System.out.println(e.nextElement().getName());
      }
      String url1 = "rmi://localhost/shop1";
      String url2 = "rmi://localhost/shop2";
      /*
       * возвращает удаленный объект по указанному URL. Если указанное имя
       * в данный момент не связано ни с одним из объектов, генерируется
       * исключение типа NotBoundException
       */
      Shop shop1 = (Shop) namingContext.lookup(url1);
      Shop shop2 = (Shop) namingContext.lookup(url2);

      //обращение к заглушкам, как к настоящим объектам
      if (shop1.existThing("000001")) {
        System.out.println("Finding thing with barcode=000001 exist is first shop.");
      }

      if (shop2.existThing("000003")) {
        System.out.println("Finding thing with barcode=000003 exist is second shop.");
      }

      Thing thing1 = shop1.getThing("000002");
      System.out.println("Thing of first shop: " + "name: " + thing1.getName() + ", price: " + thing1.getPrice());
      Thing thing2 = shop2.getThing("000004");
      System.out.println("Thing of second shop: " + "name: " + thing2.getName() + ", price: " + thing2.getPrice());
    } catch (NamingException | RemoteException e) {
      e.printStackTrace();
    }
  }
}

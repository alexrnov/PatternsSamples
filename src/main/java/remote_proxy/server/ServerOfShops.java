package remote_proxy.server;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.rmi.RemoteException;

/**
 * Эта серверная программа служит для получения экземпляра удаленного
 * объекта товарного склада и его регистрации с помощью службы именования,
 * ожидая от клиентов вызова удаленных методов. Следует иметь ввиду, что
 * что серверная программа не завершается, поскольку при создании класса,
 * расширяющего класс UnicastRemoteObject, создается отдельный поток
 * исполнения, удерживающий серверную программу в активном состоянии до
 * бесконечности
 */
public class ServerOfShops {
  public static void main(String[] args) {
    try {
      System.out.println("Run remote_proxy.server for create shops:");
      Shop1 shop1 = new Shop1(); //создание первого магазина
      Shop2 shop2 = new Shop2(); //создание второго магазина
      System.out.println("Binding remote_proxy.server implementation to registry");
      Context namingContext = new InitialContext();
      namingContext.bind("rmi:shop1", shop1);
      namingContext.bind("rmi:shop2", shop2);
      System.out.println("Wait invokes clients...");
    } catch(RemoteException | NamingException e) {
      e.printStackTrace();
    }
  }
}

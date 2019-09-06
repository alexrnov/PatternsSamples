package remote_proxy.server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.Map;

/**
 * Первый магазин. Этот класс реализует удаленный интерфейс магазина remote_proxy.server.Shop
 */
public class Shop1 extends UnicastRemoteObject implements Shop {
  private Map<String, Thing> things = new HashMap<>();

  public Shop1() throws RemoteException {
    things.put("000001", new Thing("Book",1.1));
    things.put("000002", new Thing("Toy", 2.4));
  }

  /**
   * Проверяет наличие товара в данном магазине
   * @param barCode штрих-код по которому проверятся наличие товара в магазине
   * @return <code>true</code> - если товар есть в магазине,
   * <code>false</code> - в обратном случае
   */
  @Override
  public boolean existThing(String barCode) {
    return things.containsKey(barCode);
  }

  /**
   * Возвращает товар, соответствующий штрих-коду
   * @param barCode штрих-код по которому проверяется наличие товара в магазине
   * @return объект товара
   */
  @Override
  public Thing getThing(String barCode) {
    if (things.containsKey(barCode)) {
      return things.get(barCode);
    }
    return null;
  }
}

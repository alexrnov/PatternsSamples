package remote_proxy.server;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Удаленный интерфейс для магазина
 */
public interface Shop extends Remote {
  /**
   * @param barCode штрих-код по которому проверяется наличие товара в магазине
   * @return <code>true</code> - если товар присутствует на складе,
   * <code>false</code> - в противном случае
   * @throws RemoteException ошибка удаленного доступа
   */
  boolean existThing(String barCode) throws RemoteException;

  /**
   * @param barCode штрих-код по которому проверяется наличие товара в магазине
   * @return объект товара Thing
   * @throws RemoteException ошибка удаленного доступа
   */
  Thing getThing(String barCode) throws RemoteException;
}

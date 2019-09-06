package protector_proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Обработчик для пользователя, у которого есть права на чтение
 * как открытых, так и закрытых данных. Все обработчики реализуют
 * интерфейс InvocationHandler
 */
public class ReadSecretInvocationHandler implements InvocationHandler {
  private Information information;

  /**
   * Передаем реальный объект в конструкторе и сохраняем ссылку на него
   * @param information реальный объект, содержащий данные и методы для
   * манипулирования этими данными.
   */
  public ReadSecretInvocationHandler(Information information) {
    this.information = information;
  }

  /**
   * При каждом вызове любого метода заместителя вызывается метод invoke
   * @param proxy объект заместителя
   * @param method вызываемый метод
   * @param args исходные аргументы
   * @return результат работы метода (тип Object)
   * @throws IllegalAccessException
   */
  public Object invoke(Object proxy, Method method, Object[] args)
          throws IllegalAccessException {
    try {
      //если вызван метод просмотра общедоступных данных
      if (method.getName().equals("getData")
              || method.getName().equals("getSecretData")) {
        //вызов передается реальному объекту
        return method.invoke(information, args);
      } else {
        //вызов других методов блокируется выдачей исключения
        throw new IllegalAccessException();
      }
    } catch(InvocationTargetException e) {
      //выполняется при выдачи исключения реальным объектом
      e.printStackTrace();
    }
    //при вызове любого другого метода просто возвращается null, чтобы
    //избежать лишнего риска
    return null;
  }

}

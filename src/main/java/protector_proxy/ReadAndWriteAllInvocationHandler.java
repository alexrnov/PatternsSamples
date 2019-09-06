package protector_proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Обработчик для пользователя, у которого есть права на чтение
 * и запись открытых и закрытых данных.
 * Все обработчики реализуют интерфейс InvocationHandler
 */
public class ReadAndWriteAllInvocationHandler implements InvocationHandler {
  private Information information;

  /**
   * Передаем реальный объект в конструкторе и сохраняем ссылку на него
   * @param information реальный объект, содержащий данные и методы для
   * манипулирования этими данными.
   */
  public ReadAndWriteAllInvocationHandler(Information information) {
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
      //для данного обработчика разрешен вызов любых методов,
      //поэтому вызов передается реальному объекту
      return method.invoke(information, args);
    } catch(InvocationTargetException e) {
      //выполняется при выдачи исключения реальным объектом
      e.printStackTrace();
      return null;
    }
  }

}

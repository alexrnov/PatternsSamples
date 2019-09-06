package mvc.model;

import mvc.view_and_controller.Observer;

/**
 * Интерфейс модели. Задействован в паттерне НАБЛЮДАТЕЛЬ. Объект модели,
 * реализующий данный интерфейс, по сути является наблюдаемым объектом
 */
public interface ModelInterface {

  /*
   * Методы, используемые контроллером для управления моделью на основании
   * действий пользователя
   */
  Integer getValue(String key);

  /*
   * Методы, при помощи которых контроллер получает информацию о состоянии
   * модели и изменяет свой статус наблюдателя
   */

  void registerObserver(Observer observer);//регистрирует наблюдателей
  void removeObserver(Observer observer);//удаляет наблюдателей
  void notifyObservers();//оповещает наблюдателей

}

package mvc.model;

import mvc.Constants.MESSAGES;
import mvc.view_and_controller.Observer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Класс модели, содержит логику приложения, реализует интерфейс
 * наблюдаемого объекта
 */
public class Model implements ModelInterface {
  private Map<String, Integer> map1 = new HashMap<>();//данные модели
  private List<Observer> observers = new ArrayList<>();//список наблюдателей

  public Model() {
    map1.put("a", 1);
    map1.put("b", 2);
    map1.put("c", 3);
    map1.put("d", 4);
    //включить таймер, остчитывающий пять секунд и по истечению времени
    //оповещающий наблюдателей о том, что 5 секунд прошло
    timer();
  }

  @Override
  public Integer getValue(String key) {
    if (map1.containsKey(key)) {
      return map1.get(key);
    }
    return null;
  }

  /*
   * таймер отсчитывает пять секунд
   */
  private void timer() {
    long startTime = System.currentTimeMillis();
    //таймер запускается в отдельном потоке чтобы не блокировать работу приложения
    Thread t = new Thread(() -> {
      long spentTime = 0L;
      while (spentTime < 5000) {
        spentTime = System.currentTimeMillis() - startTime;
        System.out.println(spentTime);
      }
      notifyObservers();//оповестить наблюдателей, о том, что прошло пять секунд
    });
    t.start();//запустить поток
  }

  @Override
  public void registerObserver(Observer observer) {
    observers.add(observer);
  }

  @Override
  public void removeObserver(Observer observer) {
    int i = observers.indexOf(observer);
    if (i >= 0) {
      observers.remove(i);
    }
  }

  @Override
  public void notifyObservers() {
    for (Observer observer: observers) {
      observer.update(MESSAGES.PASSED_FIVE_SECOND);
    }
  }
}

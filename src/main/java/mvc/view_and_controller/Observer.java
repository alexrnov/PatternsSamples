package mvc.view_and_controller;

import mvc.Constants.MESSAGES;
/**
 * Классы, реализующие данный интерфейс, являются наблюдателями
 * объекта модели
 */
public interface Observer {
  void update(MESSAGES message);
}

package mvc.view_and_controller;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import mvc.Constants.MESSAGES;
import mvc.MainApplication;
import mvc.model.ModelInterface;

/**
 * Класс контроллера. Задействован в паттерне НАБЛЮДАТЕЛЬ: наблюдает
 * за состоянием модели. Контроллер не реализует ни какую прикладную
 * логику(управления и обработки данных), он только реализует
 * поведение представления.
 */
public class ControllerPril implements Observer {

  private ModelInterface model; //объект модели

  @FXML
  private TextField key; //текстовое поле для ввода ключа

  @FXML
  private TextField value; //текстовое поле для отображения значения

  @FXML
  private TextField output; //текстовое поле для вывода значения

  private MainApplication mainApplication; //ссылка на главный класс

  public ControllerPril() { //конструктор вызывается раньше метода initialize()
  }

  /* данный метод автоматически вызывается после загрузки fxml-файла */
  @FXML
  private void initialize() {
    System.out.println("Инициализация контроллера главного фрейма");
  }

  /* метод вызывается из главного класса приложения MainApplication
   * - устанавливает ссылку на главный класс
   */
  public void setMainApplication(MainApplication mainApplication) {
    this.mainApplication = mainApplication;
  }

  public void setModel(ModelInterface model) {
    this.model = model;
    //зарегестрировать контроллер в качестве наблюдателя для модели
    model.registerObserver(this);
  }

  /* метод вызывается при нажатии кнопки*/
  @FXML
  private void findValue() {
    String textKey = key.getText();
    Integer valueModel = model.getValue(textKey);
    if (valueModel != null) {
      value.setText(String.valueOf(valueModel)); //присвоить второму полю значение первого поля
    } else {
      value.setText("Нет такого ключа");
    }
  }

  /*
   * обновление контроллера и представления после изменения состояния
   * модели
   */
  @Override
  public void update(MESSAGES message) {
    if (message.equals(MESSAGES.PASSED_FIVE_SECOND)) {
      output.setText("Прошло пять секунд");
    }
  }
}

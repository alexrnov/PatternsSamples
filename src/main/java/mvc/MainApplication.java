package mvc;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import mvc.model.Model;
import mvc.view_and_controller.ControllerPril;

import java.net.URL;

/**
 * Составной паттерн MVC - модель-представление контроллер. Может
 * содержать паттерны СТРАТЕГИЯ, НАБЛЮДАТЕЛЬ, АДАПТЕР.
 * Представление и контроллер, в данном случае, не используют паттерн
 * СТРАТЕГИЯ, т.к. представление вообще не реализуется в классе, а описано
 * в файле FXML. При этом используется паттерн НАБЛЮДАТЕЛЬ: и в данном случае
 * наблюдаемым объектом является модель, а наблюдателем -
 * контроллер(контроллеры). Также может использоваться паттерн АДАПТЕР,
 * в случае, если необходимо привести конкретную модель к интерфейсу модели,
 * используемому в архитектуре. Может использоватся и паттерн КОМПОНОВЩИК для
 * упаковки элементов пользовательского интерфейса в древовидную структуру. В
 * данном случае этот паттерн также не используется, т.к. нет потребности в
 * комбинации элементов(к тому же с развитием графических интерфейсов роль
 * этого паттерна уже не так очевидна).
 * В web - контроллер реализуется в форме сервлета, а код JSP и HTML
 * формирует представление.
 */
public class MainApplication extends Application {
  private Stage stage;

  public void start(Stage stage) {
    try {
      this.stage = stage;
      FXMLLoader loader = new FXMLLoader();

      loader.setLocation(MainApplication.class.getResource("/mvc/view_and_controller/MainApplication.fxml"));
      AnchorPane pane = (AnchorPane) loader.load();//получить основную панель приложения
      Scene scene = new Scene(pane);//создать сцену и поместить туда основную панель приложения
      this.stage.setScene(scene);//создать сцену
      this.stage.setTitle("JavaFX-приложение");
      this.stage.show();
      ControllerPril controller = loader.getController();//получить контроллер(объект) класса ControllerPril
      controller.setMainApplication(this);//передать контроллеру ссылку на класс приложения
      controller.setModel(new Model());//передать контроллеру объект модели
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static void main(String[] args) {
    launch(args);
  }
}

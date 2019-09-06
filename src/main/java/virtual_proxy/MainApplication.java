package virtual_proxy;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * Класс приложения, для реализации паттерна ВИРТУАЛЬНЫЙ ЗАМЕСТИТЕЛЬ.
 * ВИРТУАЛЬНЫЙ ЗАМЕСТИТЕЛЬ управляет доступом к объекту, создание которого
 * сопряжено с большими трудозатратами.
 */
public class MainApplication extends Application {

  private Stage stage;

  public void start(Stage stage) {
    try {
      this.stage = stage;
      FXMLLoader loader = new FXMLLoader();
      loader.setLocation(MainApplication.class.getResource("/virtual_proxy/Application.fxml"));
      AnchorPane pane = (AnchorPane) loader.load();//получить основную панель приложения
      Scene scene = new Scene(pane);//создать сцену и поместить туда основную панель приложения
      this.stage.setScene(scene);//создать сцену
      this.stage.setTitle("JavaFX-приложение");
      this.stage.show();
      Controller1 controller = loader.getController();//получить контроллер(объект) класса ControllerPril
      controller.setMainApplication(this);//передать контроллеру ссылку на класс приложения} catch (Exception e) {
    } catch(Exception e){
      e.printStackTrace();
    }

  }

  public static void main(String[] args) {
    launch(args);
  }
}

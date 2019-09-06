package virtual_proxy;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

import java.util.concurrent.ExecutionException;

/**
 * Загружает изображение с удаленного ресурса. Является неудачной
 * попыткой реализовать ВИРТУАЛЬНЫЙ ЗАМЕСТИТЕЛЬ, поскольку класс
 * ImageProxy не является, в полном смысле, виртуальным заместителем,
 * т.к. не наследует от объекта Image, и его нельзя передать
 * методу imageView.setImage(). Вместе с тем, со своей работой он
 * справляется хорошо - изображение загружается в отдельном потоке,
 * не блокируя при этом работу остального приложения.
 */

public class Controller1 {

  @FXML
  private ImageView imageView; //компонент для визуализации изображения

  @FXML
  private HBox hbox1;//рамка для изображения

  @FXML
  private Label label1;//метка отображает статус загрузки

  @FXML
  private ProgressBar progressBar1;//компонент для отображения статуса загрузки

  @FXML
  private TextField field1;//текстовое поле для вывода статуса згрузки.

  private MainApplication application;//ссылка на главаный класс

  private ImageProxy imageProxy;//объект-заместитель

  /* метод вызывается из главного класса приложения MainApplication
   * - устанавливает ссылку на главный класс
   */
  public void setMainApplication(MainApplication application) {
    this.application = application;
  }

  /* данный метод автоматически вызывается после загрузки fxml-файла */
  @FXML
  private void initialize() {
    System.out.println("Инициализация контроллера главного фрейма");
  }

  /* метод вызывается при нажатии кнопки */
  @FXML
  private void clickButton1() throws ExecutionException, InterruptedException {
    System.out.println("Кнопка была нажата");

    //локальный ресурс
    //String url = "file:/D:/pictures/bezmyatezhnost-nebo-oblaka.jpg";
    //удаленный ресурс
    String url = "https://i0.wp.com/proselyte.net/wp-content/uploads/2016/02/java-oracle.png";

    /* передать все компоненты используемые при рендеринге конструктору объекта */
    imageProxy = new ImageProxy(imageView, hbox1, label1, progressBar1);
    imageProxy.load(url);//загрузить изображение по заданному url
  }

  /**
   * Вызывается при нажатии кнопки: выводит в текстовом поле статус загрузки
   * если значение 1.0 - приложение загружено
   */
  @FXML
  private void getStatusLoad() {
    System.out.println("Статус загрузки");
    if (imageProxy != null) {
      Image image = imageProxy.getImage();
      if (image != null) {
        System.out.println("Процесс загрузки = " + image.getProgress());
        field1.setText(String.valueOf(image.getProgress()));
      }
    }
  }
}

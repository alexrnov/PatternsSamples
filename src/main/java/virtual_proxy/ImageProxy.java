package virtual_proxy;

import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

/**
 * Данный класс реализует загрузку изображения в отдельном потоке, что
 * позволяет не блокировать работу остального приложения и при этом
 * правильно перерисовать остальные объекты интерфейса, такие как:
 * ImageView, Hbox, Label, ProgressBar. Если бы изображение загружалось
 * в фоновом режиме(backgroundLoading = true), тогда остальные оьъекты
 * интерфейса перерисовать было бы проблематично.
 */
public class ImageProxy {

  private Image image;
  private Double value = 0.0;
  private ImageView imageView;
  private HBox hbox;
  private Label label;
  private ProgressBar progressBar;

  /**
   * @param imageView компонент для визуализации изображения
   * @param hbox компонент рамки изображения
   * @param label компонент надписи для вывода информации о статусе загрузки
   * @param progressBar компонент, отображающий процесс загрузки
   */
  public ImageProxy(ImageView imageView, HBox hbox, Label label, ProgressBar progressBar) {
    this.imageView = imageView;
    this.hbox = hbox;
    this.label = label;
    this.progressBar = progressBar;
  }

  /**
   *
   * @param url локальный или сетевой адрес изображения
   */
  public void load(String url) {
    label.setText("Загрузка...");
    Runnable r = () -> {
      image = new Image(url, false);
      progressBar.progressProperty().bind(image.progressProperty());
      while (value < 1.0) { //повторять цикл пока изображение не загрузится
        value = image.getProgress();
      }
      //только после загрузки изображения, передать его компоненту визуализации
      //и изменить отображение других компонентов
      imageView.setImage(image);
      //определить размеры загруженного изображения
      double aspectRatio = image.getWidth() / image.getHeight();
      double realWidth = Math.min(imageView.getFitWidth(), imageView.getFitHeight() * aspectRatio);
      double realHeight = Math.min(imageView.getFitHeight(), imageView.getFitWidth() / aspectRatio);
      //задать рамке новые размеры, в соответствии с размерами изображения
      hbox.setPrefWidth(realWidth);
      hbox.setPrefHeight(realHeight);
      label.setVisible(false);//отключть отображение статуса загрузки
    };
    Thread t = new Thread(r);
    t.start();
  }

  public Image getImage() {
    return image;
  }
}

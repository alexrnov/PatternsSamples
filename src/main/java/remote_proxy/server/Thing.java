package remote_proxy.server;

import java.io.Serializable;

/**
 * Класс для создания объектов товаров. Содержит информацию по
 * наименованию товара и его цене. Объекты данного класса передаются
 * по сети, поэтому класс реализует интерфейс Serializable
 */
public class Thing implements Serializable {

  private String name;
  private Double price;

  public Thing(String name, Double price) {
    this.name = name;
    this.price = price;
  }

  public String getName() {
    return this.name;
  }

  public Double getPrice() {
    return this.price;
  }

}

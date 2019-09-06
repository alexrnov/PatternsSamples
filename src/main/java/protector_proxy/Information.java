package protector_proxy;

/**
 * Интерейс для записи и чтения данных, требующих разграничение доступа
 */
public interface Information {
  String getData(String name);
  String getSecretData(String name);

  void setData(String name, String value);
  void setSecretData(String name, String value);
}

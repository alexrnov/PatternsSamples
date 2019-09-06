package protector_proxy;

import java.util.HashMap;
import java.util.Map;

/**
 * Класс реализует интерфейс Information, и отвечает за хранение как
 * общедоступной информации, так и информации, закрытой для общего
 * просмотра
 */
public class InformationImpl implements Information {

  //массив для хранения свободной информации
  private Map<String, String> freeInfo = new HashMap<>();

  //массив для хранения закрытой информации
  private Map<String, String> seckretInfo = new HashMap<>();

  public InformationImpl() {
    freeInfo.put("a", "thing 1");
    freeInfo.put("b", "thing 2");
    freeInfo.put("c", "thing 3");

    seckretInfo.put("s1", "seckret thing 1");
    seckretInfo.put("s2", "seckret thing 2");
    seckretInfo.put("s3", "seckret thing 3");
  }

  @Override
  public String getData(String name) {
    if (freeInfo.containsKey(name)) {
      return freeInfo.get(name);
    }
    return null;
  }

  @Override
  public String getSecretData(String name) {
    if (seckretInfo.containsKey(name)) {
      return seckretInfo.get(name);
    }
    return null;
  }

  @Override
  public void setData(String name, String value) {
    freeInfo.put(name, value);
  }

  @Override
  public void setSecretData(String name, String value) {
    seckretInfo.put(name, value);
  }
}

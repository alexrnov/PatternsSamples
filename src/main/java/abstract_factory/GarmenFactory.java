package abstract_factory;

/**
 * Интерфейс, который предоставляет абстрактная фабрика.
 * В данном случае это создание семейств объектов одежды, определяющих
 * стиль одежды.
 */
public interface GarmenFactory {
    Top createTop(); //верхняя одежда
    Underside createUnderside(); //нижняя одежда
    Footwear createFootwear(); //обувь
}

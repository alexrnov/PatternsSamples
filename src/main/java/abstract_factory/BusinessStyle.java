package abstract_factory;

/**
 * абстактная фабрика - создает группу взаимосвязанных объектов одежды,
 * представляющую собой бизнес-стиль
 */
public class BusinessStyle implements GarmenFactory {
    public Top createTop() {
        return new Sweater();
    }
    public Underside createUnderside() {
        return new Trousers();
    }
    public Footwear createFootwear() {
        return new Boots();
    }
}

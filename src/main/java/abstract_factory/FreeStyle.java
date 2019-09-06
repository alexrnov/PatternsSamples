package abstract_factory;

/**
 * абстактная фабрика - создает группу взаимосвязанных объектов одежды,
 * представляющую собой свободный стиль
 */
public class FreeStyle implements GarmenFactory {
    public Top createTop() {
        return new Singlet();
    }
    public Underside createUnderside() {
        return new Shorts();
    }
    public Footwear createFootwear() {
        return new Sandals();
    }
}

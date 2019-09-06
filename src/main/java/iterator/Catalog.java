package iterator;

import java.util.Iterator;

/**
 * Интерфейс должен реализовать только один метод, возвращающий
 * итератор.
 */
public interface Catalog {
    public Iterator createIterator();
}

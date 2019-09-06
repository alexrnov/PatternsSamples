package iterator;


import java.util.Arrays;
import java.util.Iterator;

/**
 * Пользовательский итератор для набора обуви. Поскольку набор обуви
 * хранится в массиве, то для перебора его элементов необходимо создать
 * собственный итератор, переопределяющий методы next(), hasNext() и remove()
 * интерфейса Iterator.
 */
public class FootwearIterator implements Iterator {

    private Merchandise[] items;
    private int position = 0;

    public FootwearIterator(Merchandise[] items) {
        this.items = items;
    }

    @Override
    public Object next() {
        Merchandise item = items[position];
        position = position + 1;
        return item;
    }

    @Override
    public boolean hasNext() {
        if (position >= items.length || items[position] == null) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public void remove() {
        if (position <= 0) {
            throw new IllegalStateException
                    ("you can't remove an item until you've done at last one next()");
        }
        items = Arrays.copyOfRange(items, position, (items.length-1));
        position = 0;
    }
}

package iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Класс реализует набор одежды
 */
public class Clothes implements Catalog {

    private List<Merchandise> items;

    public Clothes() {
        items = new ArrayList<>();
        addItem("shirt", "black shirt", 90);
        addItem("shirt", "green shirt", 89);
        addItem("shirt", "yellow shirt", 70);
        addItem("shirt", "white shirt", 95);
    }

    public void addItem(String name, String description, double price) {
        Merchandise item = new Merchandise(name, description, price);
        items.add(item);
    }

    /**
     * Возвращать пользовательский итератор нет необходимости, поскольку
     * класс коллекции ArrayList() и так возвращает итератор.
     * @return Итератор для коллекции одежды
     */
    @Override
    public Iterator createIterator() {
        return items.iterator();
    }
}

package iterator;

import java.util.Iterator;

/**
 * Класс реализует набор обуви
 */
public class Footwear implements Catalog {

    private static final int MAX_ITEMS = 6;
    private int numberOfItems = 0;
    private Merchandise[] items; //для хранения обуви используется массив

    public Footwear() {
        items = new Merchandise[MAX_ITEMS];
        addItem("snickers", "red snickers", 100);
        addItem("snickers", "grey snickers", 200);
        addItem("snickers", "black snickers", 60);
        addItem("snickers", "white snickers", 80);
    }

    public void addItem(String name, String description, double price) {
        Merchandise item = new Merchandise(name, description, price);
        if (numberOfItems >= MAX_ITEMS) {
            System.out.println("List is full. Can't add item to list");
        } else {
            items[numberOfItems] = item;
            numberOfItems++;
        }
    }

    /**
     * Реализация метода, возвращающего итератор для набора обуви
     * @return итератор для набора обуви
     */
    @Override
    public Iterator createIterator() {
        return new FootwearIterator(items);
    }
}

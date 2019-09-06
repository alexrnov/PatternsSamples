package iterator;

/*
Класс реализует представление товара
 */
public class Merchandise {

    public String name;
    public String description;
    public double price;

    public Merchandise(String name, String description, double price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }

    @Override
    public String toString() {
        return "name: " + name + ", description:" + description
                + ", price: " + price;
    }
}

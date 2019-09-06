package iterator;

import java.util.Iterator;

/**
 * Демонстрация паттерна итератор
 * Паттерн ИТЕРАТОР представляет механизм последовательного перебора
 * элементов коллекции без раскрытия ее внутреннего представления.
 */
public class Main {
    public static void main(String[] args) {
        Catalog clothes = new Clothes();//набор одежды
        Catalog footwear = new Footwear();//набор обуви
        Iterator clothesIterator = clothes.createIterator();
        Iterator footwearIterator = footwear.createIterator();
        System.out.println("Элементы одежды: ");
        printCatalog(clothesIterator);
        System.out.println("----------------------");
        System.out.println("Элементы обуви: ");
        printCatalog(footwearIterator);

        //перебрать первые три элемента одежды и обуви
        clothesIterator = clothes.createIterator();
        footwearIterator = footwear.createIterator();
        for (int i = 0; i < 3; i++) {
            if (clothesIterator.hasNext()) {
                clothesIterator.next();
            }
            if (footwearIterator.hasNext()) {
                footwearIterator.next();
            }
        }
        clothesIterator.remove(); //удалить пройденные три элемента одежды
        footwearIterator.remove();//удалить пройденные три элемента обуви

        System.out.println("----------------------");
        System.out.println("Удаленить пройденные три элемента одежды ");
        System.out.println("Оставшийся элемент одежды: ");
        printCatalog(clothesIterator);

        System.out.println("----------------------");
        System.out.println("Удалить пройденные три элемента обуви ");
        System.out.println("Оставшийся элемент обуви: ");
        printCatalog(footwearIterator);
    }

    /**
     * Вывести элементы одежды и обуви
     * @param iterator
     */
    public static void printCatalog(Iterator iterator) {
        while (iterator.hasNext()) {
            Merchandise m = (Merchandise) iterator.next();
            System.out.println(m.toString());
        }
    }
}

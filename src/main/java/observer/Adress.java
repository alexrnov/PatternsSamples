package observer;

/**
 * Класс адресата, который выступает в роли наблюдателя,
 * принимая сообщения
 */
public class Adress implements Observer {

    private Observable mailer;
    private Message message;

    public Adress(Observable mailer) {
        this.mailer = mailer;
        mailer.registerObserver(this);
    }

    /**
     * Метот, через который адресат(наблюдатель) получает сообщение от
     * наблюдаемого объекта
     * @param message полученное сообщение
     */
    @Override
    public void update(Message message) {
        this.message = message;
    }

    public void display() {
        if (message == null) {
            System.out.println("no data");
        } else {
            System.out.println(message.getText());
        }
    }
}

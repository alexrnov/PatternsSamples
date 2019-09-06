package observer;

/**
 * класс сообщения, экземпляры которого отправляет mailer
 * адресатам(наблюдателям)
 */
public class Message {
    private String text;
    public Message(String text) {
        this.text = text;
    }
    public String getText() {
        return text;
    }
}

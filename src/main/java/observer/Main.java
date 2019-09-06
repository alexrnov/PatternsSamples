package observer;

/**
 * На примере организации рассылки сообщений демонстрируется паттерн
 * НАБЛЮДАТЕЛЬ. Паттерн НАБЛЮДАТЕЛЬ определяет отношение "один-ко-многим"
 * между объектами таким образом, что при изменении состояния одного
 * объекта происходит автоматическое оповещение и обновление всех зависимых объектов.
 */
public class Main {
    public static void main(String[] args) {
        Mailer mailer = new Mailer(); //рассылатель писем (наблюдаемый объект)
        Adress adress1 = new Adress(mailer); //первый адресат (наблюдатель)
        Adress adress2 = new Adress(mailer); //второй адресат
        //разослать сообщение (изменяется наблюдаемый объект)
        mailer.setMessage(new Message("text"));
        mailer.setChanged(); //установить изменение (триггер)
        mailer.notifyObservers(); //оповестить наблюдателей
        System.out.print("Первый адресат получил сообщение: ");
        adress1.display();
        System.out.print("Второй адресат получил сообщение: ");
        adress2.display();
        System.out.println("-------------------");
        mailer.removeObserver(adress1); //первый адресат удален из списка наблюдателей
        //разослать сообщение (изменяется наблюдаемый объект)
        mailer.setMessage(new Message("new text"));
        //если не вызвать этот метод, оповещения не произойдет
        mailer.setChanged();
        mailer.notifyObservers();
        System.out.println("Первый адресат больше не получает сообщений");
        System.out.print("поэтому он хранит старое сообщение: ");
        adress1.display();
        System.out.println("единственный адресат, который до этого был вторым,");
        System.out.print("получил новое сообщение: ");
        adress2.display();
    }
}

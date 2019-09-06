package command;

/**
 * Интерфейс, который предоставляет паттерн КОМАНДА.
 */
public interface Command {
    void execute();//выполнить команду
    void undo();//отменить команду
}

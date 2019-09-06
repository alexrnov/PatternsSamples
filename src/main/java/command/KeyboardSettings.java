package command;

import java.util.HashMap;
import java.util.Map;

/**
 * Настройки клавиатуры для некоторых кнопок
 */
public class KeyboardSettings {
    private Map<String, Command> commands = new HashMap<>();

    /**
     * Конструктор задает кнопкам пустые команды по умолчанию
     */
    public KeyboardSettings() {
        Command noCommand = new NoCommand();
        commands.put("a", noCommand);
        commands.put("w", noCommand);
        commands.put("s", noCommand);
        commands.put("d", noCommand);
        commands.put("+", noCommand);
        commands.put("-", noCommand);
    }

    /**
     * Задать кнопке команду
     * @param button кнопка
     * @param command команда для кнопки
     */
    public void setCommand(String button, Command command) {
        delExistingCommand(command);
        commands.put(button, command);
    }

    /**
     * Удаляет команду
     * @param command команда для удаления
     */
    private void delExistingCommand(Command command) {
        commands.forEach((k, v) -> {
            if (v.equals(command)) {
                commands.put(k, new NoCommand());
                System.out.println("Delete existing command");
            }
        });
    }

    /**
     * Выполняет команду после нажатия кнопки
     * @param button нажатая кнопка
     */
    public void buttonOnClick(String button) {
        Command currentCommand = commands.get(button);
        currentCommand.execute();//выполнить команду
    }

    /**
     * Отменяет команду после нажатия кнопки
     * @param button нажатая кнопка
     */
    public void buttonOffClick(String button) {
        Command currentCommand = commands.get(button);
        currentCommand.undo();//отменить команду
    }
}

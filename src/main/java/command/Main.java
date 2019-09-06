package command;

/**
 * На примере задания раскладки клавиатуры демонстрируется принцип работы
 * паттерна КОМАНДА. Паттерн КОМАНДА инкапсулирует запрос в виде объекта,
 * делая возможной параметризацию клиентских объектов с
 * другими запросами, организацию очереди или регистрацию запросов,
 * а также поддержку отмены операций.
 *
 * Паттерн МАКРОКОМАНДА простое расширение паттерна КОМАНДА,
 * позволяющее выполнять цепочки из нескольких команд.
 * В них также легко реализуется механизм отмены.
 */
public class Main {
    public static void main(String[] args) {
        KeyboardSettings keys = new KeyboardSettings(); //раскладка клавиатуры
        Camera camera = new Camera();//игровая камера
        //создание команд для игровой камеры
        CameraRightCommand right = new CameraRightCommand(camera);
        CameraLeftCommand left = new CameraLeftCommand(camera);
        CameraUpCommand up = new CameraUpCommand(camera);
        CameraDownCommand down = new CameraDownCommand(camera);
        //задать команды для определенных кнопок
        //(в случае использования макрокоманд, передается
        //объект, содержащий массив комманд)
        keys.setCommand("d", right);
        keys.setCommand("a", left);
        keys.setCommand("w", up);
        keys.setCommand("s", down);
        keys.buttonOnClick("a");
        keys.buttonOffClick("a");
        System.out.println("--------------------------");
        keys.buttonOffClick("d");
        System.out.println("--------------------------");
        keys.buttonOnClick("w");
        keys.buttonOffClick("w");
        System.out.println("--------------------------");

        GameProcess gameProcess = new GameProcess();//игровой процесс
        //создание команд для изменения темпа времени игрового процесса
        GameReduceCommand reduce = new GameReduceCommand(gameProcess);
        GameEnhanceCommand enhance = new GameEnhanceCommand(gameProcess);
        GameStopCommand stop = new GameStopCommand(gameProcess);
        //задать команды для кнопок
        keys.setCommand("+", enhance);
        keys.setCommand("-", reduce);
        keys.setCommand("p", stop);
        System.out.println("--------------------------");
        System.out.println("Увеличивать скорость игры: ");
        keys.buttonOnClick("+");
        keys.buttonOnClick("+");
        System.out.println("Замедлять скорость игры: ");
        keys.buttonOnClick("-");
        keys.buttonOnClick("-");
        keys.buttonOnClick("-");
        keys.buttonOnClick("-");
        keys.buttonOnClick("-");
        System.out.println("Увеличивать скорость игры: ");
        keys.buttonOnClick("+");
        keys.buttonOnClick("+");
        keys.buttonOnClick("+");
        System.out.println("Остановить игру: ");
        keys.buttonOnClick("p");
        System.out.println("Увеличивать скорость игры: ");
        keys.buttonOnClick("+");
        System.out.println("-------------------------");
        //для команды назначается новая кнопка
        System.out.println("assign new command for key: ");
        keys.setCommand("+", up);
        keys.buttonOnClick("+");
        keys.buttonOffClick("+");
        //для кнопки "w" команда была удалена
        System.out.println("-------------------");
        keys.buttonOnClick("w");
        keys.buttonOffClick("w");
    }
}

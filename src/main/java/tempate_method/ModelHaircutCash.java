package tempate_method;

/**
 * Определяет подробности алгоритма для модельной стрижки
 */
public class ModelHaircutCash extends Haircut {

    /*
     * Переопределить метод-перехватчик, добавляющий в общий алгоритм
     * стрижки мытье головы
     */
    @Override
    public boolean interceptorNeedWachHead() {
        return true;
    }

    /*
     * Реализация алгоритма стрижки волос для модельной стрижки
     */
    @Override
    public void cut() {
        System.out.println("take scissors");
        System.out.println("cut");
        System.out.println("put scissors");
    }
}

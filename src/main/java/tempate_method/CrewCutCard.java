package tempate_method;

/**
 * Определяет подробности алгоритма для стрижки волос под машинку
 */
public class CrewCutCard extends Haircut {

    /*
     * Реализация алгоритма стрижки волос для стрижки под машинку
     */
    @Override
    public void cut() {
        System.out.println("take hair cutting machine");
        System.out.println("cut");
        System.out.println("put hair cutting machine");
    }

    /*
     * Переопределить метод-перехватчик, меняющий общий алгоритм,
     * и изменяющий способ оплаты на наличный расчет
     */
    public boolean interceptorIsPaymentInCash() {
        return false;
    }
}

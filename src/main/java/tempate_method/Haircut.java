package tempate_method;

/**
 * стрижка: класс определяет общую последовательность стрижки
 */
public abstract class Haircut {
    //скелет алгоритма задается в методе, объявленном как final.
    //это гарантирует неизменяемость его общей структуры

    /**
     * Выполнить алгоритм (стрижку)
     */
    public final void perform() {
        toSetTheClient();//посадить клиента (метод реализован в этом абстрактном классе)
        //метод-перехватчик (реализован в этом абстрактном классе, но может быть
        //переопределен в субклассах)
        if (interceptorNeedWachHead()) { // нужно ли мыть голову (по умолчанию не нужно)
            washHead();//помыть голову (метод реализован в этом абстрактном классе)
        }
        cut();//абстрактный метод, переопределяемый в субклассах
        //метод-перехватчик (реализован в этом абстрактном классе, но может быть
        //переопределен в субклассах)
        if (interceptorIsPaymentInCash()) { //расплачивается ли клиент картой(по умолчанию - да)
            paymentInCash();//расплатиться по карте (метод реализован в этом абстрактном классе)
        } else {
            paymentCard();//расплатиться наличными (метод реализован в этом абстрактном классе)
        }
    }
    public final void toSetTheClient() {
        System.out.println("To set the client");
    }

    /**
     * метод-перехватчик; может быть переопределен в субклассе
     */
    public boolean interceptorNeedWachHead() {
        return false;
    }
    public final void washHead() {
        System.out.println("wash a head");
    }
    public abstract void cut();

    /**
     * метод-перехватчик; может быть переопределен в субклассе
     */
    public boolean interceptorIsPaymentInCash() {
        return true;
    }

    public final void paymentInCash() {
        System.out.println("payment in cash");
    }

    public final void paymentCard(){
        System.out.println("payment card");
    }
}

package adapter;

/**
 * Адаптер, позволяющий рассматривать старый кнопочный мобильный
 * телефон motorola на ряду с современными смартфонами
 */
//реализуется тот интерфейс, для которого создается адаптер,
//в данном случае это SmartPhone
public class MobilePhoneAdapter implements SmartPhone {
    private MobilePhone mobilePhone;//хранится ссылка на адаптируемый объект

    public MobilePhoneAdapter(MobilePhone mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    @Override
    public void pressTouchScreen() { //переопределяется метод тачскрина
        mobilePhone.pressKey(); //вместо нажатия по экрану используется нажатие кнопки
    }

    @Override
    public void cellUp() { //переопределяется метод звонка
        mobilePhone.cellUp();
    }

    @Override
    public void photograph() { //переопределяется метод фотографии
        mobilePhone.photograph();
    }

    //данная функция не поддерживается для кнопочных телефонов
    @Override
    public void changeOrientationDisplay() {
        System.out.println("do not change orientation display");
    }
}

package Package;

public class GoldFish extends Fish {
    @Override
    public void sound() {
        System.out.println("Буль-Буль");
    }

    @Override
    public final void skin() {
        System.out.println("У меня золотая чешуя");
    }

    @Override
    public final void swimming() {
        System.out.println("Я плаваю медленно");
    }

    @Override
    public final void wayToBirth() {
        System.out.println("Я метаю икру");
    }
}

package Package;

public class Eagle extends Bird implements Flying {
    @Override
    public void fly() {
        System.out.println("Я летаю быстро");
    }

    @Override
    public void sound() {
        System.out.println("Свист");
    }

    @Override
    public void skin() {
        System.out.println("У меня красивые перья");
    }

    @Override
    public void wayToBirth() {
        System.out.println("Я откладываю яйца");
    }
}

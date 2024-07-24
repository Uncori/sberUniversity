package Package;

public class Bat extends Mammal implements Flying {

    @Override
    public void fly() {
        System.out.println("Я летаю медленно");
    }

    @Override
    public void sound() {
        System.out.println("Пииип-Пииип");
    }

    @Override
    public void skin() {
        System.out.println("У меня густая и короткая шерсть");
    }

    @Override
    public void wayToBirth() {
        System.out.println("Я живородящие, вскармливание детёнышей молоком");
    }
}

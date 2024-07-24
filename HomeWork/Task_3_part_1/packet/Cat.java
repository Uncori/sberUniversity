package packet;

import java.util.Random;

public class Cat {
    private void sleep() {
        System.out.println("Sleep");
    }

    private void meow() {
        System.out.println("Meow");
    }

    private void eat() {
        System.out.println("Eat");
    }

    public void status() {
        Random generator = new Random();
        int random = generator.nextInt(3);
        if (random == 0) {
            sleep();
        } else if (random == 1) {
            meow();
        } else {
            eat();
        }
    }
}

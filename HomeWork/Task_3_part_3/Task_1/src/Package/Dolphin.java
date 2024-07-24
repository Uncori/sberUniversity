package Package;

public class Dolphin extends Fish {
    @Override
    public void skin() {
        System.out.println("У меня нет чешуи, вместо этого у меня гладкая и нежной кожа");
    }

    @Override
    public void swimming() {
        System.out.println("Я плаваю быстро");
    }

    @Override
    public void wayToBirth() {
        System.out.println("Я живородящие, вскармливание детёнышей молоком");
    }

    @Override
    public void sound() {
        System.out.println("Пиииииии....");
    }
}

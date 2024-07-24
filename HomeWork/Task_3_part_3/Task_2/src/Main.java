import Package.*;

public class Main {
    public static void main(String[] args) {
        Furniture a = new Stool();
        Furniture b = new Table();
        System.out.println(BestCarpenterEver.checkFurniture(a));
        System.out.println(BestCarpenterEver.checkFurniture(b));
    }
}
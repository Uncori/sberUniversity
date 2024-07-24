package Task_1;

import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;

public class Test_MyCheckedException {
    public static void main(String[] args) throws MyCheckedException {
        ArrayList<String> lines = new ArrayList<>();

        try (Scanner scanner = new Scanner(new File("input.txt"))) {
            while (scanner.hasNextLine()) {
                lines.add(scanner.nextLine());
            }
            for (String line : lines) {
                System.out.println("LINE: " + line);
            }
        } catch (FileNotFoundException e) {
            throw new MyCheckedException("ERROR " + e.getMessage());
        }
    }
}

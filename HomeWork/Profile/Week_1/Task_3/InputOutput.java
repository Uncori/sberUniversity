package Task_3;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;


public class InputOutput {
    // использовал относительный путь для переносимости
    // private static final String PATH_TO_FILE = "HomeWork/Taks_1(Profile)/exception/Test.txt";
    private static final String PATH_TO_FILE = "HomeWork/Profile/exception/InputOutput.java";
    private static final String OUTPUT_FILE = "HomeWork/Profile/hello.txt";

    public static void main(String[] args) throws IOException {
        fileReader();
    }

    private static void deleteFile(File deletePath) {
        if (deletePath.delete()) {
            System.out.println("LOG: " + OUTPUT_FILE + " удалён");
        } else {
            System.out.println("LOG: " + OUTPUT_FILE + " не обнаружен");
        }
    }

    private static void fileReader() throws IOException {
        File newFile = new File(OUTPUT_FILE);
        try {
            if (newFile.createNewFile()) {
                System.out.println("LOG: Файл уже создан");
            } else {
                System.out.println("LOG: Файл создан");
            }
        } catch (IOException e) {
            System.out.println("LOG: " + e.getMessage());
        }

        ArrayList<String> lines = new ArrayList<>();

        try (FileReader reader = new FileReader(PATH_TO_FILE); Scanner scanner = new Scanner(reader)) {
            while (scanner.hasNextLine()) {
                lines.add(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println("LOG: " + e.getMessage());
        }

        try (Writer wr = new FileWriter(OUTPUT_FILE)) {
            for (String line : lines) {
                char[] result = line.toCharArray();
                for (int i = 0; i < result.length; ++i) {
                    if (Character.isLetter(result[i])) {
                        if (result[i] >= 'a' && result[i] <= 'z') {
                            result[i] = (char) (result[i] - 32);
                        }
                    }
                }
                line = new String(result);
                System.out.println("LINE = " + line);
                wr.write(line + '\n');
            }
        } catch (IOException e) {
            System.out.println("LOG: " + e.getMessage());
        }
        if (newFile.isFile()) {
            System.out.println("Для удаления файла -  " + OUTPUT_FILE + " Введите Y");
            try (Scanner scanner = new Scanner(System.in)) {
                String answer = scanner.next();
                if (answer.length() == 1 && answer.charAt(0) == 'Y') {
                    deleteFile(newFile);
                } else {
                    System.out.println("LOG: Файл сохранён");
                }
            } catch (RuntimeException e) {
                System.out.println("LOG: " + e.getMessage());
            }
        }
    }

}

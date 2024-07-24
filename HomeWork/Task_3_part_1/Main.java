import packet.*;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // test class Cat method status with default constructor
        Cat cat = new Cat();
        cat.status();
        System.out.println("----------------------------------");
        // test class Student
        Student student = new Student();
        student.setName("Petya");
        student.setSurname("Ivanov");
        int[] grades2 = {2, 3, 4};
        student.setGrades(grades2);
        int[] grades3 = {1, 5, 5, 5, 1};
        student.setGrades(grades3);
        int[] grades = {1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 5, 2, 2, 2, 2};
        student.setGrades(grades);
        int[] getGrades = student.getGrades();
        System.out.println(Arrays.toString(getGrades));
        // test input grades and shift array grades
        Scanner input = new Scanner(System.in);
//        for (int i = 0; i < 8; ++i) {
//            int grad = input.nextInt();
//            student.setGrades(grad);
//            System.out.println(Arrays.toString(getGrades));
//        }
        //outputAllInfo
        student.getInfoStudent();
        System.out.println("\n----------------------------------");
        //test StudentService
        Student[] students = new Student[4];
        for (int i = 0; i < students.length; ++i) {
            students[i] = new Student();
        }

        int[] gradesFirstStudent = {3, 4, 4, 5, 2, 1, 4, 5, 3, 5};
        int[] gradesSecondStudent = {2, 3, 4, 4, 2, 2, 5, 5, 5, 5};
        int[] gradesThirdStudent = {4, 5, 5, 3, 2, 2, 3, 4, 5, 5};
        int[] gradesFourStudent = {4, 5, 5, 1, 2, 2, 3, 4, 5, 5};

        students[0].setGrades(gradesFirstStudent);
        students[1].setGrades(gradesSecondStudent);
        students[2].setGrades(gradesThirdStudent);
        students[3].setGrades(gradesFourStudent);

        students[0].setName("Petya");
        students[1].setName("Vova");
        students[2].setName("Jora");
        students[3].setName("Olya");

        students[0].setSurname("Ivanov");
        students[1].setSurname("Cherkasov");
        students[2].setSurname("Kim");
        students[3].setSurname("Autobest");

        System.out.println("averageScore " + students[0].getName() + " = " + students[0].getAverageScore());
        System.out.println("averageScore " + students[1].getName() + " = " + students[1].getAverageScore());
        System.out.println("averageScore " + students[2].getName() + " = " + students[2].getAverageScore());
        System.out.println("averageScore " + students[3].getName() + " = " + students[3].getAverageScore());

        Student bestStudent = StudentService.bestStudent(students);
        System.out.println("bestAverage " + bestStudent.getName() + " = " + bestStudent.getAverageScore());

        // test sort(a.k.a bubble sort)
        StudentService.sortBySurname(students);

        System.out.println("0 = " + students[0].getSurname());
        System.out.println("1 = " + students[1].getSurname());
        System.out.println("2 = " + students[2].getSurname());
        System.out.println("3 = " + students[3].getSurname());

        // test TimeUnit
        System.out.println("\n----------------------------------");
        TimeUnit time = new TimeUnit(23, 65, 67);
        time.printTwentyFourFormat();
        time.printTwelveFormat();
        TimeUnit time_two = new TimeUnit(24, 65);
        time_two.printTwentyFourFormat();
        time_two.printTwelveFormat();
        TimeUnit time_three = new TimeUnit(65);
        time_three.printTwentyFourFormat();
        time_three.printTwelveFormat();
        // test DayOfWeek
        System.out.println("\n----------------------------------");
        DayOfWeek[] weekArray = new DayOfWeek[7];
        String[] weekName = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
        for (int i = 0; i < weekArray.length; ++i) {
            weekArray[i] = new DayOfWeek((byte) (i + 1), weekName[i]);
        }
        for (DayOfWeek dayOfWeek : weekArray) {
            System.out.println(dayOfWeek.getDay() + " " + dayOfWeek.getWeekDay());
        }
        // test AmazingString
        System.out.println("\n----------------------------------");
        AmazingString str = new AmazingString(new char[]{'a', 'b', 'f', 'f', 'b', 's'});
        AmazingString surprise = new AmazingString("    Hello, Fry");
        System.out.println(str.getChar(3) + " " + surprise.getChar(5));
        System.out.println(str.getLength() + " " + surprise.getLength());
        str.output();
        System.out.println();
        surprise.output();
        System.out.println();
        System.out.println(str.subArray(new char[]{'b', 'f', 'f'}));
        System.out.println(str.subString("bs"));
        System.out.println("Len = " + surprise.getLength());
        surprise.arrayTrim();
        System.out.println("Len = " + surprise.getLength());
        surprise.output();
        System.out.println();
        surprise.reverse();
        surprise.output();
        // test TriangleChecker
        System.out.println("\n----------------------------------");
        System.out.println(TriangleChecker.checkTriangle(8.4123, 9.0123, 50.5123123));
        System.out.println(TriangleChecker.checkTriangle(5.312312312312312, 4.31, 8.12));
        // test Atm
        System.out.println("\n----------------------------------");
        Atm dollar = new Atm(73.11, "dollar");
        Atm ruble = new Atm(0.014, "ruble");
//        System.out.println(ruble.transferDollar(2));
        System.out.println(ruble.transferRubbles(2));
        System.out.println(dollar.transferDollar(2));
//        System.out.println(dollar.transferRubbles(2));


    }
}


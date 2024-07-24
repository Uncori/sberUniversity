package packet;

import java.util.Arrays;

public class Student {
    // null
    private String name, surname;
    // 0
    private int[] grades = new int[10];
    private int countGrades;

//    public Student() {
//        name = "None";
//        surname = "None";
//        countGrades = 0;
//        Arrays.fill(grades, 0);
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String name) {
        this.surname = name;
    }

    public int[] getGrades() {
        return grades;
    }

    public int getGradesForIndex(int index) {
        if (index > 0 && index < 11) {
            return grades[index - 1];
        } else {
            return -1;
        }
    }

    public void setGrades(int[] grades) {
        if (grades.length > 10) {
            for (int i = grades.length - 10; i < grades.length; ++i) {
                setGrades(grades[i]);
            }
        } else {
            for (int grade : grades) {
                setGrades(grade);
            }
        }
        // считаю такой способ не правильным из за условия что должно быть 10 элементов
        // а мы можем передать ссылку на любое количество
        //            this.grades = grades;
    }

    public void setGrades(int grade) {
        if (countGrades == 10) {
            for (int i = 0; i < this.grades.length - 1; ++i) {
                this.grades[i] = this.grades[i + 1];
            }
            this.grades[this.grades.length - 1] = grade;
        } else {
            this.grades[countGrades] = grade;
            ++countGrades;
        }
    }

    public void getInfoStudent() {
        System.out.println("Name = " + this.name);
        System.out.println("Surname = " + this.surname);
        for (int grad : grades) {
            System.out.print(grad + " ");
        }
        System.out.println("\nAverageScore = " + getAverageScore());
    }

    public double getAverageScore() {
        int sum = Arrays.stream(this.grades).sum();
        return (double) ((sum * 10 / 10)) / 10.0;
    }

}

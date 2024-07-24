package Package;

import java.util.Arrays;

public class Participant implements Comparable<Participant> {
    private String name;
    private double[] grades;

    private double res;
    private Dog dog;

    public Participant() {
        this.grades = new double[3];
    }

    public Participant(String name, Dog dog) {
        this();
        this.name = name;
        this.dog = dog;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getRes() {
        return res;
    }

    private void findRes() {
        double tmp = Arrays.stream(this.grades).sum();
        res = Math.floor((tmp / 3) * 10.0) / 10.0;
    }

    public void setGrades(double[] grades) {
        if (grades.length == 3) {
            this.grades = grades;
            findRes();
        } else {
            System.out.println("Много оценок!\n Макс. кол-во оценок - 3");
        }
    }

    public void setGrades(int index, double grade) {
        if (index >= 1 && index <= 3) {
            grades[index - 1] = grade;
            findRes();
        } else {
            System.out.println("Введите значение index 1-3");
        }
    }

    public void setDog(Dog dog) {
        this.dog = dog;
    }

    public String getName() {
        return name;
    }

    public double[] getGrades() {
        return grades;
    }

    public int getGradesLen() {
        return grades.length;
    }

    public double getGrade(int index) {
        if (index >= 1 && index <= 3) {
            return grades[index - 1];
        } else {
            System.out.println("Введите значение index 1-3");
            return 0;
        }
    }

    public Dog getDog() {
        return dog;
    }

    @Override
    public int compareTo(Participant o) {
        return (int) (this.getRes() - o.getRes());
    }

    @Override
    public String toString() {
        return this.getName() + ": " + this.getDog().getName() + ", " + this.getRes();
    }

}

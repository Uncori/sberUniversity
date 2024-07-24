package Packet;

import java.util.Arrays;

public class Book {
    // имя автор жанр
    private String name, author, genre;

    private Visitor visitor;
    // занята кол-во оценок
    private int countGrades;
    private boolean busy;
    private int[] grades = new int[10];

    public Book() {

    }

    public Book(String name, String author, String genre) {
        this.name = name;
        this.author = author;
        this.genre = genre;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public String getGenre() {
        return genre;
    }

    public boolean getBusy() {
        return busy;
    }

    public Visitor getVisitor() {
        return visitor;
    }

    // если нужно изменить имя, автора, жанр книги
    public void setName(String name) {
        this.name = name;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setVisitor(Visitor visitor) {
        this.visitor = visitor;
    }

    public void setBusy(boolean busy) {
        this.busy = busy;
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

    public double getGrades() {
        int sum = Arrays.stream(this.grades).sum();
        return (double) ((sum * 10)) / 10.0;
    }
}

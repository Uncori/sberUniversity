package Packet;

import java.util.Arrays;
import java.util.Scanner;
import java.util.SimpleTimeZone;

public class Library {

    private int countBook, countVisitors;
    private String name;
    private Book[] books;
    private Visitor[] visitors;

    public Library() {
        this.visitors = new Visitor[5];
        this.books = new Book[5];
    }

    public Library(String name) {
        this.name = name;
    }

    public Library(String name, int countBook, int countVisitors) {
        this(countBook, countVisitors);
        this.name = name;
    }

    public Library(int countBook, int countVisitors) {
        this.books = new Book[countBook];
        this.visitors = new Visitor[countVisitors];
    }


    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCountBook() {
        return this.countBook;
    }

    public int getCountVisitors() {
        return this.countVisitors;
    }

    public int getBooksLength() {
        return this.books.length;
    }

    public int getVisitorsLength() {
        return this.visitors.length;
    }

    public int searchBook(String name) {
        int index = -1;
        for (int i = 0; i < this.books.length; ++i) {
            if (this.books[i] != null) {
                if (this.books[i].getName().equalsIgnoreCase(name)) {
                    index = i;
                    break;
                }
            }
        }
        return index;
    }


    public int searchBook(String name, String author) {
        int index = -1;
        for (int i = 0; i < this.books.length; ++i) {
            if (this.books[i] != null) {
                if (this.books[i].getName().equalsIgnoreCase(name)) {
                    if (this.books[i].getAuthor().equalsIgnoreCase(author)) {
                        index = i;
                        break;
                    }
                }
            }
        }
        return index;
    }

    private int searchEmptyPlace() {
        int index = -1;
        for (int i = 0; i < this.books.length; ++i) {
            if (this.books[i] == null) {
                index = i;
                break;
            }
        }
        return index;
    }

    public void setBook(Book book) {
        setBook(book.getName(), book.getAuthor(), book.getGenre());
    }

    public void setBook(String name, String author, String genre) {
        int indexBook = searchBook(name, author);
        if (indexBook == -1) {
            if (this.countBook != this.books.length) {
                int index = searchEmptyPlace();
                this.books[index] = new Book(name, author, genre);
                ++this.countBook;
            } else {
                System.out.println("Полки забиты");
            }
        } else if (this.books[indexBook].getBusy()) {
            System.out.println("Такая книга у нас есть и её сейчас читают");
        } else {
            System.out.println("Такая книга у нас есть");
        }

    }

    public void putBook(Book book) {
        putBook(book.getName(), book.getAuthor());
    }

    public void putBook(String name, String author) {
        int index = searchBook(name, author);
        if (index != -1) {
            if (!this.books[index].getBusy()) {
                this.books[index] = null;
                --this.countBook;
            } else {
                System.out.println("Нельзя удалить, книгу: " + this.books[index].getName() + " одолжили");
            }
        } else {
            System.out.println("Такой книги нет");
        }
    }

    private void inputInfo(Visitor visitor, Book book) {
        System.out.println("Книга есть в наличие");
        int index = searchVisitors(visitor.getName(), visitor.getSurname());
        if (index == -1) {
            System.out.println("Вас нет в базе, введите информацию о себе: ");
            String temp;
            Scanner input = new Scanner(System.in);
            System.out.print("Имя: ");
            temp = input.next();
            visitor.setName(temp);
            System.out.print("Фамилия: ");
            temp = input.next();
            visitor.setSurname(temp);
            System.out.print("Номер телефона: ");
            temp = input.next();
            visitor.setPhone(temp);
            System.out.print("Email: ");
            temp = input.next();
            visitor.setEmail(temp);
            visitor.setIdentifier(countVisitors);
            visitor.setHaveBook(true);
            visitor.upAppeals();
            visitor.setBook(book);
            book.setBusy(true);
            System.out.println("Ваш идентификатор: " + visitor.getIdentifier());
            this.visitors[countVisitors] = visitor;
            ++this.countVisitors;
        } else if (this.visitors[index].getHaveBook()) {
            visitor = this.visitors[index];
            System.out.println("У Вас уже есть книга: " + this.visitors[index].getBook().getName());
        } else {
            System.out.println("Вы есть у нас в базе");
            visitor = this.visitors[index];
        }
    }

    private Visitor inputInfo(Book book) {
        System.out.println("Книга есть в наличие, введите информацию о себе: ");
        Visitor tmpVisitor = new Visitor();
        String temp;
        Scanner input = new Scanner(System.in);
        System.out.print("Имя: ");
        temp = input.next();
        tmpVisitor.setName(temp);
        System.out.print("Фамилия: ");
        temp = input.next();
        tmpVisitor.setSurname(temp);
        int index = searchVisitors(tmpVisitor.getName(), tmpVisitor.getSurname());
        if (index == -1) {
            System.out.print("Номер телефона: ");
            temp = input.next();
            tmpVisitor.setPhone(temp);
            System.out.print("Email: ");
            temp = input.next();
            tmpVisitor.setEmail(temp);
            tmpVisitor.setIdentifier(countVisitors);
            tmpVisitor.setHaveBook(true);
            tmpVisitor.upAppeals();
            tmpVisitor.setBook(book);
            book.setBusy(true);
            System.out.println("Ваш идентификатор: " + tmpVisitor.getIdentifier());
            this.visitors[countVisitors] = tmpVisitor;
            ++this.countVisitors;
        } else if (this.visitors[index].getHaveBook()) {
            tmpVisitor = this.visitors[index];
            System.out.println("У Вас уже есть книга: " + this.visitors[index].getBook().getName());
        } else {
            System.out.println("Вы есть у нас в базе");
            tmpVisitor = this.visitors[index];
        }

        return tmpVisitor;
    }

    private int searchVisitors(String name, String surname) {
        int index = -1;
        for (int i = 0; i < this.visitors.length; ++i) {
            if (this.visitors[i] != null) {
                if (this.visitors[i].getName().equalsIgnoreCase(name)) {
                    if (this.visitors[i].getSurname().equalsIgnoreCase(surname)) {
                        index = i;
                        break;
                    }
                }
            }
        }
        return index;
    }

    public void takeBook(Visitor visitor, String name) {
        int index = searchBook(name);
        if (index != -1) {
            if (!this.books[index].getBusy()) {
                inputInfo(visitor, this.books[index]);
                this.books[index].setVisitor(visitor);
            } else {
                System.out.println("Книгу взяли");
            }
        } else {
            System.out.println("У нас нет такой книги");
        }
    }

    public Book takeBook(String name) {
        Book res = null;
        int index = searchBook(name);
        if (index != -1) {
            if (!this.books[index].getBusy()) {
                this.books[index].setVisitor(inputInfo(this.books[index]));
                res = this.books[index];
            } else {
                System.out.println("Книгу взяли");
            }
        } else {
            System.out.println("У нас нет такой книги");
        }
        return res;
    }

    public Book takeBook(String name, String author) {
        Book res = null;
        int index = searchBook(name, author);
        if (index != -1) {
            if (!this.books[index].getBusy()) {
                this.books[index].setVisitor(inputInfo(this.books[index]));
                res = this.books[index];
            } else {
                System.out.println("Книгу взяли");
            }
        } else {
            System.out.println("У нас нет такой книги");
        }
        return res;
    }

    public Book getBook(String name) {
        Book tmp;
        int index = searchBook(name);
        if (index != -1) {
            tmp = this.books[index];
        } else {
            tmp = null;
        }
        return tmp;
    }

    public Book getBook(String name, String author) {
        Book tmp;
        int index = searchBook(name, author);
        if (index != -1) {
            tmp = this.books[index];
        } else {
            tmp = null;
        }
        return tmp;
    }

    private int countBookByAuthor(String author) {
        int count = 0;
        for (int i = 0; i < this.visitors.length; ++i) {
            if (this.books[i] != null && this.books[i].getAuthor().equalsIgnoreCase(author)) {
                ++count;
            }
        }
        return count;
    }

    public Book[] getBooksByAuthor(String author) {
        Book[] book;
        int count = countBookByAuthor(author);
        if (count != 0) {
            book = new Book[count];
            for (int i = 0, j = 0; i < this.books.length; ++i) {
                if (this.books[i] != null && this.books[i].getAuthor().equalsIgnoreCase(author)) {
                    book[j] = this.books[i];
                    ++j;
                }
            }
        } else {
            System.out.println("Книги не найдены");
            book = null;
        }
        return book;
    }


    public void returnBook(Visitor visitor) {
        int index = searchBook(visitor.getBook().getName(), visitor.getBook().getAuthor());
        if (index != -1) {
            boolean checkName = this.books[index].getVisitor().getName().equalsIgnoreCase(visitor.getName());
            boolean checkSurname = this.books[index].getVisitor().getSurname().equalsIgnoreCase(visitor.getSurname());
            if (checkName && checkSurname) {
                System.out.println("Хотите оценить книгу (да/нет) ?");
                Scanner input = new Scanner(System.in);
                boolean res = false;
                while (!res) {
                    String tmp = input.next();
                    if (tmp.equalsIgnoreCase("да")) {
                        System.out.println("Укажите оценку от 1 до 5");
                        while (!res) {
                            int temp = input.nextInt();
                            if (temp >= 1 && temp <= 5) {
                                this.books[index].setGrades(temp);
                                System.out.println("Спасибо за отзыв!");
                                res = true;
                            } else {
                                System.out.println("Некорректный ввод");
                            }
                        }
                    } else if (tmp.equalsIgnoreCase("нет")) {
                        System.out.println("Это Ваше решение");
                        res = true;
                    } else {
                        System.out.println("Некорректный ввод");
                    }
                }
                int indexVisitor = searchVisitors(visitor.getName(), visitor.getSurname());
                this.visitors[indexVisitor].setBook(null);
                this.visitors[indexVisitor].setHaveBook(false);
                this.visitors[indexVisitor].downAppeals();
                this.books[index].setVisitor(null);
                this.books[index].setBusy(false);
            } else {
                System.out.println("Не вы брали эту книгу");
            }
        } else {
            System.out.println("Простите, это не наша книга");
        }
    }

    public double getGrades(String name) {
        double res = 0.0;
        int index = searchBook(name);
        if (index != -1) {
            res = this.books[index].getGrades();
        } else {
            System.out.println("Книга не найдена");
        }
        return res;
    }

}


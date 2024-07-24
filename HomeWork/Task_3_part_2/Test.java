import Packet.Book;
import Packet.Library;

public class Test {
    public static void main(String[] args) {
        Library libra = new Library();
        System.out.println("Макс кол-во книг " + libra.getBooksLength());
        System.out.println("Макс кол-во данных о посетителях " + libra.getVisitorsLength());
        libra.setBook("Жизнь насекомых", "Виктор Пелевин", "Роман");
        libra.setBook("Долгая прогулка", "Стивен Кинг", "Ужасы");
        libra.setBook("Снафф", "Чак Паланик", "Триллер");
        libra.setBook("Красивая жизнь", "Мэтью Стокоу", "Любовный роман");
        libra.setBook("Жизнь без людей", "Рэт Джеймс Уайт", "Ужасы");
        System.out.println("Кол-во книг сейчас " + libra.getCountBook());
        System.out.println("Кол-во посетителей в базе " + libra.getCountVisitors());
        // тест на добавление такой же книги
        libra.setBook("Снафф", "Чак Паланик", "Триллер");
        Book book = new Book("Снафф", "Чак Паланик", "Триллер");
        libra.setBook(book);
        // удалить книгу
        libra.putBook("Красивая жизнь", "Мэтью Стокоу");
        System.out.println("Кол-во книг сейчас " + libra.getCountBook());
        // добавить книгу через объект
        book = new Book("Красивая жизнь", "Мэтью Стокоу", "Любовный роман");
        libra.setBook(book);
        // Найти и вернуть книгу по названию
        book = libra.getBook("Снафф");
        System.out.println(book.getName() + " " + book.getAuthor() + " " + book.getGenre());
        book = libra.getBook("Снафф", "Чак Паланик");
        System.out.println(book.getName() + " " + book.getAuthor() + " " + book.getGenre());
        // Найти и вернуть список книг по автору
        Book[] books = libra.getBooksByAuthor("Виктор Пелевин");
        System.out.println("Найдено " + books.length + " книг");
        // взять книгу
        book = libra.takeBook("Красивая жизнь");
        System.out.println(book.getVisitor().getName());
        System.out.println(book.getVisitor().getSurname());
        System.out.println(book.getVisitor().getPhone());
        System.out.println(book.getVisitor().getEmail());
        // взять занятую книгу
        book = libra.takeBook("Красивая жизнь");
        // взять тем же человеком другую книгу
        book = libra.takeBook("Жизнь насекомых");
        // вернуть книгу
        book = libra.takeBook("Долгая прогулка");
        libra.returnBook(book.getVisitor());
        // получить оценку
        System.out.println("Оценка " + libra.getGrades("Долгая прогулка"));
        System.out.println("Оценка " + libra.getBook("Долгая прогулка").getGrades());

    }

}

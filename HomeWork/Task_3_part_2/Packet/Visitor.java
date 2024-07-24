package Packet;

public class Visitor {

    // имя фамилия телефон почта
    private String name, surname, phone, email;
    private int identifier, appeals;

    private boolean haveBook;

    private Book book;

    public Visitor() {

    }

    public Visitor(String name, String surname, String phone, String email, int identifier) {
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.email = email;
        this.identifier = identifier;
    }

    public String getName() {
        return this.name;
    }

    public String getSurname() {
        return this.surname;
    }

    public String getPhone() {
        return this.phone;
    }

    public String getEmail() {
        return this.email;
    }

    public int getIdentifier() {
        return this.identifier;
    }

    public boolean getHaveBook() {
        return this.haveBook;
    }

    public Book getBook() {
        return this.book;
    }

    public int getAppeals() {
        return appeals;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setIdentifier(int identifier) {
        this.identifier = identifier;
    }

    public void setHaveBook(boolean haveBook) {
        this.haveBook = haveBook;
    }

    public void upAppeals() {
        ++this.appeals;
    }

    public void downAppeals() {
        --this.appeals;
    }


    public void setBook(Book book) {
        this.book = book;
    }

}

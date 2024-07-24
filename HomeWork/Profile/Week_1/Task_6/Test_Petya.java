package Task_6;

import Task_6.exception.BaseException;

import java.text.ParseException;

public class Test_Petya {
    public static void main(String[] args) {
        try {
            Task_6.FormValidator.checkName("Petya");
            Task_6.FormValidator.checkBirthdate("12.02.1999");
            Task_6.FormValidator.checkGender("Female");
            Task_6.FormValidator.checkHeight("183");
        } catch (BaseException baseException) {
            System.out.println("Произошла ошибка валидации данных, данные введены некорректно");
        } catch (ParseException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}

package Task_6;

import Task_6.exception.CheckBirthdateException;
import Task_6.exception.CheckGenderException;
import Task_6.exception.CheckHeightException;
import Task_6.exception.CheckNameException;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static java.lang.Double.parseDouble;

public class FormValidator {
    private FormValidator() {
    }

    public static void checkName(String str) throws CheckNameException {
        if (!str.matches("[A-Z][a-z]{1,19}")) {
            throw new CheckNameException();
        }
        System.out.println("Валидация имени успешно пройдена");
    }

    public static void checkBirthdate(String str) throws ParseException {
        DateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
        formatter.setLenient(false);

        Date firstDate = formatter.parse("01.01.1900");
        Date nowDate = new Date();
        Date currDate = formatter.parse(str);
        if (currDate.after(nowDate) || currDate.before(firstDate)) {
            throw new CheckBirthdateException("Дата рождения не может быть позже текущей даты");
        }
        System.out.println("Валидация даты рождения успешно пройдена");
    }

    public static void checkGender(String str) {
        if (!str.equals((Gender.Male).toString()) && !str.equals((Gender.Female).toString())) {
            throw new CheckGenderException();
        }
        System.out.println("Валидация гендера успешно пройдена");
    }

    public static void checkHeight(String str) {
        try {
            if (parseDouble(str) <= 0) {
                throw new CheckHeightException("Рост должен быть положительной величиной");
            }
            System.out.println("Валидация роста успешно пройдена");
        } catch (NumberFormatException exception) {
            throw new CheckHeightException("Рост указан некорректно, допустимые символы - 0123456789");
        }
    }

    public enum Gender {
        Male,
        Female
    }

}

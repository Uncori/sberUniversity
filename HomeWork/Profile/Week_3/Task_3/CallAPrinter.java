package Task_3;


import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class CallAPrinter {
    public static void main(String[] args) {
        try {
            APrinter printer = new APrinter();
            Method myMethod = printer.getClass().getDeclaredMethod("print", int.class);
            // myMethod.setAccessible(true);
            myMethod.invoke(printer, 123);
            myMethod.invoke(printer, 123.123);
            myMethod.invoke(printer, "asd");
        } catch (NoSuchMethodException ex) {
            System.out.println("No such method");
        } catch (IllegalAccessException ex) {
            System.out.println("The method access modifiers forbid calling it");
        } catch (IllegalArgumentException ex) {
            System.out.println("Incorrect arguments given!");
        } catch (InvocationTargetException ex) {
            System.out.println("Class is abstract");
        }
    }
}

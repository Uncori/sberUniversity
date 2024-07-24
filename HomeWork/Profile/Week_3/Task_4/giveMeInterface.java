package Task_4;

import Task_4.example.*;

import java.util.*;

public class giveMeInterface {

    public static void main(String[] args) {
        List<Class<?>> interfaces = getAllInterfaces(A.class);
        for (Class<?> anInterface : interfaces) {
            System.out.println(anInterface.getName());
        }
    }

    public static List<Class<?>> getAllInterfaces(Class<?> clazz) {
        Set<Class<?>> interfaces = new HashSet<>();

        while (clazz != Object.class) {
            interfaces.addAll(Arrays.asList(clazz.getInterfaces()));
            clazz = clazz.getSuperclass();
        }

        for (Class<?> interFace : interfaces) {
            while (interFace != null) {
                interfaces.addAll(Arrays.asList(interFace.getInterfaces()));
                interFace = interFace.getSuperclass();
            }
        }

        return (List<Class<?>>) interfaces;
    }

}

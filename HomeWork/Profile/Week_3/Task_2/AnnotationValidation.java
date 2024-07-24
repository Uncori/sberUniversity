package Task_2;


import Task_1.IsLike;
import Task_1.MeAnnotation;

public class AnnotationValidation {
    public static void writeAnnotation(Class<?> clazz) {
        if (!clazz.isAnnotationPresent(IsLike.class)) {
            return;
        }

        IsLike classDescription = clazz.getAnnotation(IsLike.class);
        System.out.println("RES: " + classDescription.res());

    }

    public static void main(String[] args) {
        writeAnnotation(MeAnnotation.class);
    }

}

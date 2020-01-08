package forlearn;

import forlearn.annotations.Save;
import forlearn.annotations.SaveTo;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class SaverClazz {
    public static void main(String[] args) {
        ExampleSaveWithAnnotations exampleSaveWithAnnotations = new ExampleSaveWithAnnotations();
        final Class<?> cls = exampleSaveWithAnnotations.getClass();
        Field[] fields = cls.getDeclaredFields();
        Field[] goodFields = new Field[10];
       for (int i = 0; i <  fields.length; i++ ){
            if(fields[i].isAnnotationPresent(Save.class)) {
                goodFields[i] = fields[i];
           }
       }

           SaveTo saveTo = cls.getAnnotation(SaveTo.class);
        Method[] methods = cls.getMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(forlearn.annotations.Saver.class)) {
                System.out.println("method: " + method.getName());
                try {
                    method.invoke( exampleSaveWithAnnotations, saveTo.path(), exampleSaveWithAnnotations);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

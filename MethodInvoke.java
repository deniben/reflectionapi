package forlearn;

import forlearn.annotations.Test;

import java.lang.reflect.*;

public class MethodInvoke {
    public static void main(String[] args) {
        PrivateClass privateClass = new PrivateClass();
        final Class<?> cls = PrivateClass.class;
        System.out.println("name = "+cls.getName());

        Method[] methods = cls.getMethods();
        for(
                Method method :methods)

        {
            System.out.println("Method name:" + method.getName());
            if (method.isAnnotationPresent(Test.class)) {
                Test test = (Test) method.getAnnotation(Test.class);
                int a = test.a();
                int b = test.b();
                try {
                    method.invoke(privateClass, a, b);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}

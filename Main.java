package forlearn;

import java.lang.annotation.Annotation;
import java.lang.reflect.*;

public class Main {
    public static void main(String[] args) {
        PrivateClass privateClass = new PrivateClass();
        final Class<?> cls = PrivateClass.class;
        System.out.println("name = " + cls.getName());
        try {
          Method[] methods = cls.getMethods();
          for(Method method: methods){
              System.out.println("Method name:" + method.getName());
              if(method.isAnnotationPresent(Test.class)){
                  Test test = (Test) method.getAnnotation(Test.class);
                  int a = test.a();
                  int b = test.b();
                  method.invoke(a, b);
              }
          }
        }catch (Exception ex) {
            ex.printStackTrace();
        }

    }
}

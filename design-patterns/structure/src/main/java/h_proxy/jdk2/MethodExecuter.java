package h_proxy.jdk2;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * Created with IDEA
 *
 * @author wenka wkwenka@gmail.com
 * @date 2020/12/31  下午 01:45
 * @description:
 */
public class MethodExecuter {

    private final Method method;

    public MethodExecuter(Method method) {
        this.method = method;
    }

    /**
     * 根据方法参数及注解执行返回
     *
     * @param args
     * @return
     */
    public Object execute(Object[] args) {
        System.out.println("method: " + this.method);
        Class<?> returnType = this.method.getReturnType();
        System.out.println("returnType: " + returnType);
        Annotation[] annotations = this.method.getAnnotations();
        System.out.println("Annotations: ");
        for (Annotation annotation : annotations) {
            System.out.println(annotation);
        }

        // 可以通过 method 拿到该方法的任何信息，然后做想做的操作。

        if (returnType == void.class) {
            return null;
        } else {
            // 对其他类型的返回值进行处理
            // .....
        }
        return null;
    }
}

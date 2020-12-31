package h_proxy.jdk2;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created with IDEA
 *
 * @author wenka wkwenka@gmail.com
 * @date 2020/12/31  下午 01:50
 * @description:
 */
public class InterfaceProxyHandler implements InvocationHandler {

    private final Class targetClass;

    public <T> InterfaceProxyHandler(Class<T> targetClass) {
        this.targetClass = targetClass;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result = null;
        try {
            if (Object.class == method.getDeclaringClass()) {
                result = method.invoke(this, args);
            } else {
                System.out.println("## before ##");
                MethodExecuter methodExecuter = new MethodExecuter(method);
                result = methodExecuter.execute(args);
                System.out.println("## after ##");
            }
        } catch (Exception e) {
            if (Object.class != method.getDeclaringClass()) {
                System.out.println("## exception ##");
            }
            throw e;
        } finally {
            if (Object.class != method.getDeclaringClass()) {
                System.out.println("## finally ##");
            }
        }
        return result;
    }
}

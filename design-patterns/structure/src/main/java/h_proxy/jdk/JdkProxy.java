package h_proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created with IDEA
 * author:wenka wkwenka@gmail.com
 * Date:2019/07/06  上午 09:52
 * Description:
 */
public class JdkProxy<T> implements InvocationHandler {

    private T target;

    public T getProxy(T target){
        this.target = target;
        Object o = Proxy.newProxyInstance(this.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
        return (T) o;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("## before ##");
        Object result = null;
        try {
            result = method.invoke(target, args);
            System.out.println("## after ##");
        } catch (Exception e) {
            System.out.println("## exception ##");
            throw e;
        } finally {
            System.out.println("# finally #");
        }
        return result;
    }
}

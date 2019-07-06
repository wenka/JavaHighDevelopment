package h_proxy.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Created with IDEA
 * author:wenka wkwenka@gmail.com
 * Date:2019/07/06  上午 10:12
 * Description:
 */
public class CglibInterceptor<T> implements MethodInterceptor {

    public T getProxy(Class<? extends T> c){
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(c);
        enhancer.setCallback(this);
        Object o = enhancer.create();
        return (T) o;
    }
    @Override
    public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        System.out.println("## before ##");
        Object result = null;
        try {
            result = methodProxy.invokeSuper(o, args);
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

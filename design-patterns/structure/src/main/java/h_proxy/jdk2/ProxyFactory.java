package h_proxy.jdk2;

import java.lang.reflect.Proxy;

/**
 * Created with IDEA
 *
 * @author wenka wkwenka@gmail.com
 * @date 2020/12/31  下午 01:50
 * @description:
 */
public class ProxyFactory {

    public static <T> T getInstance(Class<T> tClass) {
        InterfaceProxyHandler interfaceProxyHandler = new InterfaceProxyHandler(tClass);
        Object o = Proxy.newProxyInstance(ProxyFactory.class.getClassLoader(), new Class[]{tClass}, interfaceProxyHandler);
        return (T) o;
    }

}

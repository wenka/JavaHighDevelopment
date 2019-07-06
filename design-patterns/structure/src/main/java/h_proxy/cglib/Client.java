package h_proxy.cglib;

import h_proxy.People;

/**
 * Created with IDEA
 * author:wenka wkwenka@gmail.com
 * Date:2019/07/06  上午 10:16
 * Description:
 */
public class Client {

    public static void main(String[] args) {

        CglibInterceptor<People> interceptor = new CglibInterceptor<>();
        People proxy = interceptor.getProxy(Women.class);
        proxy.eat();
    }
}

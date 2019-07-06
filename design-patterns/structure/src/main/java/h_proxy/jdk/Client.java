package h_proxy.jdk;

import h_proxy.People;

/**
 * Created with IDEA
 * author:wenka wkwenka@gmail.com
 * Date:2019/07/06  上午 10:01
 * Description:
 */
public class Client {

    public static void main(String[] args) {
        JdkProxy<People> peopleJdkProxy = new JdkProxy<>();
        People proxy = peopleJdkProxy.getProxy(new Men());
        proxy.eat();
    }
}

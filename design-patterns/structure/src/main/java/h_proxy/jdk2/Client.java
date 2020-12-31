package h_proxy.jdk2;

import h_proxy.People;

/**
 * Created with IDEA
 * author:wenka wkwenka@gmail.com
 * Date:2019/07/06  上午 10:01
 * Description:
 */
public class Client {

    public static void main(String[] args) {
        People people = ProxyFactory.getInstance(People.class);
        System.out.println(people);
        people.eat();
    }
}

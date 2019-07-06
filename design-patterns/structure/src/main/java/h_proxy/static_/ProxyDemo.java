package h_proxy.static_;

/**
 * Created with IDEA
 * author:wenka wkwenka@gmail.com
 * Date:2019/01/21  下午 01:55
 * Description:
 */
public class ProxyDemo {

    public static void main(String[] args) {
        ProxyFile proxyFile = new ProxyFile("aaaa.txt");
        proxyFile.display();
        proxyFile.display();
    }
}

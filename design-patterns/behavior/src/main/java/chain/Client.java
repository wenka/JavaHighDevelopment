package chain;

/**
 * Created with IDEA
 * author:wenka wkwenka@gmail.com
 * Date:2019/07/06  上午 10:25
 * Description:
 */
public class Client {

    static class HandlerA extends Handler{
        @Override
        protected void process() {
            System.out.println("AA");
        }
    }

    static class HandlerB extends Handler{
        @Override
        protected void process() {
            System.out.println("BB");
        }
    }


    public static void main(String[] args) {
        HandlerA handlerA = new HandlerA();
        HandlerB handlerB = new HandlerB();
        handlerA.setHandler(handlerB);
        handlerA.execute();
    }
}

package chain;

import java.util.Arrays;

/**
 * Created with IDEA
 * author:wenka wkwenka@gmail.com
 * Date:2019/07/06  上午 10:25
 * Description:
 */
public class ChainClient {

    static class ChainHandlerA extends ChainHandler{
        @Override
        protected void process() {
            System.out.println("AA");
        }
    }

    static class ChainHandlerB extends ChainHandler{
        @Override
        protected void process() {
            System.out.println("BB");
        }
    }


    public static void main(String[] args) {
        ChainHandlerA handlerA = new ChainHandlerA();
        ChainHandlerB handlerB = new ChainHandlerB();

        Chain chain = new Chain(Arrays.asList(handlerA, handlerB));
        chain.excute();
    }
}

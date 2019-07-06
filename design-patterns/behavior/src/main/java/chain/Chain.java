package chain;

import java.util.List;

/**
 * Created with IDEA
 * author:wenka wkwenka@gmail.com
 * Date:2019/07/06  上午 10:26
 * Description:
 */
public class Chain {

    private List<ChainHandler> handlers;

    private int index = 0;

    public Chain(List<ChainHandler> handlers) {
        this.handlers = handlers;
    }

    public void excute(){
        if (index >= handlers.size()){
            return;
        }
        handlers.get(index++).excute(this);
    }
}

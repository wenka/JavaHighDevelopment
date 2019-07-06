package chain;

/**
 * Created with IDEA
 * author:wenka wkwenka@gmail.com
 * Date:2019/07/06  上午 10:23
 * Description:
 */
public abstract class ChainHandler {

    protected  abstract void process();

    public void  excute(Chain chain){
        process();
        chain.excute();
    }
}

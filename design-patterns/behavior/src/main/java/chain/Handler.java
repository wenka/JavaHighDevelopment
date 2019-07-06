package chain;

/**
 * Created with IDEA
 * author:wenka wkwenka@gmail.com
 * Date:2019/07/06  上午 10:23
 * Description:
 */
public abstract class Handler {

    private Handler handler;

    public Handler getHandler() {
        return handler;
    }

    public void setHandler(Handler handler) {
        this.handler = handler;
    }

    protected  abstract void process();

    public void  execute(){
        process();
        if (handler != null){
            handler.process();
        }
    }
}

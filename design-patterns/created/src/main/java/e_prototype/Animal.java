package e_prototype;

/**
 * Created with IDEA
 * author:wenka wkwenka@gmail.com
 * Date:2019/01/10  上午 09:43
 * Description:
 */
public abstract class Animal implements Cloneable {

    private String id;

    private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    abstract void call();


    @Override
    protected Object clone(){
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return null;
    }
}

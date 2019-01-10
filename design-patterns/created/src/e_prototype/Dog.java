package e_prototype;

/**
 * Created with IDEA
 * author:wenka wkwenka@gmail.com
 * Date:2019/01/10  上午 09:44
 * Description:
 */
public class Dog extends Animal {

    public Dog() {
        this.setName("dog");
    }

    @Override
    void call() {
        System.out.println(this.getId() + "=" + this.getName() + ">Wang! Wang! Wang!");
    }
}

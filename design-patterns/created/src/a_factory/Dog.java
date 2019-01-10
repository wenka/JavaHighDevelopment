package a_factory;

/**
 * Created with IDEA
 * author:wenka wkwenka@gmail.com
 * Date:2019/01/09  下午 02:30
 * Description:
 */
public class Dog implements Animal {
    @Override
    public void call() {
        System.out.println("dog: wang! wang! wang!");
    }
}

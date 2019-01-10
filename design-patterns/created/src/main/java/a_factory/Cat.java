package a_factory;

/**
 * Created with IDEA
 * author:wenka wkwenka@gmail.com
 * Date:2019/01/09  下午 02:30
 * Description:
 */
public class Cat implements Animal {
    @Override
    public void call() {
        System.out.println("Cat: Meow! Meow! Meow!");
    }
}

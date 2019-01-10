package b_abstract_factory.entity;

import b_abstract_factory.in.Animal;

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

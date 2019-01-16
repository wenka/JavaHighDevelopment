package e_decorator.entity;

import e_decorator.in.Animal;

/**
 * Created with IDEA
 * author:wenka wkwenka@gmail.com
 * Date:2019/01/16  下午 01:54
 * Description:
 */
public class Cat implements Animal{
    @Override
    public void call() {
        System.out.println("Meow! Meow! Meow!");
    }
}

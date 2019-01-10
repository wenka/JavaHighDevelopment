package b_abstract_factory.entity;

import b_abstract_factory.in.Color;

/**
 * Created with IDEA
 * author:wenka wkwenka@gmail.com
 * Date:2019/01/09  下午 02:44
 * Description:
 */
public class Black implements Color {
    @Override
    public void coat() {
        System.out.println("black");
    }
}

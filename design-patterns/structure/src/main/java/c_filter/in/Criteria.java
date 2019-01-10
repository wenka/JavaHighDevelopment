package c_filter.in;

import c_filter.People;

import java.util.List;

/**
 * Created with IDEA
 * author:wenka wkwenka@gmail.com
 * Date:2019/01/10  下午 03:27
 * Description:
 */
public interface Criteria {

    List<People> meetCriteria(List<People> peopleList);
}

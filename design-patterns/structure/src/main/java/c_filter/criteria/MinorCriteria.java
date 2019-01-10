package c_filter.criteria;

import c_filter.People;
import c_filter.in.Criteria;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created with IDEA
 * author:wenka wkwenka@gmail.com
 * Date:2019/01/10  下午 03:34
 * Description:
 */
public class MinorCriteria implements Criteria{
    @Override
    public List<People> meetCriteria(List<People> peopleList) {
        return peopleList.stream().filter(people -> {
            return people.getAge() < 18;
        }).collect(Collectors.toList());
    }
}

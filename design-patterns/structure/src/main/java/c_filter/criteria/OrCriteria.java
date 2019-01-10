package c_filter.criteria;

import c_filter.People;
import c_filter.in.Criteria;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IDEA
 * author:wenka wkwenka@gmail.com
 * Date:2019/01/10  下午 03:43
 * Description:
 */
public class OrCriteria implements Criteria{
    private List<Criteria> criteriaList;

    public OrCriteria(Criteria... criteriaList) {
        this.criteriaList = new ArrayList<>();
        for (Criteria criteria : criteriaList) {
            this.criteriaList.add(criteria);
        }
    }

    @Override
    public List<People> meetCriteria(List<People> peopleList) {
        List<People> result = new ArrayList<>();
        for (Criteria criteria: criteriaList){
            List<People> peoples = criteria.meetCriteria(peopleList);
            for (People peo: peoples){
                if (!result.contains(peo)){
                    result.add(peo);
                }
            }
        }
        return result;
    }
}

package com.wenka.reflect.test;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created with IDEA
 * author:wenka wkwenka@gmail.com
 * Date:2019/06/11  下午 05:20
 * Description:
 */
public class ReflectTest {

    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
        Class<StockTradeInfo> stockTradeInfoClass = StockTradeInfo.class;
        StockTradeInfo stockTradeInfo = stockTradeInfoClass.newInstance();
        Field[] declaredFields = stockTradeInfo.getClass().getDeclaredFields();

//        Arrays.sort(declaredFields, (field1, field2) -> {
//            Index index1 = field1.getAnnotation(Index.class);
//            Integer value1 = -1;
//            if (index1 != null) {
//                value1 = index1.value();
//            }
//
//            Index index2 = field2.getAnnotation(Index.class);
//            Integer value2 = -1;
//            if (index2 != null) {
//                value2 = index2.value();
//            }
//            if (value1 != value2) {
//                return value1.compareTo(value2);
//            } else {
//                return field1.getName().compareTo(field1.getName());
//            }
//        });

        String txt = "a|   12.3|   15.6|    17.9";
        String[] split = txt.split("\\|");
        Map<String,String> argsMap = new HashMap<>();
        for (int i=0;i<split.length;i++){
            argsMap.put(String.valueOf(i),split[i]);
        }

        for (Field field : declaredFields) {
            Index index = field.getAnnotation(Index.class);
            if (index == null){
                continue;
            }
            String s = argsMap.get(String.valueOf(index.value())).trim();
            field.setAccessible(true);
            Class<?> type = field.getType();
            if (type == Double.class){
                field.set(stockTradeInfo,Double.valueOf(s));
            }else {
                field.set(stockTradeInfo,s);
            }
        }


        System.out.println(stockTradeInfo);
    }
}

package com.wenka.annotation;

import java.lang.reflect.Field;

import com.wenka.annotation.FruitColor.Color;

public class FruitInfoUtil {

	public static void getFruitInfo(Class<?> clazz) {

		Field[] fields = clazz.getDeclaredFields();

		for (Field field : fields) {
			if (field.isAnnotationPresent(FruitName.class)) {
				FruitName fruitName = field.getAnnotation(FruitName.class);
				String fn = fruitName.value();
				System.out.println(fn);
			} else if (field.isAnnotationPresent(FruitColor.class)) {
				FruitColor fruitColor = field.getAnnotation(FruitColor.class);
				Color fc = fruitColor.fruitColor();
				System.out.println(fc);
			}
		}

	}

}

package com.wenka.annotation;

import com.wenka.annotation.FruitColor.Color;

public class Fruit {

	@FruitName(value = "Apple")
	private String name;

	@FruitColor(fruitColor = Color.GREEN)
	private String color;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public String toString() {
		return "Fruit [name=" + name + ", color=" + color + "]";
	}

}

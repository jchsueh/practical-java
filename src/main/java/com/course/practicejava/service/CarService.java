package com.course.practicejava.service;

import java.util.List;

import com.course.practicejava.entity.Car;

public interface CarService {
	
	List<String> BRANDS = List.of("Toyota","Honda","Ford");
	
	List<String> COLORS = List.of("Red","Black","White");
	
	List<String> TYPES = List.of("Sedan","SUV","MPV");
	
	public Car generateCar();
}

package com.course.practicejava.service;

import com.course.practicejava.entity.Car;

import java.util.List;

public interface CarService {
	
	List<String> BRANDS = List.of("Toyota","Honda","Ford","BMW","Mitsubishi");
	
	List<String> COLORS = List.of("Red","Black","White","Blue","Silver");
	
	List<String> TYPES = List.of("Sedan","SUV","MPV","Hatchback","Covertible");

	List<String> ADDITIONAL_FEATURES = List.of("GPS","Alarm","Sunroof","Media player","Leather seats");

	List<String> FUELS = List.of("Petrol","Electric","Hybrid");

	List<String> TIRE_MANUFACTURERS = List.of("Goodyears","Bridgestone","Bunlop");

	public Car generateCar();
}

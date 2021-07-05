package com.course.practicejava.service;

import org.springframework.stereotype.Service;

import com.course.practicejava.entity.Car;

import io.netty.util.internal.ThreadLocalRandom;

@Service
public class RandomCarService implements CarService {

	@Override
	public Car generateCar() {
		var brand = BRANDS.get(ThreadLocalRandom.current().nextInt(0,BRANDS.size()));
		var color = COLORS.get(ThreadLocalRandom.current().nextInt(0,COLORS.size()));
		var type = TYPES.get(ThreadLocalRandom.current().nextInt(0,TYPES.size()));
		
		return new Car(brand, color, type);
	}

}

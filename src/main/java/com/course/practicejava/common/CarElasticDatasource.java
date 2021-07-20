package com.course.practicejava.common;

import com.course.practicejava.entity.Car;
import com.course.practicejava.repository.CarElasticRepository;
import com.course.practicejava.service.CarService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.ArrayList;

@Component
public class CarElasticDatasource {

    private static final Logger LOG = LoggerFactory.getLogger(CarElasticDatasource.class);

    @Autowired
    private CarElasticRepository carElasticRepository;

    @Autowired
    @Qualifier("randomCarService")
    private CarService carService;

    @Autowired
    @Qualifier("webClientElasticsearch")
    private WebClient webClient;

    @EventListener(ApplicationReadyEvent.class)
    public void populateDate(){
        var respose = webClient.delete().uri("/practical-java").retrieve().bodyToMono(String.class).block();
        LOG.info("End delete with response {}", respose);

        var cars = new ArrayList<Car>();

        for(int i = 0; i <10_000; i++){
            cars.add(carService.generateCar());
        }

        carElasticRepository.saveAll(cars);

        LOG.info("Save {} cars",carElasticRepository.count());
    }
}

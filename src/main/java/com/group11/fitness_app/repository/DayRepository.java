package com.group11.fitness_app.repository;

import com.group11.fitness_app.model.Day;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DayRepository extends MongoRepository<Day, String> {

}

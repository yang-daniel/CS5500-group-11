package main.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import main.model.Day;



public interface DayRepository extends MongoRepository<Day, String> {

}
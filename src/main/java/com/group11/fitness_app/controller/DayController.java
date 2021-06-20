package com.group11.fitness_app.controller;

import com.group11.fitness_app.model.Day;
import com.group11.fitness_app.repository.DayRepository;
import java.util.List;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DayController {

  @Autowired
  private DayRepository repository;

  //add more later
}

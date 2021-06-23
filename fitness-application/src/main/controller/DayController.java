package main.controller;

import java.util.List;
import lombok.Getter;
import main.repository.DayRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DayController {

  @Autowired
  private DayRepository repository;

  //add more later
}

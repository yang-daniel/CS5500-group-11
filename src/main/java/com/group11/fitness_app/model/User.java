package com.group11.fitness_app.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document
public class User {

  @Id
  private String id;
  @Field
  private String firstName;
  @Field
  private String lastName;
  @Field
  private int age;
  @Field
  private int weight;
  @Field
  private String address;


  public User(){}

  public User(String id, String firstName, String lastName, int age, int weight,
      String address) {
    this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;
    this.age = age;
    this.weight = weight;
    this.address = address;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public int getWeight() {
    return weight;
  }

  public void setWeight(int weight) {
    this.weight = weight;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  @Override
  public String toString() {
    return "User{" +
        "ID='" + id + '\'' +
        ", first name=" + firstName +
        ", last name =" + lastName + '\'' +
        ", age =" + age + '\'' +
        ", weight ='" + weight + '\'' +
        ", address ='" + address + '\'' +
        '}';
  }
}

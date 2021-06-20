package com.group11.fitness_app;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import org.bson.Document;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
public class FitnessAppApplication {

	public static MongoClient mongoClient = MongoClients.create(
			"mongodb+srv://dbAdmin:Y28Yl3Y2KPutVfwD@cluster0.03g61.mongodb.net/Activities?retryWrites=true&w=majority");
	public static MongoDatabase database = mongoClient.getDatabase("Activities");
	public static MongoCollection<Document> collection = database.getCollection("Project");

	public static void main(String[] args) {
		//SpringApplication.run(FitnessAppApplication.class, args);
		System.out.println(getRangeCalories("20130222", "20130224"));
		System.out.println(getRangeSteps("20130222", "20130312"));
		System.out.println(getDayCalories("20130222"));
		System.out.println(getDaySteps("20130222"));
	}

	/*
	gets count of documents in collection
	 */
	public static void getCount() {
		System.out.println(collection.countDocuments());
	}

	/*
	prints all documents in collection in Json format
	 */
	public static void printAll() {
		MongoCursor<Document> cursor = collection.find().iterator();
		try {
			while (cursor.hasNext()) {
				System.out.println(cursor.next().toJson());
			}
		} finally {
			cursor.close();
		}
	}

	/*
	returns document of specific day
	format for day is yyyyMMdd
	 */
	public static Document getDay(String day) {
		Document myDay = collection.find(Filters.eq("date", day)).first();
		return myDay;
	}

	/*
	prints specific day in Json format
	 */
	public static void printDay(String day) {
		Document myDay = getDay(day);
		System.out.println(myDay.toJson());
	}

	/*
	returns the calories (nonidle) of a specific day
	 */
	public static int getDayCalories(String day) {
		Document myDoc = collection.find(Filters.eq("date", day)).first();
		ArrayList tempArray = (ArrayList) myDoc.get("summary");
		Document tempDoc = (Document) tempArray.get(0);
		int calories = (int) tempDoc.get("calories");
		return calories;
	}

	/*
	returns the steps taken of a specific day
	 */
	public static int getDaySteps(String day) {
		Document myDoc = collection.find(Filters.eq("date", day)).first();
		ArrayList tempArray = (ArrayList) myDoc.get("summary");
		Document tempDoc = (Document) tempArray.get(0);
		int steps = (int) tempDoc.get("steps");
		return steps;
		//tempObj.getClass().getField("steps");
	}

	public static LocalDate stringToLocalDate(String day) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
		return LocalDate.parse(day, formatter);
	}

	/*
		gets range of Calories on dates. Note endDay is exclusive.
	  TODO: testing for non-existent dates // dates out of range
	 */
	public static int getRangeCalories(String startDay, String endDay) {
		return rangeCaloriesIterator(stringToLocalDate(startDay), stringToLocalDate(endDay));
	}

	/*
	helper function for iterating through dates and getting calories
	TODO: can probably be abstracted more for DRY principals
	 */
	public static int rangeCaloriesIterator(LocalDate start, LocalDate end) {
		int totalCalories = 0;
		for (LocalDate date = start; date.isBefore(end); date = date.plusDays(1)) {
			//System.out.println(date.toString().replaceAll("-",""));
			totalCalories += getDayCalories(date.toString().replaceAll("-",""));
		}
		return totalCalories;
	}

	/*
  gets range of steps on dates. Note endDay is exclusive.
  TODO: testing for non-existent dates // dates out of range
 */
	public static int getRangeSteps(String startDay, String endDay) {
		return rangeStepsIterator(stringToLocalDate(startDay), stringToLocalDate(endDay));
	}

	/*
	helper function for iterating through dates and getting steps
	TODO: can probably be abstracted more for DRY principals
 */
	public static int rangeStepsIterator(LocalDate start, LocalDate end) {
		int totalSteps = 0;
		for (LocalDate date = start; date.isBefore(end); date = date.plusDays(1)) {
			//System.out.println(date.toString().replaceAll("-",""));
			totalSteps += getDaySteps(date.toString().replaceAll("-",""));
		}
		return totalSteps;
	}





}

package main.client;

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
public class MongoDBClient implements IMongoDBClient{

	public static final String CONNECTION_STRING = "mongodb+srv://dbAdmin:Y28Yl3Y2KPutVfwD@cluster0.03g61.mongodb.net/Activities?retryWrites=true&w=majority";
	public static final String DATABASE_NAME = "Activities";
	public static final String COLLECTION_NAME = "Project";
	public static MongoCollection<Document> collection;

	public boolean setup() {
		MongoClient mongoClient = MongoClients.create(CONNECTION_STRING);
		MongoDatabase database = mongoClient.getDatabase(DATABASE_NAME);
		collection = database.getCollection(COLLECTION_NAME);
		return true;
	}

	/*
	gets count of documents in collection
	 */
	public void getCount() {
		System.out.println(collection.countDocuments());
	}

	/*
	prints all documents in collection in Json format
	 */
	public void printAll() {
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
	public Document getDay(String day) {
		Document myDay = collection.find(Filters.eq("date", day)).first();
		return myDay;
	}

	/*
	prints specific day in Json format
	 */
	public void printDay(String day) {
		Document myDay = getDay(day);
		System.out.println(myDay.toJson());
	}

	/*
	returns the calories (nonidle) of a specific day
	 */
	public int getDayCalories(String day) {
		Document myDoc = collection.find(Filters.eq("date", day)).first();
		ArrayList tempArray = (ArrayList) myDoc.get("summary");
		Document tempDoc = (Document) tempArray.get(0);
		int calories = (int) tempDoc.get("calories");
		return calories;
	}

	/*
	returns the steps taken of a specific day
	 */
	public int getDaySteps(String day) {
		Document myDoc = collection.find(Filters.eq("date", day)).first();
		ArrayList tempArray = (ArrayList) myDoc.get("summary");
		Document tempDoc = (Document) tempArray.get(0);
		int steps = (int) tempDoc.get("steps");
		return steps;
		//tempObj.getClass().getField("steps");
	}

	public LocalDate stringToLocalDate(String day) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
		return LocalDate.parse(day, formatter);
	}

	/*
		gets range of Calories on dates. Note endDay is exclusive.
	  TODO: testing for non-existent dates // dates out of range
	 */
	public int getRangeCalories(String startDay, String endDay) {
		return rangeCaloriesIterator(stringToLocalDate(startDay), stringToLocalDate(endDay));
	}

	/*
	helper function for iterating through dates and getting calories
	TODO: can probably be abstracted more for DRY principals
	 */
	public int rangeCaloriesIterator(LocalDate start, LocalDate end) {
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
	public int getRangeSteps(String startDay, String endDay) {
		return rangeStepsIterator(stringToLocalDate(startDay), stringToLocalDate(endDay));
	}

	/*
	helper function for iterating through dates and getting steps
	TODO: can probably be abstracted more for DRY principals
 */
	public int rangeStepsIterator(LocalDate start, LocalDate end) {
		int totalSteps = 0;
		for (LocalDate date = start; date.isBefore(end); date = date.plusDays(1)) {
			//System.out.println(date.toString().replaceAll("-",""));
			totalSteps += getDaySteps(date.toString().replaceAll("-",""));
		}
		return totalSteps;
	}


}
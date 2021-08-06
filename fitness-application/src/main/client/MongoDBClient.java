package main.client;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import ch.qos.logback.classic.Logger;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.LoggerContext;
import org.slf4j.LoggerFactory;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.bson.Document;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Repository;


//@SpringBootApplication
public class MongoDBClient implements IMongoDBClient{

	private static org.apache.logging.log4j.Logger LOGGER = LogManager.getLogger(MongoDBClient.class.getName());



	public static final String CONNECTION_STRING = "mongodb://127.0.0.1:27017";
	public static final String DATABASE_NAME = "test";
	public static final String COLLECTION_NAME = "Activities";
	public static MongoCollection<Document> collection;

//	public static void main(String[] args) {
//		SpringApplication.run(MongoDBClient.class, args);
//	}

	public boolean setup() {
		try {
			MongoClient mongoClient = MongoClients.create(CONNECTION_STRING);
			MongoDatabase database = mongoClient.getDatabase(DATABASE_NAME);
			collection = database.getCollection(COLLECTION_NAME);

			LoggerContext loggerContext = (LoggerContext) LoggerFactory.getILoggerFactory();
			Logger rootLogger = loggerContext.getLogger("org.mongodb.driver");
			rootLogger.setLevel(Level.OFF);
		} catch (Exception e) {
			LOGGER.error(e.getStackTrace());
			return false;
		}
		return true;
	}


	/*
	upload single document to db
	 */
	public void insertDoc(Document doc) {
		collection.insertOne(doc);
	}

	/*
	upload multiple document to db
	 */
	public void insertManyDoc(List<Document> docs) {
		collection.insertMany(docs);
	}

	/*
	gets count of documents in collection
	 */
	public int getCount() {
		return (int) collection.countDocuments();
	}

	/*
	prints all documents in collection in Json format
	 */
	public String printAll() {
		MongoCursor<Document> cursor = collection.find().iterator();
		StringBuffer allDocs = new StringBuffer();
		try {
			while (cursor.hasNext()) {
				allDocs.append(cursor.next().toJson());
			}
		} finally {
			cursor.close();
		}
		return allDocs.toString();
	}

	/*
	returns document of specific day
	format for day is yyyyMMdd
	 */
	public Document getDay(String day) {
		Document myDay = collection.find(Filters.eq("date", day)).first();
		if (myDay == null) {
			throw new IndexOutOfBoundsException("Date does not exist!!");
		}
		return  myDay;
	}

	/*
	prints specific day in Json format
	 */
	public String printDay(String day) {
		StringBuilder stringDay = new StringBuilder();
		Document myDay = getDay(day);
		stringDay.append(myDay.toJson());

		if (stringDay.length() == 0) {
			throw new IndexOutOfBoundsException("Date does not exist!");
		}
		return stringDay.toString();
	}

	/*
	returns the calories (nonidle) of a specific day. if date doesn't exist, return 0
	 */
	public int getDayCalories(String day) {
		Document myDoc = collection.find(Filters.eq("date", day)).first();

		if (myDoc == null) {
			throw new IndexOutOfBoundsException("Date does not exist!");
		}

		ArrayList tempArray = (ArrayList) myDoc.get("summary");

		if (tempArray == null) {
			return 0;
		}
		
		int calories = 0;

		for (int i = 0; i < tempArray.size(); i++) {
			Document tempDoc = (Document) tempArray.get(i);
			if (tempDoc.get("calories") != null) {
				calories += (int) tempDoc.get("calories");
			}
		}
		return calories;
	}

	/*
	returns the steps taken of a specific day. if date doesn't exist, return 0
	 */
	public int getDaySteps(String day) {
		Document myDoc = collection.find(Filters.eq("date", day)).first();
		if (myDoc == null) {
			throw new IndexOutOfBoundsException("Date does not exist!");
		}
		ArrayList tempArray = (ArrayList) myDoc.get("summary");

		if (tempArray == null) {
			return 0;
		}
		int steps = 0;
		for (int i = 0; i < tempArray.size(); i++) {
			Document tempDoc = (Document) tempArray.get(i);
			if (tempDoc.get("steps") != null) {
				steps += (int) tempDoc.get("steps");
			}
		}
		return steps;
	}

	public LocalDate stringToLocalDate(String day) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
		return LocalDate.parse(day, formatter);
	}

	/*
		gets range of Calories on dates. Note endDay is exclusive.
	 */
	public int getRangeCalories(String startDay, String endDay) {
		return rangeCaloriesIterator(stringToLocalDate(startDay), stringToLocalDate(endDay));
	}

	/*
	helper function for iterating through dates and getting calories
	 */
	private int rangeCaloriesIterator(LocalDate start, LocalDate end) {
		if (!start.isBefore(end)) {
			throw new IndexOutOfBoundsException("End date is not before start date!");
		}
		int totalCalories = 0;
		for (LocalDate date = start; date.isBefore(end); date = date.plusDays(1)) {
			try {
				totalCalories += getDayCalories(date.toString().replaceAll("-",""));
			} catch (Exception e) {
				totalCalories += 0;
			}
		}
		return totalCalories;
	}

	/*
  gets range of steps on dates. Note endDay is exclusive.
 */
	public int getRangeSteps(String startDay, String endDay) {
		return rangeStepsIterator(stringToLocalDate(startDay), stringToLocalDate(endDay));
	}

	/*
	helper function for iterating through dates and getting steps
 */
	private int rangeStepsIterator(LocalDate start, LocalDate end) {
		if (!start.isBefore(end)) {
			throw new IndexOutOfBoundsException("End date is not before start date!");
		}
		int totalSteps = 0;
		for (LocalDate date = start; date.isBefore(end); date = date.plusDays(1)) {
			try {
				totalSteps += getDaySteps(date.toString().replaceAll("-",""));
			} catch (Exception e) {
				totalSteps += 0;
			}
		}
		return totalSteps;
	}

	/*
	returns the calories (nonidle) of a specific day. if date doesn't exist, return 0
	 */
	public List<String> getDayActivities(String day) {
		Document myDoc = collection.find(Filters.eq("date", day)).first();
		List<String> results = new ArrayList<>();

		if (myDoc == null) {
			throw new IndexOutOfBoundsException("Date does not exist!");
//			return results;
		}

		ArrayList tempArray = (ArrayList) myDoc.get("summary");

		if (tempArray == null) {
			return results;
		}
		for (int i = 0; i < tempArray.size(); i++) {
			Document tempDoc = (Document) tempArray.get(i);
			if (tempDoc.get("activity") != null) {
				String tempActivity = (String) tempDoc.get("activity");
				if (!results.contains(tempActivity)) {
					results.add(tempActivity);
				}
			}
		}
		return results;
	}

	/*
		gets range of Calories on dates. Note endDay is exclusive.
	 */
	public List<String> getRangeActivities(String startDay, String endDay) {
		return rangeActivitiesIterator(stringToLocalDate(startDay), stringToLocalDate(endDay));
	}

	/*
	helper function for iterating through dates and getting calories
	 */
	private List<String> rangeActivitiesIterator(LocalDate start, LocalDate end) {
		if (!start.isBefore(end)) {
			throw new IndexOutOfBoundsException("End date is not before start date!");
		}
		Set<String> activities = new HashSet<>();
		for (LocalDate date = start; date.isBefore(end); date = date.plusDays(1)) {
			try {
				activities.addAll(getDayActivities(date.toString().replaceAll("-","")));
			} catch (Exception e) {
				continue;
			}
		}
		return new ArrayList<>(activities);
	}

}
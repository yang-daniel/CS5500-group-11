package main.client;

import org.bson.Document;
import java.time.LocalDate;

public interface IMongoDBClient {


    public boolean setup();

	/*
	gets count of documents in collection
	 */
	public int getCount();

	/*
	prints all documents in collection in Json format
	 */
	public String printAll();

	/*
	returns document of specific day
	format for day is yyyyMMdd
	 */
	public Document getDay(String day);

	/*
	prints specific day in Json format
	 */
	public String printDay(String day);

	/*
	returns the calories (nonidle) of a specific day
	 */
	public int getDayCalories(String day);

	/*
	returns the steps taken of a specific day
	 */
	public int getDaySteps(String day);

	public LocalDate stringToLocalDate(String day);

	/*
		gets range of Calories on dates. Note endDay is exclusive.
	  TODO: testing for non-existent dates // dates out of range
	 */
	public int getRangeCalories(String startDay, String endDay);

	/*
	helper function for iterating through dates and getting calories
	TODO: can probably be abstracted more for DRY principals
	 */
	public int rangeCaloriesIterator(LocalDate start, LocalDate end);

	/*
  gets range of steps on dates. Note endDay is exclusive.
  TODO: testing for non-existent dates // dates out of range
 */
	public int getRangeSteps(String startDay, String endDay);

	/*
	helper function for iterating through dates and getting steps
	TODO: can probably be abstracted more for DRY principals
 */
	public int rangeStepsIterator(LocalDate start, LocalDate end);
}

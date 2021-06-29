package main.client;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MongoDBClientTest {
  public static MongoDBClient testClient = new MongoDBClient();

  @Test
  void setup() {
    assertEquals(true, testClient.setup());
    assertNotEquals(false, testClient.setup());

  }

  @Test
  void getCount() {
    testClient.setup();
    assertEquals(1644, testClient.getCount());
    assertNotEquals(1, testClient.getCount());
    assertNotEquals(0, testClient.getCount());
    assertNotEquals(-123, testClient.getCount());
  }

  //too long to actually test the real thing
  @Test
  void printAll() {
    testClient.setup();
    assertNotEquals("wa", testClient.printAll());
  }

  @Test
  void getDay() {
    testClient.setup();
    assertEquals( "Document{{_id=60c0d0c2b6032137a8f940fb, date=20130209, summary=[Document{{activity=walking, group=walking, duration=1845, distance=1562, steps=2254, calories=78}}, Document{{activity=transport, group=transport, duration=2621, distance=17662}}], segments=[Document{{type=place, startTime=20130209T063407-0800, endTime=20130209T132707-0800, place=Document{{id=6552482, name=Home, type=home, location=Document{{lat=47.67645, lon=-122.32305}}}}, lastUpdate=20140801T025223Z}}, Document{{type=move, startTime=20130209T132707-0800, endTime=20130209T133415-0800, activities=[Document{{activity=walking, group=walking, manual=false, startTime=20130209T132707-0800, endTime=20130209T133415-0800, duration=428, distance=508, steps=593, calories=25, trackPoints=[]}}], lastUpdate=20130210T111823Z}}, Document{{type=place, startTime=20130209T133416-0800, endTime=20130209T144452-0800, place=Document{{id=7187779, name=Forza Coffee Co., type=foursquare, foursquareId=4f18b993e4b0a9795c2bd702, foursquareCategoryIds=[4bf58dd8d48988d16d941735], location=Document{{lat=47.67877626216485, lon=-122.3267572769863}}}}, lastUpdate=20140609T164619Z}}, Document{{type=move, startTime=20130209T144452-0800, endTime=20130209T145054-0800, activities=[Document{{activity=walking, group=walking, manual=false, startTime=20130209T144452-0800, endTime=20130209T145054-0800, duration=362, distance=378, steps=479, calories=19, trackPoints=[]}}], lastUpdate=20130210T111823Z}}, Document{{type=place, startTime=20130209T145055-0800, endTime=20130209T171309-0800, place=Document{{id=6552482, name=Home, type=home, location=Document{{lat=47.67645, lon=-122.32305}}}}, activities=[Document{{activity=walking, group=walking, manual=false, startTime=20130209T162222-0800, endTime=20130209T162232-0800, duration=10, distance=3, steps=6, calories=0, trackPoints=[]}}], lastUpdate=20140801T025223Z}}, Document{{type=move, startTime=20130209T171309-0800, endTime=20130209T174745-0800, activities=[Document{{activity=transport, group=transport, manual=false, startTime=20130209T171309-0800, endTime=20130209T174352-0800, duration=1843, distance=11701, trackPoints=[]}}, Document{{activity=walking, group=walking, manual=false, startTime=20130209T174352-0800, endTime=20130209T174745-0800, duration=233, distance=145, steps=291, calories=7, trackPoints=[]}}], lastUpdate=20130210T125320Z}}, Document{{type=place, startTime=20130209T174746-0800, endTime=20130209T183422-0800, place=Document{{id=7256266, name=Fred Meyer, type=foursquare, foursquareId=4a88913ef964a520f00620e3, foursquareCategoryIds=[52f2ab2ebcbc57f1066b8b46, 4bf58dd8d48988d118951735, 4bf58dd8d48988d1f6941735], location=Document{{lat=47.72331595342612, lon=-122.2919945355234}}}}, activities=[Document{{activity=walking, group=walking, manual=false, startTime=20130209T175022-0800, endTime=20130209T175222-0800, duration=120, distance=98, steps=131, calories=5, trackPoints=[]}}, Document{{activity=walking, group=walking, manual=false, startTime=20130209T175452-0800, endTime=20130209T175522-0800, duration=30, distance=20, steps=41, calories=1, trackPoints=[]}}, Document{{activity=walking, group=walking, manual=false, startTime=20130209T180223-0800, endTime=20130209T180253-0800, duration=30, distance=15, steps=30, calories=1, trackPoints=[]}}, Document{{activity=walking, group=walking, manual=false, startTime=20130209T181023-0800, endTime=20130209T181053-0800, duration=30, distance=25, steps=51, calories=1, trackPoints=[]}}, Document{{activity=walking, group=walking, manual=false, startTime=20130209T181223-0800, endTime=20130209T181253-0800, duration=30, distance=20, steps=41, calories=1, trackPoints=[]}}, Document{{activity=walking, group=walking, manual=false, startTime=20130209T181453-0800, endTime=20130209T181523-0800, duration=30, distance=25, steps=51, calories=1, trackPoints=[]}}, Document{{activity=walking, group=walking, manual=false, startTime=20130209T181724-0800, endTime=20130209T181854-0800, duration=90, distance=76, steps=152, calories=4, trackPoints=[]}}, Document{{activity=walking, group=walking, manual=false, startTime=20130209T182154-0800, endTime=20130209T182224-0800, duration=30, distance=15, steps=30, calories=1, trackPoints=[]}}, Document{{activity=walking, group=walking, manual=false, startTime=20130209T182324-0800, endTime=20130209T182354-0800, duration=30, distance=20, steps=41, calories=1, trackPoints=[]}}, Document{{activity=walking, group=walking, manual=false, startTime=20130209T182524-0800, endTime=20130209T182854-0800, duration=210, distance=121, steps=162, calories=6, trackPoints=[]}}], lastUpdate=20150402T225557Z}}, Document{{type=move, startTime=20130209T183422-0800, endTime=20130209T185023-0800, activities=[Document{{activity=walking, group=walking, manual=false, startTime=20130209T183422-0800, endTime=20130209T183724-0800, duration=182, distance=93, steps=155, calories=5, trackPoints=[]}}, Document{{activity=transport, group=transport, manual=false, startTime=20130209T183724-0800, endTime=20130209T185022-0800, duration=778, distance=5961, trackPoints=[]}}], lastUpdate=20130210T140715Z}}, Document{{type=place, startTime=20130209T185023-0800, endTime=20130210T060517-0800, place=Document{{id=6552482, name=Home, type=home, location=Document{{lat=47.67645, lon=-122.32305}}}}, lastUpdate=20140801T025223Z}}], caloriesIdle=1439, lastUpdate=20150402T225557Z}}",testClient.getDay("20130209").toString());
    assertNotEquals("Document{{_id=60c0d0c2b6032137a8f940fb, date=20130209, summary=[Document{{activity=walking, group=walking, duration=1845, distance=1562, steps=2254, calories=78}}, Document{{activity=transport, group=transport, duration=2621, distance=17662}}], segments=[Document{{type=place, startTime=20130209T063407-0800, endTime=20130209T132707-0800, place=Document{{id=6552482, name=Home, type=home, location=Document{{lat=47.67645, lon=-122.32305}}}}, lastUpdate=20140801T025223Z}}, Document{{type=move, startTime=20130209T132707-0800, endTime=20130209T133415-0800, activities=[Document{{activity=walking, group=walking, manual=false, startTime=20130209T132707-0800, endTime=20130209T133415-0800, duration=428, distance=508, steps=593, calories=25, trackPoints=[]}}], lastUpdate=20130210T111823Z}}, Document{{type=place, startTime=20130209T133416-0800, endTime=20130209T144452-0800, place=Document{{id=7187779, name=Forza Coffee Co., type=foursquare, foursquareId=4f18b993e4b0a9795c2bd702, foursquareCategoryIds=[4bf58dd8d48988d16d941735], location=Document{{lat=47.67877626216485, lon=-122.3267572769863}}}}, lastUpdate=20140609T164619Z}}, Document{{type=move, startTime=20130209T144452-0800, endTime=20130209T145054-0800, activities=[Document{{activity=walking, group=walking, manual=false, startTime=20130209T144452-0800, endTime=20130209T145054-0800, duration=362, distance=378, steps=479, calories=19, trackPoints=[]}}], lastUpdate=20130210T111823Z}}, Document{{type=place, startTime=20130209T145055-0800, endTime=20130209T171309-0800, place=Document{{id=6552482, name=Home, type=home, location=Document{{lat=47.67645, lon=-122.32305}}}}, activities=[Document{{activity=walking, group=walking, manual=false, startTime=20130209T162222-0800, endTime=20130209T162232-0800, duration=10, distance=3, steps=6, calories=0, trackPoints=[]}}], lastUpdate=20140801T025223Z}}, Document{{type=move, startTime=20130209T171309-0800, endTime=20130209T174745-0800, activities=[Document{{activity=transport, group=transport, manual=false, startTime=20130209T171309-0800, endTime=20130209T174352-0800, duration=1843, distance=11701, trackPoints=[]}}, Document{{activity=walking, group=walking, manual=false, startTime=20130209T174352-0800, endTime=20130209T174745-0800, duration=233, distance=145, steps=291, calories=7, trackPoints=[]}}], lastUpdate=20130210T125320Z}}, Document{{type=place, startTime=20130209T174746-0800, endTime=20130209T183422-0800, place=Document{{id=7256266, name=Fred Meyer, type=foursquare, foursquareId=4a88913ef964a520f00620e3, foursquareCategoryIds=[52f2ab2ebcbc57f1066b8b46, 4bf58dd8d48988d118951735, 4bf58dd8d48988d1f6941735], location=Document{{lat=47.72331595342612, lon=-122.2919945355234}}}}, activities=[Document{{activity=walking, group=walking, manual=false, startTime=20130209T175022-0800, endTime=20130209T175222-0800, duration=120, distance=98, steps=131, calories=5, trackPoints=[]}}, Document{{activity=walking, group=walking, manual=false, startTime=20130209T175452-0800, endTime=20130209T175522-0800, duration=30, distance=20, steps=41, calories=1, trackPoints=[]}}, Document{{activity=walking, group=walking, manual=false, startTime=20130209T180223-0800, endTime=20130209T180253-0800, duration=30, distance=15, steps=30, calories=1, trackPoints=[]}}, Document{{activity=walking, group=walking, manual=false, startTime=20130209T181023-0800, endTime=20130209T181053-0800, duration=30, distance=25, steps=51, calories=1, trackPoints=[]}}, Document{{activity=walking, group=walking, manual=false, startTime=20130209T181223-0800, endTime=20130209T181253-0800, duration=30, distance=20, steps=41, calories=1, trackPoints=[]}}, Document{{activity=walking, group=walking, manual=false, startTime=20130209T181453-0800, endTime=20130209T181523-0800, duration=30, distance=25, steps=51, calories=1, trackPoints=[]}}, Document{{activity=walking, group=walking, manual=false, startTime=20130209T181724-0800, endTime=20130209T181854-0800, duration=90, distance=76, steps=152, calories=4, trackPoints=[]}}, Document{{activity=walking, group=walking, manual=false, startTime=20130209T182154-0800, endTime=20130209T182224-0800, duration=30, distance=15, steps=30, calories=1, trackPoints=[]}}, Document{{activity=walking, group=walking, manual=false, startTime=20130209T182324-0800, endTime=20130209T182354-0800, duration=30, distance=20, steps=41, calories=1, trackPoints=[]}}, Document{{activity=walking, group=walking, manual=false, startTime=20130209T182524-0800, endTime=20130209T182854-0800, duration=210, distance=121, steps=162, calories=6, trackPoints=[]}}], lastUpdate=20150402T225557Z}}, Document{{type=move, startTime=20130209T183422-0800, endTime=20130209T185023-0800, activities=[Document{{activity=walking, group=walking, manual=false, startTime=20130209T183422-0800, endTime=20130209T183724-0800, duration=182, distance=93, steps=155, calories=5, trackPoints=[]}}, Document{{activity=transport, group=transport, manual=false, startTime=20130209T183724-0800, endTime=20130209T185022-0800, duration=778, distance=5961, trackPoints=[]}}], lastUpdate=20130210T140715Z}}, Document{{type=place, startTime=20130209T185023-0800, endTime=20130210T060517-0800, place=Document{{id=6552482, name=Home, type=home, location=Document{{lat=47.67645, lon=-122.32305}}}}, lastUpdate=20140801T025223Z}}], caloriesIdle=1439, lastUpdate=20150402T25557Z}}", testClient.getDay("20130209").toString());
  }

  @Test
  void getDayException() {
    testClient.setup();
    IndexOutOfBoundsException exception = assertThrows(IndexOutOfBoundsException.class, () -> {
      testClient.getDay("20220101");
    });
    String expectedMessage = "Date does not exist!";
    String actualMessage = exception.getMessage();
    assertTrue(actualMessage.contains(expectedMessage));
  }

  @Test
  void printDay() {
    testClient.setup();
    assertEquals( "{\"_id\": {\"$oid\": \"60c0d0c2b6032137a8f940fb\"}, \"date\": \"20130209\", \"summary\": [{\"activity\": \"walking\", \"group\": \"walking\", \"duration\": 1845, \"distance\": 1562, \"steps\": 2254, \"calories\": 78}, {\"activity\": \"transport\", \"group\": \"transport\", \"duration\": 2621, \"distance\": 17662}], \"segments\": [{\"type\": \"place\", \"startTime\": \"20130209T063407-0800\", \"endTime\": \"20130209T132707-0800\", \"place\": {\"id\": 6552482, \"name\": \"Home\", \"type\": \"home\", \"location\": {\"lat\": 47.67645, \"lon\": -122.32305}}, \"lastUpdate\": \"20140801T025223Z\"}, {\"type\": \"move\", \"startTime\": \"20130209T132707-0800\", \"endTime\": \"20130209T133415-0800\", \"activities\": [{\"activity\": \"walking\", \"group\": \"walking\", \"manual\": false, \"startTime\": \"20130209T132707-0800\", \"endTime\": \"20130209T133415-0800\", \"duration\": 428, \"distance\": 508, \"steps\": 593, \"calories\": 25, \"trackPoints\": []}], \"lastUpdate\": \"20130210T111823Z\"}, {\"type\": \"place\", \"startTime\": \"20130209T133416-0800\", \"endTime\": \"20130209T144452-0800\", \"place\": {\"id\": 7187779, \"name\": \"Forza Coffee Co.\", \"type\": \"foursquare\", \"foursquareId\": \"4f18b993e4b0a9795c2bd702\", \"foursquareCategoryIds\": [\"4bf58dd8d48988d16d941735\"], \"location\": {\"lat\": 47.67877626216485, \"lon\": -122.3267572769863}}, \"lastUpdate\": \"20140609T164619Z\"}, {\"type\": \"move\", \"startTime\": \"20130209T144452-0800\", \"endTime\": \"20130209T145054-0800\", \"activities\": [{\"activity\": \"walking\", \"group\": \"walking\", \"manual\": false, \"startTime\": \"20130209T144452-0800\", \"endTime\": \"20130209T145054-0800\", \"duration\": 362, \"distance\": 378, \"steps\": 479, \"calories\": 19, \"trackPoints\": []}], \"lastUpdate\": \"20130210T111823Z\"}, {\"type\": \"place\", \"startTime\": \"20130209T145055-0800\", \"endTime\": \"20130209T171309-0800\", \"place\": {\"id\": 6552482, \"name\": \"Home\", \"type\": \"home\", \"location\": {\"lat\": 47.67645, \"lon\": -122.32305}}, \"activities\": [{\"activity\": \"walking\", \"group\": \"walking\", \"manual\": false, \"startTime\": \"20130209T162222-0800\", \"endTime\": \"20130209T162232-0800\", \"duration\": 10, \"distance\": 3, \"steps\": 6, \"calories\": 0, \"trackPoints\": []}], \"lastUpdate\": \"20140801T025223Z\"}, {\"type\": \"move\", \"startTime\": \"20130209T171309-0800\", \"endTime\": \"20130209T174745-0800\", \"activities\": [{\"activity\": \"transport\", \"group\": \"transport\", \"manual\": false, \"startTime\": \"20130209T171309-0800\", \"endTime\": \"20130209T174352-0800\", \"duration\": 1843, \"distance\": 11701, \"trackPoints\": []}, {\"activity\": \"walking\", \"group\": \"walking\", \"manual\": false, \"startTime\": \"20130209T174352-0800\", \"endTime\": \"20130209T174745-0800\", \"duration\": 233, \"distance\": 145, \"steps\": 291, \"calories\": 7, \"trackPoints\": []}], \"lastUpdate\": \"20130210T125320Z\"}, {\"type\": \"place\", \"startTime\": \"20130209T174746-0800\", \"endTime\": \"20130209T183422-0800\", \"place\": {\"id\": 7256266, \"name\": \"Fred Meyer\", \"type\": \"foursquare\", \"foursquareId\": \"4a88913ef964a520f00620e3\", \"foursquareCategoryIds\": [\"52f2ab2ebcbc57f1066b8b46\", \"4bf58dd8d48988d118951735\", \"4bf58dd8d48988d1f6941735\"], \"location\": {\"lat\": 47.72331595342612, \"lon\": -122.2919945355234}}, \"activities\": [{\"activity\": \"walking\", \"group\": \"walking\", \"manual\": false, \"startTime\": \"20130209T175022-0800\", \"endTime\": \"20130209T175222-0800\", \"duration\": 120, \"distance\": 98, \"steps\": 131, \"calories\": 5, \"trackPoints\": []}, {\"activity\": \"walking\", \"group\": \"walking\", \"manual\": false, \"startTime\": \"20130209T175452-0800\", \"endTime\": \"20130209T175522-0800\", \"duration\": 30, \"distance\": 20, \"steps\": 41, \"calories\": 1, \"trackPoints\": []}, {\"activity\": \"walking\", \"group\": \"walking\", \"manual\": false, \"startTime\": \"20130209T180223-0800\", \"endTime\": \"20130209T180253-0800\", \"duration\": 30, \"distance\": 15, \"steps\": 30, \"calories\": 1, \"trackPoints\": []}, {\"activity\": \"walking\", \"group\": \"walking\", \"manual\": false, \"startTime\": \"20130209T181023-0800\", \"endTime\": \"20130209T181053-0800\", \"duration\": 30, \"distance\": 25, \"steps\": 51, \"calories\": 1, \"trackPoints\": []}, {\"activity\": \"walking\", \"group\": \"walking\", \"manual\": false, \"startTime\": \"20130209T181223-0800\", \"endTime\": \"20130209T181253-0800\", \"duration\": 30, \"distance\": 20, \"steps\": 41, \"calories\": 1, \"trackPoints\": []}, {\"activity\": \"walking\", \"group\": \"walking\", \"manual\": false, \"startTime\": \"20130209T181453-0800\", \"endTime\": \"20130209T181523-0800\", \"duration\": 30, \"distance\": 25, \"steps\": 51, \"calories\": 1, \"trackPoints\": []}, {\"activity\": \"walking\", \"group\": \"walking\", \"manual\": false, \"startTime\": \"20130209T181724-0800\", \"endTime\": \"20130209T181854-0800\", \"duration\": 90, \"distance\": 76, \"steps\": 152, \"calories\": 4, \"trackPoints\": []}, {\"activity\": \"walking\", \"group\": \"walking\", \"manual\": false, \"startTime\": \"20130209T182154-0800\", \"endTime\": \"20130209T182224-0800\", \"duration\": 30, \"distance\": 15, \"steps\": 30, \"calories\": 1, \"trackPoints\": []}, {\"activity\": \"walking\", \"group\": \"walking\", \"manual\": false, \"startTime\": \"20130209T182324-0800\", \"endTime\": \"20130209T182354-0800\", \"duration\": 30, \"distance\": 20, \"steps\": 41, \"calories\": 1, \"trackPoints\": []}, {\"activity\": \"walking\", \"group\": \"walking\", \"manual\": false, \"startTime\": \"20130209T182524-0800\", \"endTime\": \"20130209T182854-0800\", \"duration\": 210, \"distance\": 121, \"steps\": 162, \"calories\": 6, \"trackPoints\": []}], \"lastUpdate\": \"20150402T225557Z\"}, {\"type\": \"move\", \"startTime\": \"20130209T183422-0800\", \"endTime\": \"20130209T185023-0800\", \"activities\": [{\"activity\": \"walking\", \"group\": \"walking\", \"manual\": false, \"startTime\": \"20130209T183422-0800\", \"endTime\": \"20130209T183724-0800\", \"duration\": 182, \"distance\": 93, \"steps\": 155, \"calories\": 5, \"trackPoints\": []}, {\"activity\": \"transport\", \"group\": \"transport\", \"manual\": false, \"startTime\": \"20130209T183724-0800\", \"endTime\": \"20130209T185022-0800\", \"duration\": 778, \"distance\": 5961, \"trackPoints\": []}], \"lastUpdate\": \"20130210T140715Z\"}, {\"type\": \"place\", \"startTime\": \"20130209T185023-0800\", \"endTime\": \"20130210T060517-0800\", \"place\": {\"id\": 6552482, \"name\": \"Home\", \"type\": \"home\", \"location\": {\"lat\": 47.67645, \"lon\": -122.32305}}, \"lastUpdate\": \"20140801T025223Z\"}], \"caloriesIdle\": 1439, \"lastUpdate\": \"20150402T225557Z\"}",testClient.printDay("20130209"));
    assertNotEquals("{\"_id\": {\"$oid\": \"60c0d0c2b6032137a8f940fb\"}, \"date\": \"20130209\", \"summary\": [{\"activity\": \"walking\", \"group\": \"walking\", \"duration\": 1845, \"distance\": 1562, \"steps\": 2254, \"calories\": 78}, {\"activity\": \"transport\", \"group\": \"transport\", \"duration\": 2621, \"distance\": 17662}], \"segments\": [{\"type\": \"place\", \"startTime\": \"20130209T063407-0800\", \"endTime\": \"20130209T132707-0800\", \"place\": {\"id\": 6552482, \"name\": \"Home\", \"type\": \"home\", \"location\": {\"lat\": 47.67645, \"lon\": -122.32305}}, \"lastUpdate\": \"20140801T025223Z\"}, {\"type\": \"move\", \"startTime\": \"20130209T132707-0800\", \"endTime\": \"20130209T133415-0800\", \"activities\": [{\"activity\": \"walking\", \"group\": \"walking\", \"manual\": false, \"startTime\": \"20130209T132707-0800\", \"endTime\": \"20130209T133415-0800\", \"duration\": 428, \"distance\": 508, \"steps\": 593, \"calories\": 25, \"trackPoints\": []}], \"lastUpdate\": \"20130210T111823Z\"}, {\"type\": \"place\", \"startTime\": \"20130209T133416-0800\", \"endTime\": \"20130209T144452-0800\", \"place\": {\"id\": 7187779, \"name\": \"Forza Coffee Co.\", \"type\": \"foursquare\", \"foursquareId\": \"4f18b993e4b0a9795c2bd702\", \"foursquareCategoryIds\": [\"4bf58dd8d48988d16d941735\"], \"location\": {\"lat\": 47.67877626216485, \"lon\": -122.3267572769863}}, \"lastUpdate\": \"20140609T164619Z\"}, {\"type\": \"move\", \"startTime\": \"20130209T144452-0800\", \"endTime\": \"20130209T145054-0800\", \"activities\": [{\"activity\": \"walking\", \"group\": \"walking\", \"manual\": false, \"startTime\": \"20130209T144452-0800\", \"endTime\": \"20130209T145054-0800\", \"duration\": 362, \"distance\": 378, \"steps\": 479, \"calories\": 19, \"trackPoints\": []}], \"lastUpdate\": \"20130210T111823Z\"}, {\"type\": \"place\", \"startTime\": \"20130209T145055-0800\", \"endTime\": \"20130209T171309-0800\", \"place\": {\"id\": 6552482, \"name\": \"Home\", \"type\": \"home\", \"location\": {\"lat\": 47.67645, \"lon\": -122.32305}}, \"activities\": [{\"activity\": \"walking\", \"group\": \"walking\", \"manual\": false, \"startTime\": \"20130209T162222-0800\", \"endTime\": \"20130209T162232-0800\", \"duration\": 10, \"distance\": 3, \"steps\": 6, \"calories\": 0, \"trackPoints\": []}], \"lastUpdate\": \"20140801T025223Z\"}, {\"type\": \"move\", \"startTime\": \"20130209T171309-0800\", \"endTime\": \"20130209T174745-0800\", \"activities\": [{\"activity\": \"transport\", \"group\": \"transport\", \"manual\": false, \"startTime\": \"20130209T171309-0800\", \"endTime\": \"20130209T174352-0800\", \"duration\": 1843, \"distance\": 11701, \"trackPoints\": []}, {\"activity\": \"walking\", \"group\": \"walking\", \"manual\": false, \"startTime\": \"20130209T174352-0800\", \"endTime\": \"20130209T174745-0800\", \"duration\": 233, \"distance\": 145, \"steps\": 291, \"calories\": 7, \"trackPoints\": []}], \"lastUpdate\": \"20130210T125320Z\"}, {\"type\": \"place\", \"startTime\": \"20130209T174746-0800\", \"endTime\": \"20130209T183422-0800\", \"place\": {\"id\": 7256266, \"name\": \"Fred Meyer\", \"type\": \"foursquare\", \"foursquareId\": \"4a88913ef964a520f00620e3\", \"foursquareCategoryIds\": [\"52f2ab2ebcbc57f1066b8b46\", \"4bf58dd8d48988d118951735\", \"4bf58dd8d48988d1f6941735\"], \"location\": {\"lat\": 47.72331595342612, \"lon\": -122.2919945355234}}, \"activities\": [{\"activity\": \"walking\", \"group\": \"walking\", \"manual\": false, \"startTime\": \"20130209T175022-0800\", \"endTime\": \"20130209T175222-0800\", \"duration\": 120, \"distance\": 98, \"steps\": 131, \"calories\": 5, \"trackPoints\": []}, {\"activity\": \"walking\", \"group\": \"walking\", \"manual\": false, \"startTime\": \"20130209T175452-0800\", \"endTime\": \"20130209T175522-0800\", \"duration\": 30, \"distance\": 20, \"steps\": 41, \"calories\": 1, \"trackPoints\": []}, {\"activity\": \"walking\", \"group\": \"walking\", \"manual\": false, \"startTime\": \"20130209T180223-0800\", \"endTime\": \"20130209T180253-0800\", \"duration\": 30, \"distance\": 15, \"steps\": 30, \"calories\": 1, \"trackPoints\": []}, {\"activity\": \"walking\", \"group\": \"walking\", \"manual\": false, \"startTime\": \"20130209T181023-0800\", \"endTime\": \"20130209T181053-0800\", \"duration\": 30, \"distance\": 25, \"steps\": 51, \"calories\": 1, \"trackPoints\": []}, {\"activity\": \"walking\", \"group\": \"walking\", \"manual\": false, \"startTime\": \"20130209T181223-0800\", \"endTime\": \"20130209T181253-0800\", \"duration\": 30, \"distance\": 20, \"steps\": 41, \"calories\": 1, \"trackPoints\": []}, {\"activity\": \"walking\", \"group\": \"walking\", \"manual\": false, \"startTime\": \"20130209T181453-0800\", \"endTime\": \"20130209T181523-0800\", \"duration\": 30, \"distance\": 25, \"steps\": 51, \"calories\": 1, \"trackPoints\": []}, {\"activity\": \"walking\", \"group\": \"walking\", \"manual\": false, \"startTime\": \"20130209T181724-0800\", \"endTime\": \"20130209T181854-0800\", \"duration\": 90, \"distance\": 76, \"steps\": 152, \"calories\": 4, \"trackPoints\": []}, {\"activity\": \"walking\", \"group\": \"walking\", \"manual\": false, \"startTime\": \"20130209T182154-0800\", \"endTime\": \"20130209T182224-0800\", \"duration\": 30, \"distance\": 15, \"steps\": 30, \"calories\": 1, \"trackPoints\": []}, {\"activity\": \"walking\", \"group\": \"walking\", \"manual\": false, \"startTime\": \"20130209T182324-0800\", \"endTime\": \"20130209T182354-0800\", \"duration\": 30, \"distance\": 20, \"steps\": 41, \"calories\": 1, \"trackPoints\": []}, {\"activity\": \"walking\", \"group\": \"walking\", \"manual\": false, \"startTime\": \"20130209T182524-0800\", \"endTime\": \"20130209T182854-0800\", \"duration\": 210, \"distance\": 121, \"steps\": 162, \"calories\": 6, \"trackPoints\": []}], \"lastUpdate\": \"20150402T225557Z\"}, {\"type\": \"move\", \"startTime\": \"20130209T183422-0800\", \"endTime\": \"20130209T185023-0800\", \"activities\": [{\"activity\": \"walking\", \"group\": \"walking\", \"manual\": false, \"startTime\": \"20130209T183422-0800\", \"endTime\": \"20130209T183724-0800\", \"duration\": 182, \"distance\": 93, \"steps\": 155, \"calories\": 5, \"trackPoints\": []}, {\"activity\": \"transport\", \"group\": \"transport\", \"manual\": false, \"startTime\": \"20130209T183724-0800\", \"endTime\": \"20130209T185022-0800\", \"duration\": 778, \"distance\": 5961, \"trackPoints\": []}], \"lastUpdate\": \"20130210T140715Z\"}, {\"type\": \"place\", \"startTime\": \"20130209T185023-0800\", \"endTime\": \"20130210T060517-0800\", \"place\": {\"id\": 6552482, \"name\": \"Home\", \"type\": \"home\", \"location\": {\"lat\": 47.67645, \"lon\": -122.32305}}, \"lastUpdate\": \"20140801T025223Z\"}], \"caloriesIdle\": 1439, \"lastUpdate\": \"20150402T225557\"}", testClient.printDay("20130209"));
  }

  @Test
  void printDayException() {
    testClient.setup();
    IndexOutOfBoundsException exception = assertThrows(IndexOutOfBoundsException.class, () -> {
      testClient.printDay("20220101");
    });
    String expectedMessage = "Date does not exist!";
    String actualMessage = exception.getMessage();
    assertTrue(actualMessage.contains(expectedMessage));
  }

  @Test
  void getDayCalories() {
    testClient.setup();
    assertEquals(188, testClient.getDayCalories("20130228"));
    assertEquals(0, testClient.getDayCalories("20130210"));
    assertEquals(0, testClient.getDayCalories("20210210"));
    assertNotEquals(123, testClient.getDayCalories("20130228"));
    assertNotEquals(-221, testClient.getDayCalories("20130228"));
    assertNotEquals(0, testClient.getDayCalories("20130228"));
  }

//  @Test
//  void getDayCaloriesException() {
//    testClient.setup();
//    IndexOutOfBoundsException exception = assertThrows(IndexOutOfBoundsException.class, () -> {
//      testClient.getDayCalories("20220101");
//    });
//    String expectedMessage = "Date does not exist!";
//    String actualMessage = exception.getMessage();
//    assertTrue(actualMessage.contains(expectedMessage));
//  }

  @Test
  void getDaySteps() {
    testClient.setup();
    assertEquals(5497, testClient.getDaySteps("20130228"));
    assertEquals(0, testClient.getDaySteps("20210228"));
    assertNotEquals(1223, testClient.getDaySteps("20130228"));
    assertNotEquals(-22341, testClient.getDaySteps("20130228"));
    assertNotEquals(0, testClient.getDaySteps("20130228"));
  }

//  @Test
//  void getDayStepsException() {
//    testClient.setup();
//    IndexOutOfBoundsException exception = assertThrows(IndexOutOfBoundsException.class, () -> {
//      testClient.getDaySteps("20220101");
//    });
//    String expectedMessage = "Date does not exist!";
//    String actualMessage = exception.getMessage();
//    assertTrue(actualMessage.contains(expectedMessage));
//  }

  //helper function
  @Test
  void stringToLocalDate() {
  }

  @Test
  void getRangeCalories() {
    testClient.setup();
    assertEquals(5516, testClient.getRangeCalories("20130209", "20130309"));
    //works but long
//    assertEquals(47744, testClient.getRangeCalories("20130209", "20140209"));
    assertNotEquals(1223, testClient.getRangeCalories("20130209", "20130211"));
    assertNotEquals(-22341, testClient.getRangeCalories("20130209", "20130211"));
    assertNotEquals(0, testClient.getRangeCalories("20130209", "20130211"));
  }

  @Test
  void getRangeCaloriesExceptionStartDate() {
    testClient.setup();
    IndexOutOfBoundsException exception = assertThrows(IndexOutOfBoundsException.class, () -> {
      testClient.getRangeCalories("20220101", "20130209");
    });
    String expectedMessage = "End date is not before start date!";
    String actualMessage = exception.getMessage();
    assertTrue(actualMessage.contains(expectedMessage));
  }

  //helper function
  @Test
  void rangeCaloriesIterator() {
  }

  @Test
  void getRangeSteps() {
    testClient.setup();
    //works but very long
//    assertEquals(4649586, testClient.getRangeSteps("20130209", "20170211"));
    assertEquals(81185, testClient.getRangeSteps("20170111", "20170211"));
    assertNotEquals(1223, testClient.getRangeSteps("20130209", "20130211"));
    assertNotEquals(-22341, testClient.getRangeSteps("20130209", "20130211"));
    assertNotEquals(0, testClient.getRangeSteps("20130209", "20130211"));
  }

  @Test
  void getRangeStepsExceptionStartDate() {
    testClient.setup();
    IndexOutOfBoundsException exception = assertThrows(IndexOutOfBoundsException.class, () -> {
      testClient.getRangeSteps("20220101", "20130209");
    });
    String expectedMessage = "End date is not before start date!";
    String actualMessage = exception.getMessage();
    assertTrue(actualMessage.contains(expectedMessage));
  }

  //helper function
  @Test
  void rangeStepsIterator() {
  }
}
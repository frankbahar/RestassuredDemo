package restassureddemo;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.given;

public class RestAssuredDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//BaseURL or Host
		RestAssured.baseURI="https://maps.googleapis.com";
		given().param("location","-33.8670522,151.1957362").
				param("radius","500").
				param("key", "AIzaSyDuIqW0LZNQW0RwXHplJi4srWbP9pPjCvA").
				when().get("/maps/api/place/nearbysearch/json").
				then().assertThat().statusCode(200).
				and().contentType(ContentType.JSON).
				and().body("results[0].geometry.location.lat", equalTo("-33.8688197"));
	}

}

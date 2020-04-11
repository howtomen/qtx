package qtx;

import org.testng.annotations.Test;
import POJO.UserPojo;
import io.restassured.path.json.JsonPath;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONObject;

public class ApiTests {
	@Test
	public void Problem1() {
		String api = "https://reqres.in/api/users?id=2";
		when()
			.get(api)
		.then()
			.statusCode(200)
			.assertThat()
			.body("data.email", equalTo("janet.weaver@reqres.in"));
	}

	@SuppressWarnings("unchecked")
	@Test
	public void Problem2() {
		String api = "https://reqres.in/api/login";
		JSONObject login = new JSONObject();
		
		login.put("email", "eve.holt@reqres.in");
		login.put("password", "cityslicka");
		String jsonString = login.toJSONString();
		given()
			.contentType("application/json")
			.body(jsonString)
		.when()
			.post(api)
		.then()
			.statusCode(200)
			.contentType("application/json")
			.body("token", equalTo("QpwL5tke4Pnpja7X4"));
	}
	
	@Test
	public void Problem3() {
		String api = "https://reqres.in/api/users?page=2";
		given()
		.when()
			.delete(api)
		.then()
			.assertThat()
			.statusCode(204);
		//status code 204 is a no content success code
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void Problem4() {
		String api = "https://reqres.in/api/users/2";
		JSONObject newUser = new JSONObject();
		newUser.put("name", "Morpheus2");
		newUser.put("job", "zion resident");
		String UpdateAt = given()
			.contentType("application/json")
			.body(newUser.toJSONString())
		.when()
			.patch(api)
		.then()
			.contentType("application/json")
			.statusCode(200)
			.body("name", equalTo("Morpheus2"))
		.extract()
			.path("updatedAt")
			.toString();
		System.out.println(UpdateAt);
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void Problem5() {
		String api = "https://reqres.in/api/users/2";
		JSONObject newUser = new JSONObject();
		newUser.put("name", "Morpheus2");
		newUser.put("job", "zion resident");
		String UpdateAt = given()
			.contentType("application/json")
			.body(newUser.toJSONString())
		.when()
			.put(api)
		.then()
			.contentType("application/json")
			.statusCode(200)
			.body("name", equalTo("Morpheus2"))
		.extract()
			.path("updatedAt")
			.toString();
		System.out.println(UpdateAt);
	}
	
	@Test
	public void Problem6() {
		String api = "https://reqres.in/api/users/2";
		JsonPath json = given()
				.when()
					.get(api)
				.then()
					.contentType("application/json")
					.statusCode(200)
					.body("data.first_name", equalTo("Janet"))
				.extract()
					.jsonPath();
		
		String first_name = json.get("data.first_name").toString();
		String last_name = json.get("data.last_name").toString();
		String id = json.get("data.id").toString();
		String avatar = json.get("data.avatar").toString();
		String email = json.get("data.email").toString();
		UserPojo user = new UserPojo(first_name, last_name, id, email, avatar);
		user.PrintUser();
		
	}
	
	@Test
	public void Problem7()  {
		String api = "https://reqres.in/api/users?page=2";
		List <UserPojo> userList = new ArrayList<>();
		JsonPath json = given()
				.when()
					.get(api)
				.then()
					.contentType("application/json")
					.statusCode(200)
				.extract()
					.jsonPath();
		//System.out.println(json.get("data").toString());  #used to test i was getting correct json info
		for(int i = 0; i < 6; i++ ) {
			String first_name = json.get("data[" + i + "].first_name").toString();
			String last_name = json.get("data[" + i + "].last_name").toString();
			String id = json.get("data[" + i + "].id").toString();
			String avatar = json.get("data[" + i + "].avatar").toString();
			String email = json.get("data[" + i + "].email").toString();
			UserPojo user = new UserPojo(first_name, last_name, id, email, avatar);
			userList.add(i, user);
			
		}
		for(UserPojo user : userList) {
			user.PrintUser();
		}		
	}
}	


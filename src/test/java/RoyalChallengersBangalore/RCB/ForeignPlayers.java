package RoyalChallengersBangalore.RCB;

import java.io.FileNotFoundException;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Assert;
import org.testng.annotations.Test;


import io.restassured.path.json.JsonPath;

import java.io.FileReader;
import java.io.IOException;

public class ForeignPlayers {
	
	@Test
	public static void getForeignPlayers() throws FileNotFoundException, IOException, ParseException {

		Object obj = new JSONParser()
				.parse(new FileReader("C:\\Users\\002XAW744\\eclipse-workspace\\RCB\\src\\test\\java\\TeamRCB.json"));
		JSONObject jo = (JSONObject) obj;
		String response = jo.get("player").toString();
		int foreignPlayers = 0;
		JsonPath js = new JsonPath(response);
		int count = js.getInt("country.size()");
		for (int i = 0; i < count; i++) {
			if (!js.get("country[" + i + "]").equals("India"))
				foreignPlayers++;

		}

		Assert.assertEquals(4, foreignPlayers);

	}

	@Test
	public static void getWicketKeeper() throws FileNotFoundException, IOException, ParseException {
		Object obj = new JSONParser()
				.parse(new FileReader("C:\\Users\\002XAW744\\eclipse-workspace\\RCB\\src\\test\\java\\TeamRCB.json"));
		JSONObject jo = (JSONObject) obj;
		String response = jo.get("player").toString();
		JsonPath js = new JsonPath(response);
		int count = js.getInt("country.size()");
		for (int j = 0; j < count; j++) {
			if (js.get("role[" + j + "]").equals("Wicket-keeper")) {
				String validWicket = js.get("role[" + j + "]");
				Assert.assertEquals("Wicket-keeper", validWicket);
			}

		}
	}

}

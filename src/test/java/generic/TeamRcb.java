package generic;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import io.restassured.path.json.JsonPath;

public class TeamRcb {
	
	//Reading data from Json File
	public static String teamDetails(String fileName) throws IOException {
		return new String(Files.readAllBytes(Paths.get(fileName))); 
	}
	
	//Getting the count of Foreign Players in the team
	public static int getForeignCountryPlayerCount(String fileName) throws IOException {
			JsonPath  js = new JsonPath(teamDetails(fileName));
			int foreignPlayerCount = 0;
			int countryCount = js.getInt("player.country.size()");
			for(int i=0; i<countryCount;i++) {
				if(!(js.get("player.country["+i+"]").equals("India"))){
					foreignPlayerCount++;
				}
			}
			
		return foreignPlayerCount;
	}
	
	//Checking if there is atleast one Wicket Keeper in the team
	public static boolean checkWicketkeepeerExists(String fileName) throws IOException {
		JsonPath  js = new JsonPath(teamDetails(fileName));
		boolean wkExists = false;
		int roleCount = js.getInt("player.role.size()");
		for(int i=0; i<roleCount;i++) {
			if(js.get("player.role["+i+"]").equals("Wicket-keeper")){
				wkExists = true;
			}
		}
	return wkExists;
		
	}
	
}

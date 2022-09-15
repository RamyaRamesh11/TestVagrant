package rcb;

import java.io.FileNotFoundException;
import java.io.IOException;
import org.json.simple.parser.ParseException;
import org.junit.Assert;
import org.testng.annotations.Test;

import generic.TeamRcb;

public class RcbPlayersTest {
	
	//Validating if the number of foreign players in the team are 4
	@Test
	public static void verifyForeignPlayerCountIsFour() throws FileNotFoundException, IOException, ParseException {
		Assert.assertEquals(4, TeamRcb.getForeignCountryPlayerCount("./src/test/java/TeamRCB.json"));
	}

	//Validating if there is atleast one wicket keeper in the team
	@Test
	public static void getWicketKeeper() throws FileNotFoundException, IOException, ParseException {
		Assert.assertTrue(TeamRcb.checkWicketkeepeerExists("./src/test/java/TeamRCB.json"));
	}

}

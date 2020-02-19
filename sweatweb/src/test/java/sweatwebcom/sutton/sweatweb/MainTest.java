package sweatwebcom.sutton.sweatweb;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MainTest {

	@Test
	public void toto() {
		
		String user = "a";
		String logDate = "b";
		String foodName = "c";
		String size = "d";
		String calories = "e";
		
		String insertQuery = "INSERT INTO userDietLog (USER,LOGDATE,FOODNAME,FOODSIZE,FOODCALORIES)VALUES "
				+ "('" + user + "','" + logDate + "','" + foodName +"','" + size +"'," + calories +");";
		
		String expected = "INSERT INTO userDietLog (USER,LOGDATE,FOODNAME,FOODSIZE,FOODCALORIES)VALUES ('a','b','c','d',e);";
		
		assertEquals(insertQuery, expected);
	}
}

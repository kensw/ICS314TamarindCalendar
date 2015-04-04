import java.util.*;
import java.io.*;
import static org.junit.Assert.*;

import org.junit.Test;


public class CalendarTest {

	@Test
	public void teststartUp() {
		
		String data = "3\n";
		InputStream stdin = System.in;
		try {
		  System.setIn(new ByteArrayInputStream(data.getBytes()));
		  Scanner scanner = new Scanner(System.in);
		  System.out.println(scanner.nextLine());
		} finally {
		  System.setIn(stdin);
		}
		
		assertNotNull("Testing Startup: NULL?", startUp());

	}

}

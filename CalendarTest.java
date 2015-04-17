import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.ByteArrayInputStream;

public class CalendarTest {
	
	private Calendar StartUp;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		StartUp = new Calendar();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCalendar() {
		fail("Not yet implemented");
	}

	@Test
	public void testStartUp() {
		assertEquals(1, 1);
		assertEquals(2, 2);
		assertEquals(3, 3);
	}

	@Test
	public void testGetVisibility() {
		assertEquals(1, 1);
		assertEquals(2, 2);
		assertEquals(3, 3);
	}

	@Test
	public void testGetDateTime() {
		assertEquals("20150310T130000", "20150310130000");
	}

	@Test
	public void testGetSummary() {		
		String summary = "studying for finals";
		assertEquals("studying for finals", summary);
		
		summary = "working on project";
		assertEquals("working on project", summary);
	}

	@Test
	public void testGetLocation() {
		String location = "my house";
		assertEquals("my house", location);
		
		location = "Hamilton Library";
		assertEquals("Hamilton Library", location);
	}

	@Test
	public void testGetPriority() {
		System.out.println("\n********TESTING N/A[0]********: ");
		Calendar cal = new Calendar();
		String result = cal.getPriority();
		assertEquals("PRIORITY:0\n", result);

		System.out.println("\n********TESTING HIGH[1]********: ");
		cal = new Calendar();
		result = cal.getPriority();
		assertEquals("PRIORITY:1\n", result);
		
		System.out.println("\n********TESTING MEDIUM[2]********: ");
		cal = new Calendar();
		result = cal.getPriority();
		assertEquals("PRIORITY:5\n", result);
		
		System.out.println("\n********TESTING LOW[3]********: ");
		cal = new Calendar();
		result = cal.getPriority();
		assertEquals("PRIORITY:9\n", result);
		
		
	}

	@Test
	public void testGetFilename() {
		fail("Not yet implemented");
	}

	@Test
	public void testCreateFile() {
		fail("Not yet implemented");
	}

	@Test
	public void testCompareTime() {
		fail("Not yet implemented");
	}

	@Test
	public void testMain() {
		fail("Not yet implemented");
	}

}

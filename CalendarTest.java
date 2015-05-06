import static org.junit.Assert.*;
import java.io.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class CalendarTest {
	
	private Calendar cal;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		cal = new Calendar();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testStartUp() {

		assertEquals(1, cal.startUp("1"));
		assertEquals(2, cal.startUp("2"));
		assertEquals(3, cal.startUp("3"));
		assertEquals(4, cal.startUp("4"));
	}
	

	@Test
	public void testGetVisibility() {
		assertEquals("CLASS:PUBLIC\n", cal.getVisibility("1"));
		assertEquals("CLASS:PRIVATE\n", cal.getVisibility("2"));
		assertEquals("CLASS:CONFIDENTIAL\n", cal.getVisibility("3"));
	}

	@Test
	public void testGetDateTime() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetSummary() {		
		assertEquals("SUMMARY: Studying for finals\n", cal.getSummary("Studying for finals"));
		assertEquals("SUMMARY: Going to the beach\n", cal.getSummary("Going to the beach"));
	}

	@Test
	public void testGetLocation() {
		assertEquals("LOCATION: Hamilton Library\n", cal.getSummary("Hamilton Library"));
		assertEquals("LOCATION: Home\n", cal.getSummary("Home"));
	}

	@Test
	public void testGetPriority() {
		assertEquals("PRIORITY:0\n", cal.getPriority("0"));
		assertEquals("PRIORITY:1\n", cal.getPriority("1"));
		assertEquals("PRIORITY:5\n", cal.getPriority("2"));
		assertEquals("PRIORITY:9\n", cal.getPriority("3"));
	}

	@Test
	public void testCompareTime() {
		assertEquals(-1, cal.compareTime("1100","1200"));
		assertEquals( 1, cal.compareTime("1100","1000"));
		assertEquals(-1, cal.compareTime("1100","1101"));
		assertEquals( 1, cal.compareTime("1101","1100"));
		assertEquals( 0, cal.compareTime("1101","1101"));
	}

}

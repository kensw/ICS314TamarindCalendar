import java.util.*;
import java.io.*;


/****************************************************************************
* 
* TEAM NAME:            Tamarind
* 
* MEMBERS               Ken Wallace, Kevin Nguyen, Gary Tang
* 
* HOMEWORK:             iCalendar Project
*
* CLASS:                ICS 314
*
* INSTRUCTOR:           Brent Auernheimer
*
* DATE:                 March 13, 2015
*              
* FILE:                 readEvent.java
*      
* DESCRIPTION:          Creates ics file from user input.
*
*****************************************************************************/
class readEvent {
   private static Scanner input;
   
   public readEvent() {
   }
  
   //Ask user for Start date or End date.
   //option = start, for start date
   //option = end, for end date
   public String getDateTime(String option) {   
      int year = 0;
      int month = 0;
      int day = 0;
      int hour = 0;
      int minute = 0;
      String result = "";
      String yearString = "";
      String monthString = "";
      String dayString = "";
      String hourString = "";
      String minuteString = "";
      String date = "";
      String time = "";
      //DSTART
      if(option.equals("start")) {
         System.out.println("\nPlease enter start date: ");
      }
      //DEND
      else {
         System.out.println("\nPlease enter end date: ");
      }
      //Asking for year
      System.out.print("Year: ");
      while (!input.hasNextInt() || (year = input.nextInt()) < 1000 || year > 9999) {
         input.nextLine();
         System.out.println("**INVALID: Please enter a 4-digit year.");
         System.out.print("Year: ");
      }    
      yearString = ((Integer) year).toString();
      input.nextLine();
      //Asking for month
      System.out.print("Month: ");
      while (!input.hasNextInt() || (month = input.nextInt()) < 1 || month > 12) {
         input.nextLine();
         System.out.println("**INVALID: Please enter a month from 1 to 12.");
         System.out.print("Month: ");
      }
      //Pads a 0 if month is not 2 digits
      if (month < 10) {
         monthString = "0" + month;
      }
      //2 digit month, no padding
      else {
         monthString = ((Integer)month).toString();
      }
      input.nextLine();
      //Asking for day
      System.out.print("Day: ");
      while (!input.hasNextInt() || (day = input.nextInt()) < 1 || day > 31) {
         input.nextLine();
         System.out.println("**INVALID: Please enter a day from 1 to 31.");
         System.out.print("Day: ");
      }
      //day is not 2 digit, add padding
      if (day < 10) {
         dayString = "0" + ((Integer)day).toString();
      }
      //day is 2-digit, no padding
      else {
         dayString = ((Integer)day).toString();
      }
      input.nextLine();
      //Asking for hour
      System.out.println("\nPlease enter the time in military time. (i.e. 4PM is 16)");
      System.out.print("Hour: ");
      while (!input.hasNextInt() || (hour = input.nextInt()) < 0 || hour > 24) {
         input.nextLine();
         System.out.println("**INVALID: Please enter a hour from 0 to 24");
         System.out.print("Hour: ");
      }
      //padding
      if (hour < 10) {
         hourString = "0" + ((Integer)hour).toString();
      }
      else {
         hourString = ((Integer)hour).toString();
      }
      input.nextLine();
      //Asking for minute
      System.out.print("Minute: ");
      while (!input.hasNextInt() || (minute = input.nextInt()) < 0 || minute > 59) {
         input.nextLine();
         System.out.println("**INVALID: Please enter minutes from 0 to 59");
         System.out.print("Minute: ");
      }
      //padding
      if (minute < 10) {
         minuteString = "0" + ((Integer)minute).toString();
      }
      else {
         minuteString = ((Integer)minute).toString();
      }
      input.nextLine();
      //Create DT
      date = yearString + monthString + dayString;
      time = hourString + minuteString;    
      result = date + "T" + time + "00Z";
      return result;
   }
  
   public static void main(String[] args) throws IOException {            
   String sDateTime = "";
   String eDateTime = "";
   String summaryIn, locationIn, begin, version, calscale, publish, calname,
		timezone, begin2, dStart, dEnd, classtype, location,
		summary, priority, end2, end;
   PrintWriter pw;
   readEvent event;
   int userChoice = 0;
 
   input = new Scanner(System.in);
   event = new readEvent();
   //Asking for visibility
   System.out.println("What is the visibility for this calendar?");
   System.out.println("[1] PUBLIC");
   System.out.println("[2] PRIVATE");
   System.out.println("[3] CONFIDENTIAL");
   System.out.print("Please type the corresponding number of choice: ");
   //Visibility must be between 1 and 3
   while (!input.hasNextInt() || (userChoice = input.nextInt()) < 1 || userChoice > 3) {
      input.nextLine();
      System.out.println("\n**INVALID: Please choose a number from 1 to 3.");
      System.out.println("What is the visibility for this calendar?");
      System.out.println("[1] PUBLIC");
      System.out.println("[2] PRIVATE");
      System.out.println("[3] CONFIDENTIAL");
      System.out.print("Please type the corresponding number of choice: ");		
   }
   //Storing visibility to class type
   if (userChoice == 1) {
      classtype = "CLASS:PUBLIC \n";
      System.out.println("Your choice: [1] PUBLIC");
   }
   else if (userChoice == 2) {
      classtype = "CLASS:PRIVATE \n";
      System.out.println("Your choice: [2] PRIVATE");
   }
      else {
         classtype = "CLASS:CONFIDENTIAL \n";
         System.out.println("Your choice: ...well that's confidential.");
      }
   input.nextLine();
   //Get start and end time.
   sDateTime = event.getDateTime("start");
   eDateTime = event.getDateTime("end");
   //Asking for summary
   System.out.println("\nPlease enter summary of event: ");
   summaryIn = input.nextLine();
   //Asking for location
   System.out.print("\nPlease enter location of event: ");
   locationIn = input.nextLine();
   //Asking for priority
   System.out.println("\nWhat is the priority of the event?");
   System.out.println("[0] N/A");
   System.out.println("[1] HIGH");
   System.out.println("[2] MEDIUM");
   System.out.println("[3] LOW");
   System.out.print("Please type the corresponding number of choice: ");
   //Priority must be between 0 and 3
   while (!input.hasNextInt() || (userChoice = input.nextInt()) < 0 || userChoice > 3) {
      input.nextLine();
      System.out.println("\n**INVALID: Please choose a number from 0 to 3.");
      System.out.println("What is the priority of the event?");
      System.out.println("[0] N/A");
      System.out.println("[1] HIGH");
      System.out.println("[2] MEDIUM");
      System.out.println("[3] LOW");
      System.out.print("Please type the corresponding number of choice: ");
   }
   //Storing priority to class type
   //0 no priority
   if (userChoice == 0) {
      priority = "PRIORITY:0 \n";
      System.out.println("Your choice: [0] N/A");
   }
   //1-4 high
   else if (userChoice == 1) {
      priority = "PRIORITY:1 \n";
      System.out.println("Your choice: [1] HIGH");
   }
      //5 medium
      else if (userChoice == 2) {
         priority = "PRIORITY:5 \n";
         System.out.println("Your choice: [2] MEDIUM");
      }
         //6-9 low
         else {
         	priority = "PRIORITY:9 \n";
         	System.out.println("Your choice: [3] LOW");
         }
   System.out.println("\nYour calendar event has finish propagating. Thank you.");    
   //Test output
   //System.out.println(sDateTime);
   //System.out.println(eDateTime);
   //System.out.println(summaryIn);
   //System.out.println(locationIn);
   //System.out.println(priorityIn);
   //Finalize values to write to file 
   begin = "BEGIN:VCALENDAR\n";
   version = "VERSION:2.0\n";
   calscale = "CALSCALE:GREGORIAN\n";
   publish = "METHOD:PUBLISH\n";
   calname = "X-WR-CALNAME:Tamarind\n";
   timezone = "X-WR-TIMEZONE:Pacific/Honolulu\n";
   begin2 = "BEGIN:VEVENT\n";
   //dStart = "DTSTART;TZID=Pacific/Honolulu:" + sDateTime + "\n";        
   //dEnd = "DTEND;TZID=Pacific/Honolulu:" + eDateTime + "\n";    
   //classtype = "CLASS:PUBLIC\n";
   //priority = "PRIORITY:" + priorityIn + "\n";
   dStart = "DTSTART:" + sDateTime + "\n";
   dEnd = "DTEND:" + eDateTime + "\n";
   location = "LOCATION:" + locationIn +"\n";
   summary = "SUMMARY:" + summaryIn + "\n";
   end2 = "END:VEVENT\n";
   end = "END:VCALENDAR\n";
   //Write content to file, testcalendar.ics
   pw = new PrintWriter(new FileWriter("testcalendar.ics"));
   pw.write(begin + version + publish + calscale + publish + calname + timezone + begin2 +
   dStart + dEnd + classtype + location + summary + priority + end2+ end);
   //Close streams
   pw.close();
   input.close();
   }
}

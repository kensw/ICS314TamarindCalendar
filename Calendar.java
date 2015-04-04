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
* FILE:                 Calendar.java
*      
* DESCRIPTION:          Creates ics file from user input.
*
*****************************************************************************/
class Calendar {
   private static Scanner input;
   
   public Calendar() {
      input = new Scanner(System.in);
   }
   
   public static class Event {
      public String begin, version, calscale, publish, calname, timezone, begin2, dStart, dEnd, classType, location, summary, priority, end, end2, filename;
      
      public Event() {
         begin = "BEGIN:VCALENDAR\n";
         version = "VERSION:2.0\n";
         calscale = "CALSCALE:GREGORIAN\n";
         publish = "METHOD:PUBLISH\n";
         calname = "X-WR-CALNAME:LonganCal\n";
         timezone = "X-WR-TIMEZONE:Pacific/Honolulu\n";
         begin2 = "BEGIN:VEVENT\n";
         //empty because user defines it
         dStart = "";
         dEnd = "";
         classType = "";
         location = "";
         summary = "";
         priority = "";
         end = "END:VEVENT\n";
         end2 = "END:VCALENDAR\n";
         //extra name to save the file as
         filename = "";
      }
      
      public void setStart(String result) {
         dStart = result;
      }
      
      public void setEnd(String result) {
         dEnd = result;
      }
      
      public void setVisibility(String result) {
         classType = result;
      }
      
      public void setLocation(String result) {
         location = result;
      }
      
      public void setSummary(String result) {
         summary = result;
      }
      
      public void setPriority(String result) {
         priority = result;
      }
      
      public void setFilename(String result) {
         filename = result;
      }
   }
   
   public int startUp() {
      int userChoice = 0;
      System.out.println("What would you like to do?");
      System.out.println("[1] Create a calendar event");
      System.out.println("[2] Compute free time from list of events");
      System.out.println("[3] Exit");
      System.out.print("Please type the corresponding number of choice: ");
      while (!input.hasNextInt() || (userChoice = input.nextInt()) < 1 || userChoice > 3) {
         System.out.println("\n**INVALID: Please choose a number from 1 to 3.");
         System.out.println("What would you like to do?");
         System.out.println("[1] Create a calendar event");
         System.out.println("[2] Compute free time from list of events");
         System.out.println("[3] Exit");
         System.out.print("Please type the corresponding number of choice: ");
      }
      if (userChoice == 1) {
         System.out.println("Your choice: [1] Create a calendar event\n");
         return userChoice;
      }
      else if (userChoice == 2) {
         System.out.println("Your choice: [2] Compute free time from list of events\n");
      }
         else {
            System.out.println("Your choice: [3] Exit\n");
         }
      input.nextLine();
      return userChoice;
   }
   
   public String getVisibility() {
      int userChoice = 0;
      String result = "";
      //Asking for visibility
      System.out.println("What is the visibility for this event?");
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
         result = "CLASS:PUBLIC\n";
         System.out.println("Your choice: [1] PUBLIC");
      }
      else if (userChoice == 2) {
         result = "CLASS:PRIVATE\n";
         System.out.println("Your choice: [2] PRIVATE");
      }
         else {
            result = "CLASS:CONFIDENTIAL\n";
            System.out.println("Your choice: ...well that's confidential.");
         }
      input.nextLine();
      return (result);
   }
   
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
         result = "DTSTART:";
         System.out.println("\nPlease enter start date: ");
      }
      //DEND
      else {
         result = "DTEND:";
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
      System.out.println("\nPlease enter the start time in military time. (i.e. 4PM is 16)");
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
      result = result + date + "T" + time + "00Z\n";
      return result;
   }
   
   public String getSummary() {
      String result = "";
      String temp = "SUMMARY:";
      System.out.println("\nPlease enter summary of event: ");
      result = input.nextLine();
      result = temp + result + "\n";
      return result;
   }
   
   public String getLocation() {
      String result = "";
      String temp = "LOCATION:";
      System.out.print("\nPlease enter location of event: ");
      result = input.nextLine();
      result = temp + result + "\n";
      return result;
   }

   public String getPriority() {
      int userChoice = 0;
      String result = "";
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
         result = "PRIORITY:0\n";
         System.out.println("Your choice: [0] N/A");
      }
      //1-4 high
      else if (userChoice == 1) {
         result = "PRIORITY:1\n";
         System.out.println("Your choice: [1] HIGH");
      }
         //5 medium
         else if (userChoice == 2) {
            result = "PRIORITY:5\n";
            System.out.println("Your choice: [2] MEDIUM");
         }
            //6-9 low
            else {
            	result = "PRIORITY:9\n";
            	System.out.println("Your choice: [3] LOW");
            }
      input.nextLine();
      return result;
   }
   
   public String getFilename() {
      //**currently does NOT error check if user inputs invalid characters that the operating system will not allow in filenames
      String result = "";
      System.out.print("\nFinally, please enter the filename to save as: ");
      result = input.nextLine();
      result = result + ".ics";
      return result;
   }
   
   public void createFile(Event event) throws IOException {
      PrintWriter pw = new PrintWriter(new FileWriter(event.filename));
      pw.write(event.begin + event.version + event.calscale + event.publish + event.calname + event.timezone + event.begin2 + event.dStart + event.dEnd + event.classType + event.location + event.summary + event.priority + event.end + event.end2);
      pw.close();
   }
     
   public static void main(String[] args) throws IOException {            
      Calendar cal = new Calendar();
      int userChoice = 0;
      int start = 0;
      
      System.out.println("Welcome!");
      //if they want to create an event
      while ((start = cal.startUp()) == 1 || start == 2) {
         if (start == 1) {
            Event event;
            event = new Event();
            //asking for visibility
            event.setVisibility(cal.getVisibility());
            //aasking for start and end times
            event.setStart(cal.getDateTime("start"));
            event.setEnd(cal.getDateTime("end"));
            event.setSummary(cal.getSummary());
            event.setLocation(cal.getLocation());
            event.setPriority(cal.getPriority());
            event.setFilename(cal.getFilename());
            cal.createFile(event);
            System.out.println("Your calendar event has finish propagating. Thank you.\n");
         }
         //if they want to compute free times between events
         else {
            
         }
      }
      //if they wanted to exit, they would hop out the loop
      System.out.println("Thank you. Good bye.");
      input.close();
   }
}
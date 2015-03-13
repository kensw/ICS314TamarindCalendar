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
class readEvent 
{
  private static Scanner input;
  
  public readEvent()
  {
    
  }
  
  //Ask user for Start date or End date.
  //option = start, for start date
  //option = end, for end date
  public String getDateTime(String option)
  {   
    int year = 0;
    int month = 0;
    int day = 0;
    int hour;
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
    if(option.equals("start"))
    {
      System.out.println("\nPlease enter start date: ");
    }
    
    //DEND
    else
    {
      System.out.println("\nPlease enter end date: ");
    }
    
    System.out.print("\nyear: ");
    
    while(!input.hasNextInt() || (year = input.nextInt()) < 1000 || year > 9999)
    {
      System.out.println("Please enter a 4-digit year:");
      
      if(!input.hasNextInt())
      {
        input.nextLine();
      }
    }
    
    yearString = ((Integer) year).toString();
    
    System.out.print("\nmonth: ");    
    while(!input.hasNextInt() || (month = input.nextInt()) < 1 || month > 12)
    {
      System.out.println("Please enter a month between 1 and 12:");
      
      if(!input.hasNextInt())
      {
        input.nextLine();
      }
    }
    
    //Pads a 0 if month is not 2 digits
    if(month < 10)
    {
      monthString = "0" + month;
      //System.out.println(monthString);
    }
    
    //2 digit month, no padding
    else
    {
      monthString = ((Integer)month).toString();
    }
    
    System.out.print("\nday: ");
    while(!input.hasNextInt() || (day = input.nextInt()) < 1 || day > 31)
    {
      System.out.println("Please enter a day between 1 and 31:");
      
      if(!input.hasNextInt())
      {
        input.nextLine();
      }
    }
    
    //day is not 2 digit, add padding
    if(day < 10)
    {
      dayString = "0" + ((Integer)day).toString();
      //System.out.println(dayString);
    }
    
    //day is 2-digit, no padding
    else
    {
      dayString = ((Integer)day).toString();
      //System.out.println(dayString);
    }
    
    System.out.println("\nPlease enter the time in military time: ");
    System.out.print("\nHour: ");
    
    while(!input.hasNextInt() || (hour = input.nextInt()) < 0 || hour > 24)
    {
      System.out.println("Please enter a hour between 0 and 24");
      
      if(!input.hasNextInt())
      {
        input.nextLine();
      }
    }
    
    if(hour < 10)
    {
      hourString = "0" + ((Integer)hour).toString();
    }
    
    else
    {
      hourString = ((Integer)hour).toString();
    }
    
    System.out.print("\nMinute: ");
    while(!input.hasNextInt() || (minute = input.nextInt()) < 0 || minute > 59)
    {
      System.out.println("Please enter minutes between 0 and 59");
      
      if(!input.hasNextInt())
      {
        input.nextLine();
      }
    }
    
    if(minute < 10)
    {
      minuteString = "0" + ((Integer)minute).toString();
    }
    
    else
    {
      minuteString = ((Integer)minute).toString();
    }
    
    //Create DT
    date = yearString + monthString + dayString;
    time = hourString + minuteString;    
    result = date + "T" + time + "00Z";
       
    return result;
  }
  
  public static void main(String[] args) throws IOException 
  {            
    String sDateTime = "";
    String eDateTime = "";
    String summaryIn;
    String locationIn;
    String begin;
    String version;
    String calscale;
    String publish;
    String calname;
    String timezone;
    String begin2;
    String dStart;
    String dEnd;
    String classtype;
    String location;
    String summary;
    String priority;
    String end2;
    String end;
    PrintWriter pw;
    //Scanner input;
    readEvent event;
    int userChoice = 0;
    
    input = new Scanner(System.in);
    event = new readEvent();
    
    
    //Ask user for visibility
    System.out.println("What is the visibility for this calendar? Please select one of the following: ");
    System.out.println("1 PUBLIC");
    System.out.println("2 PRIVATE");
    System.out.println("3 CONFIDENTIAL");
    
    //Visibility must be between 1 and 3
    while(!input.hasNextInt() || (userChoice = input.nextInt()) < 1 || userChoice > 3)
    {
      System.out.println("Please chose a number between 1 and 3.");
        
      if(!input.hasNextInt())
      {
        input.nextLine();
      }       
    }
    
    //Storing visibility to class type
    if(userChoice == 1)
    {
      classtype = "CLASS:PUBLIC \n";
    }
    
    else if(userChoice == 2)
    {
      classtype = "CLASS:PRIVATE \n";
    }
    
    else
    {
      classtype = "CLASS:CONFIDENTIAL \n";
    }

    //Get start and end time.
    sDateTime = event.getDateTime("start");
    eDateTime = event.getDateTime("end");
        
    //Ask user for summary
    //Brute force to fix bug......
    input = new Scanner(System.in);
    System.out.print("\nPlease enter summary of event: ");
    summaryIn = input.nextLine();
    
    //Ask user for location    
    System.out.print("\nPlease enter location of event: ");
    locationIn = input.nextLine();
    
    //Ask user for priority
    System.out.println("\nPlease select a priority of event: ");
    System.out.println("0 N/A");
    System.out.println("1 HIGH");
    System.out.println("2 MEDIUM");
    System.out.println("3 LOW");
    
    //Priority must be between 0 and 3
    while(!input.hasNextInt() || (userChoice = input.nextInt()) < 0 || userChoice > 3)
    {
      System.out.println("Please chose a number between 0 and 3.");
        
      if(!input.hasNextInt())
      {
        input.nextLine();
      }       
    }
    
    //Storing priority to class type
    //0 no priority
    if(userChoice == 0)
    {
      priority = "PRIORITY:0 \n";
    }
    
    //1-4 high
    else if(userChoice == 1)
    {
      priority = "PRIORITY:1 \n";
    }
    
    //5 medium
    else if(userChoice == 2)
    {
      priority = "PRIORITY:5 \n";
    }
    
    //6-9 low
    else
    {
      priority = "PRIORITY:9 \n";
    }
    
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
    calname = "X-WR-CALNAME:LonganCal\n";
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
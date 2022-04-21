import java.io.FileInputStream;
import java.io.FileNotFoundException;

import java.util.Scanner;

/**
 * Displays a full year of months and shows events tied to specific days within those months
 * @author Anthony Brown
 * @author JR Boos
 * @author Seth Spicer
 */
public class WolfPackCalendar {
    
    /** Number of days in a week */
    public static final int DAYS_IN_WEEK = 7;
    
    /** Largest possible number of days in a single month */
    public static final int MAX_DAYS_IN_MONTH = 31;
    
    /** Frequency of leap years in terms of number of years */
    public static final int LEAP_YEAR_FREQUENCY = 4;
    
    /** Number of months in a single year */
    public static final int MONTHS_IN_YEAR = 12;
    
    /** Number of years in a single century */
    public static final int YEARS_IN_CENTURY = 100;
    
    /** Represents Saturday in a range 0 - 6 */
    public static final int SATURDAY = 6;
            
    /** String array containing the names of the days of the week */                                    
    public static final String[] DAYS_OF_THE_WEEK = {"Sun",
                                                  "Mon",
                                                  "Tues",
                                                  "Wed",
                                                  "Thurs",
                                                  "Fri",
                                                  "Sat"};
                                             
    /** Array containing the months for a given year */      
    private Month[] months;

    /** Numeric value of the year, given on the command line */
    private int year; 

    /**
     * Constructs a new calendar given a numeric value for a year
     * @param year numeric value of the year, given on the command line
     */
    public WolfPackCalendar(int year) {
        if(year < 0) {
            throw new IllegalArgumentException("Invalid year");
        }
        
        this.year = year;
        
        int startDayValue = 1;
        months = new Month[MONTHS_IN_YEAR];
        for(Month.Months month : Month.ALL_MONTHS) {
            int index = month.ordinal();
            int currMonthValue = index + 1;
            
            months[index] = new Month(month, zellersAlgorithm(currMonthValue, startDayValue, year), year % LEAP_YEAR_FREQUENCY == 0);
        }
    }
    
    public WolfPackCalendar(int year, String notesFile) {
        this(year);
        processFile(notesFile);
    }
    
    /**
     * Prints a full month in a text format, including days of the week
     * @param index numeric value of month to print
     */
    public void printMonth(int index) {
        
        // Display month
        System.out.println("\t\t\t" + months[index].getName() + " " + year);
        
        // Display days of the week
        for(int i = 0; i < DAYS_OF_THE_WEEK.length; i++) {
            System.out.print(DAYS_OF_THE_WEEK[i] + "\t");
        }
        System.out.println();
        
        // Start month on correct day of the week
        for(int i = 0; i < months[index].getStartDayOfTheWeek(); i++) {
            System.out.print("\t");
        }
        
        // Display days of the month
        int currDay = 0;
        for(int i = 0; i < months[index].getNumberOfDays(); i++) {
            currDay++;
            System.out.print(currDay + "\t");
            
            if(zellersAlgorithm(index + 1, currDay, year) == SATURDAY) {
                System.out.println();
            }
        }
        System.out.println();
        
        months[index].printNotes();
    }
    
    /** Prints the entire year by repeating the printMonth method */
    public void printYear() {
        for(int i = 0; i < months.length; i++) {
            printMonth(i);
            System.out.println("\n");
        }
    }
    
    /**
     * Calculates the correct day of the week to start the month on
     * @param month numeric value of the month
     * @param day numeric value of the day
     * @param year numeric value of the year
     * @return day of the week the month starts on
     */
    public static int zellersAlgorithm(int month, int day, int year) {
        int w = year - (MONTHS_IN_YEAR + 2 - month) / MONTHS_IN_YEAR;
        int x = w + w / LEAP_YEAR_FREQUENCY - w / YEARS_IN_CENTURY + 
                w / (LEAP_YEAR_FREQUENCY * YEARS_IN_CENTURY);
        int z = month +  MONTHS_IN_YEAR * ((MONTHS_IN_YEAR + 2 - month) / MONTHS_IN_YEAR) - 2;

        int dayOfWeek = (day + x + (MAX_DAYS_IN_MONTH * z) / MONTHS_IN_YEAR) % DAYS_IN_WEEK;
        
        return dayOfWeek;
    }
    
    public void processLine(String line) {
        Scanner lineScanner = new Scanner(line);
        lineScanner.useDelimiter(",");
            
        int month = lineScanner.nextInt();
        int day = lineScanner.nextInt();
        
        String note = lineScanner.next();
        
        months[month - 1].addNote(day, note);
    }
    
    public void processFile(String filePath) {
        Scanner fileScanner = null;
        try {
            fileScanner = new Scanner(new FileInputStream(filePath));
        } catch (FileNotFoundException e) {
            throw new IllegalArgumentException("Unable to access input file: " + filePath);
        }
        
        while(fileScanner.hasNextLine()) {
            processLine(fileScanner.nextLine());
        }
    }
    
    /**
     * Takes the year as the first 
     * argument on the command line 
     * and prints the full year
     * @param args Command line arguments, used to determine calendar year
     *        and optional file containing important events
     */
    public static void main(String[] args) {
        if(args.length == 0) {
            System.out.println("Usage: java WolfPackCalendar year infile");
            System.exit(1);
        }
        
        WolfPackCalendar calendar = null;
        int year = 0;
        
        try {
            year = Integer.parseInt(args[0]);
        } catch(IllegalArgumentException e) {
            System.out.println("Invalid year");
            System.exit(1);
        }
        
        try {
            if(args.length == 1) {
                calendar = new WolfPackCalendar(year);
            } else if(args.length > 1) {
                calendar = new WolfPackCalendar(year, args[1]);
            }
        } catch(IllegalArgumentException e) {
            System.out.println(e.getMessage());
            System.exit(1);
        }
        
        try {
            calendar.printYear();
        } catch(NullPointerException e) {
            System.out.println(e.getMessage());
            System.exit(1);
        }
    }
}
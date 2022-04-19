import java.io.FileInputStream;
import java.io.FileNotFoundException;

import java.util.Scanner;

public class WolfPackCalendar {
    
    public static final String[] MONTH_NAMES = {"January",
                                           "February",
                                           "March",
                                           "April",
                                           "May",
                                           "June",
                                           "July",
                                           "August",
                                           "September",
                                           "October",
                                           "November",
                                           "December"};
                                           
    public static final String[] DAYS_OF_THE_WEEK = {"Sun",
                                                  "Mon",
                                                  "Tues",
                                                  "Wed",
                                                  "Thurs",
                                                  "Fri",
                                                  "Sat"};
                                                  
    /** Number of days in a week */
    static final int DAYS_IN_WEEK = 7;
    
    /** Largest possible number of days in a single month */
    static final int MAX_DAYS_IN_MONTH = 31;
    
    /** Frequency of leap years in terms of number of years */
    static final int LEAP_YEAR_FREQUENCY = 4;
    
    /** Number of months in a single year */
    static final int MONTHS_IN_YEAR = 12;
    
    /** Number of years in a single century */
    static final int YEARS_IN_CENTURY = 100;
                                           
    public static final int[] DAYS_IN_MONTH = {31,
                                             28,
                                             31,
                                             30,
                                             31,
                                             30,
                                             31,
                                             31,
                                             30,
                                             31,
                                             30,
                                             31};
                               
    private Month[] months;
    private int year;
                                   
    public WolfPackCalendar(int year) {
        this.year = year;
        
        months = new Month[MONTH_NAMES.length];
        for(int i = 0; i < months.length; i++) {
            if(i == 1) {
                months[i] = new Month(MONTH_NAMES[i], i, DAYS_IN_MONTH[i] + 1, zellersAlgorithm(i + 1, 1, this.year));
                continue;
            }
            
            months[i] = new Month(MONTH_NAMES[i], i, DAYS_IN_MONTH[i], zellersAlgorithm(i + 1, 1, this.year));
        }        
    }
    
    public WolfPackCalendar(int year, String notesFile) {
        this(year);

         processFile(notesFile);
    }
    
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
            
            if(zellersAlgorithm(index + 1, currDay, year) == 6) {
                System.out.println();
            }
        }
        System.out.println();
        
        months[index].printNotes();
    }
    
    public void printYear() {
        for(int i = 0; i < months.length; i++) {
            printMonth(i);
            System.out.println("\n");
        }
    }
    
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
            throw new IllegalArgumentException("Could not access: " + filePath);
        }
        
        while(fileScanner.hasNextLine()) {
            processLine(fileScanner.nextLine());
        }
    }
    
    public static void main(String[] args) {
        WolfPackCalendar calendar = null;
        if(args.length == 1) {
            calendar = new WolfPackCalendar(Integer.parseInt(args[0]));
        } else if(args.length == 2) {
            calendar = new WolfPackCalendar(Integer.parseInt(args[0]), args[1]);
        } else {
            System.exit(1);
        }
        
        calendar.printYear();
    }
}
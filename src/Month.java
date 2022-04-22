/**
 * Contains all day information for a given month, 
 * including notes and starting day of the week
 * @author Anthony Brown
 * @author JR Boos
 * @author Seth Spicer
 */
public class Month {
    
    /** Minimum value of startDayOfTheWeek */
    public static final int MIN_DAY_OF_THE_WEEK = 0;
    
    /** Maximum value of startDayOfTheWeek */
    public static final int MAX_DAY_OF_THE_WEEK = 6;
    
    /** Maximum possible number of days in any single month */
    public static final int MAX_DAYS_IN_MONTH = 31;
     
    /** Number of months in a single year */
    public static final int MONTHS_IN_YEAR = Day.MAX_MONTHS;
    
    /** Name of the current month */
    private String name;

    /** Numeric value of the current month */
    private int month;

    /** Number of days in the current month */
    private int numberOfDays;
    
    /** Day of the week the current month starts on */
    private int startDayOfTheWeek;
    
    /** Array containing all of the days of the month */
    private Day[] days;
    
    /**
     * Constructs a new month with passed parameters
     * @param name name of the month
     * @param month month's numeric value
     * @param numberOfDays number of days in the month
     * @param startDayOfTheWeek day of the week the month starts on
     * @throws IllegalArgumentException with message "Invalid starting day of the week" if
     *         startDayOfTheWeek is less than MIN_DAY_OF_THE_WEEK
     *         or greater than MAX_DAY_OF_THE_WEEK
               or with message "Null name" if name is null
               or with message "Invalid number of days" if numberOfDays 
               is less than 1 or greater than MAX_DAYS_IN_MONTH
               or with message "Invalid month" if month is less than 1
               or greater than MONTHS_IN_YEAR
             
     */
    public Month(String name, int month, int numberOfDays, int startDayOfTheWeek) {  
        if(startDayOfTheWeek < MIN_DAY_OF_THE_WEEK || startDayOfTheWeek > MAX_DAY_OF_THE_WEEK) {
            throw new IllegalArgumentException("Invalid starting day of the week");
        }
        
        if(name == null) {
            throw new IllegalArgumentException("Null name");
        }
        
        if(numberOfDays < 1 || numberOfDays > MAX_DAYS_IN_MONTH) {
            throw new IllegalArgumentException("Invalid number of days");
        }
        
        if(month < 1 || month > MONTHS_IN_YEAR) {
            throw new IllegalArgumentException("Invalid month");
        }
    
        this.name = name;
        this.month = month;
        this.numberOfDays = numberOfDays;
        this.startDayOfTheWeek = startDayOfTheWeek;
        
        days = new Day[this.numberOfDays];
        
        for(int i = 1; i <= numberOfDays; i++) {
            int dayIndex = i - 1;
            days[dayIndex] = new Day(month, i);
        }
    }
    
    /**
     * Adds a note to a specific day
     * @param day determines which day to add a note to
     * @param note the note to be added
     * @throws IllegalArgumentException with message "Invalid note" if note is null
     *         or with message "Invalid day while adding note"
     *         if day is less than zero or greater than the length of days
     */
    public void addNote(int day, String note) {
        if(note == null) {
            throw new IllegalArgumentException("Invalid note");
        }
        
        if(day < 0 || day > days.length) {
            throw new IllegalArgumentException("Invalid day while adding note");
        }
        
        days[day - 1].addNote(note);
    }
    
    /** 
     * Prints a string containing a list of important events if there are more than 1 note or
     * prints a single note if there is only one note. Nothing is printed if there are no notes
     */
    public void printNotes() {
        for(int i = 0; i < numberOfDays; i++) {
            if(days[i].getNumberOfNotes() > 0) {
                System.out.println(String.format("%s %d: %s", 
                                                 name, 
                                                 days[i].getDay(), 
                                                 days[i].getNotes()));
            }
        }
    }
    
    /**
     * Gets the name of the month
     * @return name of the month
     */
    public String getName() {
        return name;
    }
    
    /**
     * Gets the numeric value of the month
     * @return numeric value of the month
     */
    public int getMonth() {
        return month;
    }
    
    /**
     * Gets the number of days in the month
     * @return the number of days in the month
     */
    public int getNumberOfDays() {
        return numberOfDays;
    }
    
    /**
     * Gets the day of the week that the month starts on
     * @return the starting day of the week
     */
    public int getStartDayOfTheWeek() {
        return startDayOfTheWeek;
    }
}
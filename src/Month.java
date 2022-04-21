/**
 * Contains all day information for a given month, 
 * including notes and starting day of the week
 * @author Anthony Brown
 * @author JR Boos
 * @author Seth Spicer
 */
public class Month {
    
    /** enums representing each month of the year */
    public static enum Months {JANUARY,
                                FEBRUARY,
                                MARCH,
                                APRIL,
                                MAY,
                                JUNE,
                                JULY,
                                AUGUST,
                                SEPTEMBER,
                                OCTOBER,
                                NOVEMBER,
                                DECEMBER};
                                
    public static final Months[] ALL_MONTHS = {Months.JANUARY,
                                      Months.FEBRUARY,
                                      Months.MARCH,
                                      Months.APRIL,
                                      Months.MAY,
                                      Months.JUNE,
                                      Months.JULY,
                                      Months.AUGUST,
                                      Months.SEPTEMBER,
                                      Months.OCTOBER,
                                      Months.NOVEMBER,
                                      Months.DECEMBER};
                                      
    /** String array containing the names of every month of the year */
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
    
    /** Name of the current month */
    private String name;

    /** enum value of the current month */
    private Months month;

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
     */
    public Month(Months month, int startDayOfTheWeek, boolean isLeapYear) {  
        this.month = month;
        this.numberOfDays = Day.DAYS_IN_MONTH[month.ordinal()];
        this.startDayOfTheWeek = startDayOfTheWeek;
        
        if(!isLeapYear) {
            numberOfDays--;
        }
        
        days = new Day[this.numberOfDays];
        
        for(int i = 1; i <= numberOfDays; i++) {
            days[i - 1] = new Day(month.ordinal(), i);
        }
        
        name = MONTH_NAMES[month.ordinal()];
    }
    
    /**
     * Adds a note to a specific day
     * @param dayIndex determines which day to add a note to
     * @param note the note to be added
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
    
    public void printNotes() {
        for(int i = 0; i < numberOfDays; i++) {
            if(days[i].getNotes() != null) {
                System.out.println(String.format("%s %d: %s", name, i + 1, days[i].getNotes()));
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
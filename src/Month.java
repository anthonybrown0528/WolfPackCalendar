/**
 * Contains all day information for a given month, 
 * including notes and starting day of the week
 * @author Anthony Brown
 */
public class Month {
    
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
     */
    public Month(String name, int month, int numberOfDays, int startDayOfTheWeek) {  
        this.name = name;
        this.month = month;
        this.numberOfDays = numberOfDays;
        this.startDayOfTheWeek = startDayOfTheWeek;
        
        days = new Day[this.numberOfDays];
        
        for(int i = 0; i < numberOfDays; i++) {
            days[i] = new Day(month, i + 1);
        }
    }
    
    /**
     * Adds a note to a specific day
     * @param dayIndex determines which day to add a note to
     * @param note the note to be added
     */
    public void addNote(int day, String note) {
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
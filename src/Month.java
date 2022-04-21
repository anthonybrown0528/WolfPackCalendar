/**
 * Contains all day information for a given month, 
 * including notes and starting day of the week
 * @author Anthony Brown
 * @author JR Boos
 * @author Seth Spicer
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
        
        for(int i = 1; i <= numberOfDays; i++) {
            days[i - 1] = new Day(month, i);
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
/**
 * Contains the events and notes inputted from a CSV file
 * @author Anthony Brown
 */
public class Day {
    /** Max number of months in a year */
    public static final int MAX_MONTHS = 12;

    /** Max number of days in a month */
    public static final int MAX_DAYS = 31;
    
    /** Instance variable representing 
     * the numeric value of 
     * the month the day belongs to */
    private int month;
    
    /** Instance variable representing 
     * the numeric value of 
     * the day within the month */
    private int day;
    
    /** Array containing the notes for each day */
    private String[] notes;
    
    /**
     * Constructs a new day given numeric values for month and date
     * @param month the numeric value of the month the day belongs to
     * @param day the numeric value of the day within the month
     */
    public Day(int month, int day) {
        if(month > MAX_MONTHS) {
            throw new IllegalArgumentException("Invalid month");
        }
        
        if(day > MAX_DAYS) {
            throw new IllegalArgumentException("Invalid day: " + day);
        }
        
        this.month = month;
        this.day = day;
    }
    
    /**
     * Gets the numeric value of the month the day belongs to
     * @return numeric value of the month
     */
    public int getMonth() {
        return month;
    }
    
    /**
     * Gets the numeric value of the day
     * @return numeric value of the day
     */
    public int getDay() {
        return day;
    }
    
    /**
     * Gets all notes attached to a day
     * @return notes attached to a day
     */
    public String[] getNotes() {
        return notes;
    }
    
    /**
     * Gets a specific note attached to a day
     * @param index which note should be returned
     * @return the specified note
     */
    public String getNote(int index) {
        return notes[index];
    }
    
    /**
     * Adds a note to a specified day
     * @param noteString the note to be added to the day as a string
     */
    public void addNote(String noteString) {
        String[] tmp = new String[notes.length + 1];
        for(int i = 0; i < notes.length; i++) {
            tmp[i] = notes[i];
        }
        
        tmp[tmp.length - 1] = noteString;
        notes = tmp;
    }
}
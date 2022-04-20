/**
 * Contains the events and notes inputted from a CSV file
 * @author Anthony Brown
 * @author JR Boos
 * @author Seth Spicer
 */
public class Day {
    
    /** Max number of months in a year */
    public static final int MAX_MONTHS = 12;
    
    /** Int array containing the number of days in each month */                                            
    public static final int[] DAYS_IN_MONTH = {31,
                                             29,
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
    
    /** Stores number of notes in a single day */
    private int numberOfNotes;
    
    /**
     * Constructs a new day given numeric values for month and date
     * @param month the numeric value of the month the day belongs to
     * @param day the numeric value of the day within the month
     */
    public Day(int month, int day) {
        if(month >= MAX_MONTHS) {
            throw new IllegalArgumentException("Invalid month: " + month);
        }
        
        if(day > DAYS_IN_MONTH[month]) {
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
    public String getNotes() {
        if(numberOfNotes < 2) {
            return getNote(0);
        }
        
        String notesList = "\n";
        for(int i = 0; i < numberOfNotes; i++) {
            notesList += String.format(" - %s\n", getNote(i));
        }
        
        notesList = notesList.substring(0, notesList.length() - 1);
        return notesList;
    }
    
    /**
     * Gets a specific note attached to a day
     * @param index which note should be returned
     * @return the specified note
     */
    public String getNote(int index) {
        try {
            return notes[index];
        } catch(NullPointerException e) {
            return null;
        }
    }
    
    /**
     * Adds a note to a specified day
     * @param noteString the note to be added to the day as a string
     */
    public void addNote(String noteString) {
        String[] tmp = new String[numberOfNotes + 1];
        for(int i = 0; i < numberOfNotes; i++) {
            tmp[i] = getNote(i);
        }
        
        tmp[tmp.length - 1] = noteString;
        notes = tmp;
        
        numberOfNotes++;
    }
}
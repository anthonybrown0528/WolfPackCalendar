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
    public static final int[] DAYS_IN_MONTH = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    
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
     * @throws IllegalArgumentException with message "Invalid month" 
     *         if month is greater than or equal to MAX_MONTHS
     *         or with message "Invalid day" if day is greater than 
     *         the max number of days in the corresponding month
     */
    public Day(int month, int day) {
        
        // Index of given month in DAYS_IN_MONTH
        int monthIndex = month - 1;
        
        if(month < 1 || month > MAX_MONTHS) {
            throw new IllegalArgumentException("Invalid month");
        }
        
        if(day < 1 || day > DAYS_IN_MONTH[monthIndex]) {
            throw new IllegalArgumentException("Invalid day");
        }
        
        this.day = day;
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
        
        // Remove final newline character before returning
        notesList = notesList.substring(0, notesList.length() - 1);
        return notesList;
    }
    
    /**
     * Gets a specific note attached to a day
     * @param index which note should be returned
     * @return the specified note
     */
    public String getNote(int index) {
        if(index < 0 || index >= numberOfNotes) {
            throw new IllegalArgumentException("Invalid index");
        }
        
        return notes[index];
    }
    
    /** 
     * Get the number of notes in the day
     * @return the number of notes
     */
    public int getNumberOfNotes() {
        return numberOfNotes;
    }
    
    /**
     * Adds a note to a specified day
     * @param noteString the note to be added to the day as a string
     */
    public void addNote(String noteString) {
        if(noteString == null) {
            throw new IllegalArgumentException("Invalid note");
        }
        
        String[] tmp = new String[numberOfNotes + 1];
        
        // Copy all existing notes to tmp
        for(int i = 0; i < numberOfNotes; i++) {
            tmp[i] = getNote(i);
        }
        
        // Add new note to the end of tmp
        tmp[tmp.length - 1] = noteString;
        
        // Replace current notes with tmp
        notes = tmp;
        
        // Record the new number of notes
        numberOfNotes++;
    }
}
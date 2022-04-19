public class Day {
    
    public static final int MAX_MONTHS = 12;
    public static final int MAX_DAYS = 31;
    
    private int month;
    private int day;
    
    private String[] notes;
    
    private int numberOfNotes;
    
    public Day(int month, int day) {
        if(month > MAX_MONTHS) {
            throw new IllegalArgumentException("Invalid month: " + month);
        }
        
        if(day > MAX_DAYS) {
            throw new IllegalArgumentException("Invalid day: " + day);
        }
        
        this.month = month;
        this.day = day;
    }
    
    public int getMonth() {
        return month;
    }
    
    public int getDay() {
        return day;
    }
    
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
    
    public String getNote(int index) {
        try {
            return notes[index];
        } catch(NullPointerException e) {
            return null;
        }
    }
    
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
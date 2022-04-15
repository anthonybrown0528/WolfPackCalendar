public class Day {
    
    public static final int MAX_MONTHS = 12;
    public static final int MAX_DAYS = 31;
    
    private int month;
    private int day;
    
    private String[] notes;
    
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
    
    public String[] getNotes() {
        return notes;
    }
    
    public String getNote(int index) {
        return notes[index];
    }
    
    public void addNote(String noteString) {
        String[] tmp = new String[notes.length + 1];
        for(int i = 0; i < notes.length; i++) {
            tmp[i] = notes[i];
        }
        
        tmp[tmp.length - 1] = noteString;
        notes = tmp;
    }
}
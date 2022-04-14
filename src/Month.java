public class Month {
    

    private String name;
    private int month;
    private int numberOfDays;
    
    private Day[] days;
    
    public Month(String name, int month, int numberOfDays) {  
        this.name = name;
        this.month = month;
        this.numberOfDays = numberOfDays;
        
        days = new Day[this.numberOfDays];
        
        for(int i = 0; i < numberOfDays; i++) {
            days[i] = new Day(month, i + 1);
        }
    }
    
    public void addNote(int dayIndex, String note) {
        days[dayIndex].addNote(note);
    }
    
    public String getName() {
        return name;
    }
}
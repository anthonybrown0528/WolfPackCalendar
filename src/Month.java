public class Month {
    

    private String name;
    private int month;
    private int numberOfDays;
    
    private int startDayOfTheWeek;
    
    private Day[] days;
    
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
    
    public void addNote(int dayIndex, String note) {
        days[dayIndex].addNote(note);
    }
    
    public String getName() {
        return name;
    }
    
    public int getNumberOfDays() {
        return numberOfDays;
    }
    
    public int getStartDayOfTheWeek() {
        return startDayOfTheWeek;
    }
}
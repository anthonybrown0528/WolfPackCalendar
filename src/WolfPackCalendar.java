public class WolfPackCalendar {
    
    public static final String[] monthNames = {"January",
                                           "February",
                                           "March",
                                           "April",
                                           "May",
                                           "June",
                                           "July",
                                           "August",
                                           "September",
                                           "November",
                                           "December"};
                                           
    public static final String[] daysOfTheWeek = {"Sun",
                                                  "Mon",
                                                  "Tues",
                                                  "Wed",
                                                  "Thurs",
                                                  "Fri",
                                                  "Sat"};
                                           
    public static final int[] daysInMonth = {31,
                                             28,
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
                               
    private Month[] months;
    private int year;
    
    public static final int MAX_WEEKS_IN_MONTH = 5;
    
    /** Number of days in a week */
    static final int DAYS_IN_WEEK = 7;
    
    /** Largest possible number of days in a single month */
    static final int MAX_DAYS_IN_MONTH = 31;
    
    /** Frequency of leap years in terms of number of years */
    static final int LEAP_YEAR_FREQUENCY = 4;
    
    /** Number of months in a single year */
    static final int MONTHS_IN_YEAR = 12;
    
    /** Number of years in a single century */
    static final int YEARS_IN_CENTURY = 100;
                               
    public WolfPackCalendar(int year) {
        this.year = year;
        
        months = new Month[monthNames.length];
        for(int i = 0; i < months.length; i++) {
            months[i] = new Month(monthNames[i], i, daysInMonth[i], zellersAlgorithm(i + 1, 1, this.year));
        }
    }
    
    public void printMonth(int index) {
        
        // Display month
        System.out.println("\t\t\t" + months[index].getName() + " " + year);
        
        // Display days of the week
        for(int i = 0; i < daysOfTheWeek.length; i++) {
            System.out.print(daysOfTheWeek[i] + "\t");
        }
        System.out.println();
        
        // Start month on correct day of the week
        for(int i = 0; i < months[index].getStartDayOfTheWeek(); i++) {
            System.out.print("\t");
        }
        
        // Display days of the month
        int currDay = 0;
        for(int i = 0; i < months[index].getNumberOfDays(); i++) {
            currDay++;
            System.out.print(currDay + "\t");
            
            if(zellersAlgorithm(index + 1, currDay, year) == 6) {
                System.out.println();
            }
        }
    }
    
    public void printYear() {
        for(int i = 0; i < months.length; i++) {
            printMonth(i);
            System.out.println("\n");
        }
    }
    
    public static int zellersAlgorithm(int month, int day, int year) {
        int w = year - (MONTHS_IN_YEAR + 2 - month) / MONTHS_IN_YEAR;
        int x = w + w / LEAP_YEAR_FREQUENCY - w / YEARS_IN_CENTURY + 
                w / (LEAP_YEAR_FREQUENCY * YEARS_IN_CENTURY);
        int z = month +  MONTHS_IN_YEAR * ((MONTHS_IN_YEAR + 2 - month) / MONTHS_IN_YEAR) - 2;

        int dayOfWeek = (day + x + (MAX_DAYS_IN_MONTH * z) / MONTHS_IN_YEAR) % DAYS_IN_WEEK;
        
        return dayOfWeek;
    }
    
    public static void main(String[] args) {
        WolfPackCalendar calendar = new WolfPackCalendar(2022);
        calendar.printYear();
    }
}
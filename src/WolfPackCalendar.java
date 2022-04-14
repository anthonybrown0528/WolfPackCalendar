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
    
    public static final int DAYS_IN_WEEK = 7;
    public static final int MAX_WEEKS_IN_MONTH = 5;
                               
    public WolfPackCalendar() {
        months = new Month[monthNames.length];
        for(int i = 0; i < months.length; i++) {
            months[i] = new Month(monthNames[i], i, daysInMonth[i]);
        }
    }
    
    public void printMonth(int index) {
        
        // Display month
        System.out.println("\t\t\t" + months[index].getName());
        
        // Display days of the week
        for(int i = 0; i < daysOfTheWeek.length; i++) {
            System.out.print(daysOfTheWeek[i] + "\t");
        }
        System.out.println();
        
        // Display days of the month
        for(int i = 0; i < MAX_WEEKS_IN_MONTH; i++) {
            for(int j = 1; j <= DAYS_IN_WEEK; j++) {
                int currDay = j + i * DAYS_IN_WEEK;
                
                if(currDay > Day.MAX_DAYS) {
                    break;
                }
                
                System.out.print(currDay + "\t");
            }
            System.out.println();
        }
    }
    
    public void printYear() {
        for(int i = 0; i < months.length; i++) {
            printMonth(i);
            System.out.println();
        }
    }
    
    public static void main(String[] args) {
        WolfPackCalendar calendar = new WolfPackCalendar();
        // calendar.printMonth(0);
        calendar.printYear();
    }
}
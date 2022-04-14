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
                               
    public WolfPackCalendar() {
        months = new Month[monthNames.length];
        for(int i = 0; i < months.length; i++) {
            months[i] = new Month(monthNames[i], i, daysInMonth[i]);
        }
    }
    
    public void printMonth(int index) {
        System.out.println(months[index].getName());
    }
    
    public static void main(String[] args) {
        WolfPackCalendar calendar = new WolfPackCalendar();
        calendar.printMonth(0);
    }
}
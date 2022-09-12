package skorupinski.midjourney.utils;

public class Date {

    public final String day;

    public final String month;

    public final String year;

    public Date(int day, int month, int year){
        this.day = Integer.toString(day);
        this.month = Integer.toString(month);
        this.year = Integer.toString(year);
    }
}
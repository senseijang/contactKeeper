/*
 * Date.java
 *
 * Date is in charge of storing the date of anything so it can be sorted later by parts.
 *
 * @version April 25, 2022
 * @author Sunwoo Jang
 */

public class Date {
    private int month;
    private int day;
    private int year;

    public Date () {
        month = 0;
        day = 0;
        year = 0;

    }

    public Date (int month, int day, int year) {
        this.month = month;
        this.day = day;
        this.year = year;

    }

    public int getMonth() {
        return month;

    }

    public void setMonth (int month) {
        this.month = month;

    }

    public int getDay() {
        return day;

    }

    public void setDay (int day) {
        this.day = day;

    }

    public int getYear() {
        return year;

    }

    public void setYear (int year) {
        this.year = year;

    }

    public String getDate() {
        return (month + "-" + day + "-" + year);

    }

    public void printDate() {
        System.out.println(this.getDate());

    }

    public static void main(String[] args) {
        Date d = new Date(2, 13, 2003);
        d.printDate();
    
    }

}

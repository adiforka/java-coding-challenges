package java_coding_challenges;

import java.time.LocalDate;

public class JCC10_BlackFridays {
    public static void main(String[] args) {

        //find number of Black Fridays (Friday the 13ths) given the year
        int unluckyDays = unluckyDays(2015);
        System.out.println("unluckyDays = " + unluckyDays);
    }

    public static int unluckyDays(int year) {
        int count = 0;
        var days = isLeapYear(year) ? 366 : 365;
        for (int i = 1; i <= days; i++) {
            var currentDay = LocalDate.ofYearDay(year, i);
            var dayOfWeekString = currentDay.getDayOfWeek()
                    .toString()
                    .toLowerCase();
            var dayOfMonth = currentDay.getDayOfMonth();
            if (dayOfMonth == 13 && dayOfWeekString.equals("friday")) {
                count++;
            }
        }
        return count;
    }

    private static boolean isLeapYear(int year) {
        return year % 4 == 0 && year % 100 != 0 || year % 400 == 0;
    }
}

import java.util.*;
import java.time.*;

public class MonthlyCalender {
    static final String[] DAYS = { "Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat" };
    static final String[] MONTHS = { "January", "February", "March", "April", "May", "June", "July", "August",
            "September", "October", "November", "December" };
    static final int[] MONTH_DAYS = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

    static String getDayOfWeek(int month, int year) {
        LocalDate date = LocalDate.of(year, month, 1);
        return DAYS[date.getDayOfWeek().getValue() % 7];
    }

    static String getMonthName(int month) {
        return MONTHS[month - 1];
    }

    static boolean isLeapYear(int year) {
        return Year.isLeap(year);
    }

    static String formatDay(int day) {
        return String.format("%2d", day);
    }

    static int StringDayToInt(String day) {
        int val = 0;
        for (char c : day.toCharArray()) {
            if (c == ' ' || c == '\n')
                continue;
            val = val * 10 + (c - '0');
        }
        return val;
    }

    static void MonthPrint(int month, int year, List<Integer> holidays) {
        System.out.println("JUST Academic Calender of\n" + getMonthName(month) + ", " + year);
        String firstDayOfWeek = getDayOfWeek(month, year);
        int lastDayOfMonth = MONTH_DAYS[month];
        if (month == 2 && isLeapYear(year))
            lastDayOfMonth++;
        String[] dates = new String[35];
        Arrays.fill(dates, "- ");
        for (int i = 0, count = 0; i < 35; i++) {
            if (DAYS[i % 7].equals(firstDayOfWeek) || count > 0) {
                if (++count <= lastDayOfMonth) {
                    dates[i] = formatDay(count);
                }
            }
        }
        System.out.println("|---------------------------|");
        System.out.println("|Sun|Mon|Tue|Wed|Thu|Fri|Sat|");
        System.out.println("|---------------------------|");
        for (int j = 0; j < 5; j++) {
            System.out.print("|");
            for (int i = j * 7; i < (j + 1) * 7; i++) {
                if (dates[i] != "- " && holidays.contains(StringDayToInt(dates[i]))) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
                System.out.print(dates[i] + "|");
            }
            System.out.println("\n|---------------------------|");
        }
    }
}

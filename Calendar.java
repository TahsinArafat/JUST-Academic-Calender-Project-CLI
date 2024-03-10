import java.util.ArrayList;
import java.util.List;

class Calendar {
    private List<Holiday> holidays;

    public Calendar() {
        this.holidays = new ArrayList<>();
    }

    public void addHoliday(Holiday holiday) {
        holidays.add(holiday);
    }

    public void deleteHoliday(String date) {
        for (Holiday holiday : holidays) {
            if (holiday.getDate().equals(date)) {
                holidays.remove(holiday);
                System.out.println("Holiday deleted successfully.");
                return;
            }
        }
        System.out.println("No holiday found for the given date.");
    }

    public String isHoliday(String date) {
        for (Holiday holiday : holidays) {
            if (holiday.getDate().equals(date)) {
                return holiday.getName();
            }
        }
        return "No holiday";
    }

    public void listHolidays() {
        if (holidays.isEmpty()) {
            System.out.println("No holidays added yet.");
            return;
        }
        System.out.println("List of Holidays:");
        for (Holiday holiday : holidays) {
            System.out.println(holiday.getDate() + " - " + holiday.getName());
        }
    }

    public void listHolidaysByMonth(int month, int year) {
        List<Integer> dates = new ArrayList<>();
        List<String> holidayDetails = new ArrayList<>();
        for (Holiday holiday : holidays) {
            String[] dateParts = holiday.getDate().split("/");
            if (Integer.parseInt(dateParts[1]) == month && Integer.parseInt(dateParts[2]) == year) {
                dates.add(Integer.parseInt(dateParts[0])); // adding the day part of the date
                holidayDetails.add(holiday.getDate() + " - " + holiday.getName());
            }
        }
        MonthlyCalender.MonthPrint(month, year, dates);
        if (holidayDetails.isEmpty()) {
            System.out.println("No holidays added yet.");
        } else {
            System.out.println("List of Holidays in " + MonthlyCalender.getMonthName(month) + ", " + year + ":");
            for (String holiday : holidayDetails) {
                System.out.println(holiday);
            }
        }
    }
}

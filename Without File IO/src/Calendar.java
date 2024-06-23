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

    public Boolean isValidDayFormat(String date) {
        String[] dateParts = date.split("/");
        if (dateParts.length != 3) {
            return false;
        }
        if (dateParts[0].length() != 2 || dateParts[1].length() != 2 || dateParts[2].length() != 4) {
            return false;
        }
        try {
            int day = Integer.parseInt(dateParts[0]);
            int month = Integer.parseInt(dateParts[1]);
            int year = Integer.parseInt(dateParts[2]);
            if (day < 1 || day > 31 || month < 1 || month > 12 || year < 1000 || year > 9999) {
                return false;
            }
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
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

    public void listHolidaysByMonth(int month, int year, ArrayList<Integer> weekends) {
        List<Integer> dates = new ArrayList<>();
        List<String> holidayDetails = new ArrayList<>();
        for (Holiday holiday : holidays) {
            String[] dateParts = holiday.getDate().split("/");
            if (Integer.parseInt(dateParts[1]) == month && Integer.parseInt(dateParts[2]) == year) {
                dates.add(Integer.parseInt(dateParts[0])); // adding the day part of the date
                holidayDetails.add(holiday.getDate() + " - " + holiday.getName());
            }
        }
        MonthlyCalender.MonthPrint(month, year, dates, weekends);
        if (holidayDetails.isEmpty()) {
            System.out.println("No custom holidays added yet.");
        } else {
            System.out.println("List of Holidays in " + MonthlyCalender.getMonthName(month) + ", " + year + ":");
            for (String holiday : holidayDetails) {
                System.out.println(holiday);
            }
        }
    }
}

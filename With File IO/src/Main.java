import java.util.*;
import java.io.*;

public class Main {

    static void ClearScreen() {
        System.out.print("\033[H\033[2J"); // Clears the terminal
        System.out.flush();
    }

    public static void main(String[] args) {
        try {
            File iFile = new File("TextFiles/input.txt");
            Scanner scanner = new Scanner(iFile);
            File addHolidaytxt = new File("TextFiles/Holidays.txt");
            Scanner addHolidayScanner = new Scanner(addHolidaytxt);
            File modifiedHolidaytxt = new File("TextFiles/ModifiedHolidays.txt");
            Scanner modifiedHoliday = new Scanner(modifiedHolidaytxt);
            File deletedHolidaytxt = new File("TextFiles/DeletedHolidays.txt");
            Scanner deletedHoliday = new Scanner(deletedHolidaytxt);
            File holidayChecktxt = new File("TextFiles/HolidayCheck.txt");
            Scanner holidayCheck = new Scanner(holidayChecktxt);
            File weekendstxt = new File("TextFiles/Weekends.txt");
            Scanner weekendsScanner = new Scanner(weekendstxt);
            File deleteWeekendstxt = new File("TextFiles/DeletedWeekends.txt");
            Scanner deleteWeekends = new Scanner(deleteWeekendstxt);
            File monthlyCalQtxt = new File("TextFiles/MonthlyCalQ.txt");
            Scanner monthlyCalQ = new Scanner(monthlyCalQtxt);
            File outputFile = new File("TextFiles/output.txt");
            FileOutputStream fileOutputStream = new FileOutputStream(outputFile);
            PrintStream printStream = new PrintStream(fileOutputStream);
            System.setOut(printStream);
            HolidayManager holidayManager = new HolidayManager();
            holidayManager.run(scanner, addHolidayScanner, modifiedHoliday, deletedHoliday, holidayCheck,
                    weekendsScanner, deleteWeekends, monthlyCalQ);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error reading input file\n" + e.getMessage());
            System.exit(1);
        } catch (Exception e) {
            System.out.println("Unknown Error: " + e.getMessage());
            System.exit(0);
        }
    }
}

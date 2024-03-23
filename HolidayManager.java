import java.util.ArrayList;
import java.util.Scanner;

public class HolidayManager {
    Calendar calendar = new Calendar();
    ArrayList<Integer> weekends = new ArrayList<>();

    Boolean isWeekend(String date) {
        int day = MonthlyCalender.getDayOfWeek(date);
        return weekends.contains(day);
    }

    Boolean isWeekend(int day, int month, int year) {
        int dayOfWeek = MonthlyCalender.getDayOfWeek(day, month, year);
        return weekends.contains(dayOfWeek);
    }

    void run() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nHello, Calendar Manager! What would you like to do?\n");
            System.out.println("1. Add Holiday");
            System.out.println("2. Check if a Date is a Holiday");
            System.out.println("3. List all Holidays");
            System.out.println("4. Monthly Calendar");
            System.out.println("5. Modify a Holiday");
            System.out.println("6. Delete Holiday");
            System.out.println("7. Add or Modify Weekend");
            System.out.println("0. Exit");
            System.out.print("Enter option: ");

            int option = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            // ClearScreen();
            System.out.print("\033[H\033[2J"); // Clears the terminal
            System.out.flush();
            switch (option) {
                case 1:
                    System.out.print("Enter date (dd/mm/yyyy): ");
                    String date = scanner.nextLine();
                    while (!calendar.isValidDayFormat(date)) {
                        System.out.print("Invalid date format. Please enter again (dd/mm/yyyy): ");
                        date = scanner.nextLine();
                    }
                    System.out.print("Enter holiday name: ");
                    Scanner lineScanner = new Scanner(System.in).useDelimiter("\n");
                    String name = lineScanner.next();
                    calendar.addHoliday(new Holiday(date, name));
                    System.out.println("Holiday added successfully.");
                    break;
                case 2:
                    System.out.print("Enter date (dd/mm/yyyy) to check: ");
                    date = scanner.nextLine();
                    String result = calendar.isHoliday(date);
                    if (!result.equals("No holiday")) {
                        System.out.println("It's a holiday: " + result);
                    } else if (isWeekend(date)) {
                        System.out.println("It's a weekend.");
                    } else {
                        System.out.println(result);
                    }
                    break;
                case 3:
                    calendar.listHolidays();
                    break;
                case 4:
                    System.out.print("Enter month (1-12): ");
                    int month = scanner.nextInt();
                    System.out.print("Enter year: ");
                    int year = scanner.nextInt();
                    calendar.listHolidaysByMonth(month, year, weekends);
                    System.out.println("Weekends: " + weekends);
                    break;
                case 5:
                    System.out.print("Enter date (dd/mm/yyyy) to modify: ");
                    date = scanner.nextLine();
                    System.out.print("Enter new holiday name: ");
                    name = scanner.nextLine();
                    calendar.deleteHoliday(date);
                    calendar.addHoliday(new Holiday(date, name));
                    System.out.println("Holiday modified successfully.");
                    break;
                case 6:
                    System.out.print("Enter date (dd/mm/yyyy) to delete: ");
                    date = scanner.nextLine();
                    calendar.deleteHoliday(date);
                    break;
                case 0:
                    String[] spinnerFrames = { "-", "/", "|", "\\" };
                    int iterations = 5;
                    for (int i = 0; i < iterations; i++) {
                        System.out.print("\r" + "Exiting " + spinnerFrames[i % spinnerFrames.length]);
                        try {
                            Thread.sleep(200);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    return;
                case 7: {
                    System.out.println("1. Add Weekend");
                    System.out.println("2. Delete Weekend");
                    System.out.println("3. View Weekends");
                    System.out.print("Enter option: ");
                    int weekendOption = Integer.valueOf(scanner.nextLine());
                    switch (weekendOption) {
                        case 1:
                            System.out.print("Enter day of week (1-7, Starts from Sunday): ");
                            int day = Integer.valueOf(scanner.nextLine());
                            if (day < 1 || day > 7) {
                                System.out.println("Invalid day of week. Please try again.");
                                break;
                            }
                            weekends.add(day);
                            System.out.println("Weekend added successfully.");
                            break;
                        case 2:
                            System.out.print("Enter day of week (1-7, Starts from Sunday) to delete: ");
                            day = Integer.valueOf(scanner.nextLine());
                            if (weekends.contains(day)) {
                                weekends.remove(day);
                                System.out.println("Weekend deleted successfully.");
                            } else {
                                System.out.println("Weekend not found.");
                            }
                            break;
                        case 3:
                            // if empty print "No weekends added yet."
                            if (weekends.isEmpty()) {
                                System.out.println("No weekends added yet.");
                            } else {
                                System.out.println("Weekends: " + weekends);
                            }
                            break;
                        default:
                            System.out.println("Invalid option. Please try again.");
                    }
                }
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}

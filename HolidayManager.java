import java.util.Scanner;

class HolidayManager {
    void run() {
        Scanner scanner = new Scanner(System.in);
        Calendar calendar = new Calendar();
        while (true) {
            System.out.println("\nHello, Calendar Manager! What would you like to do?\n");
            System.out.println("1. Add Holiday");
            System.out.println("2. Check if a Date is a Holiday");
            System.out.println("3. List all Holidays");
            System.out.println("4. Monthly Calendar");
            System.out.println("5. Delete Holiday");
            System.out.println("6. Exit");
            System.out.print("Enter option: ");

            int option = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            // ClearScreen();
            switch (option) {
                case 1:
                    System.out.print("Enter date (dd/mm/yyyy): ");
                    String date = scanner.nextLine();
                    System.out.print("Enter holiday name: ");
                    Scanner lineScanner = new Scanner(System.in).useDelimiter("\n");
                    String name = lineScanner.next();
                    lineScanner.close();
                    calendar.addHoliday(new Holiday(date, name));
                    System.out.println("Holiday added successfully.");
                    break;
                case 2:
                    System.out.print("Enter date (dd/mm/yyyy) to check: ");
                    date = scanner.nextLine();
                    String result = calendar.isHoliday(date);
                    if (!result.equals("No holiday")) {
                        System.out.println("It's a holiday: " + result);
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
                    calendar.listHolidaysByMonth(month, year);
                    break;
                case 5:
                    System.out.print("Enter date (dd/mm/yyyy) to delete: ");
                    date = scanner.nextLine();
                    calendar.deleteHoliday(date);
                    break;
                case 6:
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
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}

import java.util.Scanner;

public class Main {

    static void ClearScreen() {
        System.out.print("\033[H\033[2J"); // Clears the terminal
        System.out.flush();
    }

    public static void main(String[] args) {
        HolidayManager holidayManager = new HolidayManager();
        while (true) {
            ClearScreen();
            System.out.println("\nJUST Academic Calender Management System v1.0\n");
            System.out.println("1. Enter the System");
            System.out.println("2. Terminate the System\n");
            System.out.print("Enter option: ");
            Scanner tmpScan = new Scanner(System.in);
            int choice = Integer.valueOf(tmpScan.nextLine());
            switch (choice) {
                case 1:
                    ClearScreen();
                    holidayManager.run();
                    break;
                case 2:
                    System.out.println("System terminated.");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        }
    }
}

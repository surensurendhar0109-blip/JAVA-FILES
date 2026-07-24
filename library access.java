import java.util.Scanner;

public class LibraryAccessSystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String username = "Surenthar j";
        String password = "2007";

        System.out.println("=================================");
        System.out.println("     LIBRARY ACCESS SYSTEM");
        System.out.println("=================================");
        System.out.println("Developed by: Surenthar J");

        System.out.print("\nEnter Username: ");
        String user = sc.nextLine();

        System.out.print("Enter Password: ");
        String pass = sc.nextLine();

        if (user.equals(username) && pass.equals(password)) {

            System.out.println("\nWelcome, Surenthar J!");
            System.out.println("Login Successful.");

            int choice;

            do {
                System.out.println("\n===== LIBRARY MENU =====");
                System.out.println("1. View Books");
                System.out.println("2. Issue Book");
                System.out.println("3. Return Book");
                System.out.println("4. Exit");

                System.out.print("Enter your choice: ");
                choice = sc.nextInt();

                switch (choice) {

                    case 1:
                        System.out.println("\nAvailable Books:");
                        System.out.println("1. Java Programming");
                        System.out.println("2. Data Structures");
                        System.out.println("3. Python Basics");
                        break;

                    case 2:
                        System.out.print("Enter Book ID to Issue: ");
                        int issueId = sc.nextInt();
                        System.out.println("Book ID " + issueId + " issued successfully.");
                        break;

                    case 3:
                        System.out.print("Enter Book ID to Return: ");
                        int returnId = sc.nextInt();
                        System.out.println("Book ID " + returnId + " returned successfully.");
                        break;

                    case 4:
                        System.out.println("\nThank you, Surenthar J!");
                        System.out.println("Visit the library again.");
                        break;

                    default:
                        System.out.println("Invalid Choice!");
                }

            } while (choice != 4);

        } else {
            System.out.println("\nInvalid Username or Password!");
        }

        sc.close();
    }
}
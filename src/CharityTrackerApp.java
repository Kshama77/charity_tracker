import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CharityTrackerApp {
    private static final Scanner scanner = new Scanner(System.in);
    private static final List<Charity> charities = new ArrayList<>();
    private static int nextId = 1;

    public static void main(String[] args) {
        boolean running = true;
        System.out.println("================================");
        System.out.println("       CHARITY TRACKER");
        System.out.println("================================");

        while (running) {
            showMenu();
            int choice = readInt("Choose an option: ");

            switch (choice) {
                case 1:
                    addCharity();
                    break;
                case 2:
                    viewCharities();
                    break;
                case 3:
                    recordDonation();
                    break;
                case 4:
                    viewDonations();
                    break;
                case 5:
                    showDonationSummary();
                    break;
                case 6:
                    running = false;
                    System.out.println("Thank you for using Charity Tracker!");
                    break;
                default:
                    System.out.println("Invalid option. Please choose 1-6.");
            }
        }
        scanner.close();
    }

    private static void showMenu() {
        System.out.println("\\n--------------- MENU ---------------");
        System.out.println("1. Add a charity");
        System.out.println("2. View all charities");
        System.out.println("3. Record a donation");
        System.out.println("4. View donations for a charity");
        System.out.println("5. View donation summary");
        System.out.println("6. Exit");
        System.out.println("------------------------------------");
    }

    private static void addCharity() {
        System.out.println("\\nAdd a New Charity");
        String name = readText("Charity name: ");
        String cause = readText("Cause (education, health, animals, etc.): ");
        String email = readText("Contact email: ");

        Charity charity = new Charity(nextId++, name, cause, email);
        charities.add(charity);
        System.out.println("Charity added successfully. ID: " + charity.getId());
    }

    private static void viewCharities() {
        System.out.println("\\nAll Charities");
        if (charities.isEmpty()) {
            System.out.println("No charities have been added yet.");
            return;
        }

        for (Charity charity : charities) {
            System.out.println("------------------------------------");
            charity.displayInfo();
        }
    }

    private static void recordDonation() {
        if (charities.isEmpty()) {
            System.out.println("Please add a charity before recording a donation.");
            return;
        }

        viewCharities();
        int id = readInt("\\nEnter the charity ID: ");
        Charity charity = findCharityById(id);

        if (charity == null) {
            System.out.println("Charity not found.");
            return;
        }

        String donor = readText("Donor name: ");
        double amount = readAmount("Donation amount ($): ");

        charity.addDonation(new Donation(donor, amount));
        System.out.printf("Donation of $%.2f recorded for %s.%n", amount, charity.getName());
    }

    private static void viewDonations() {
        if (charities.isEmpty()) {
            System.out.println("No charities are available.");
            return;
        }

        int id = readInt("Enter the charity ID: ");
        Charity charity = findCharityById(id);

        if (charity == null) {
            System.out.println("Charity not found.");
            return;
        }

        System.out.println("\\nDonations for " + charity.getName());
        if (charity.getDonations().isEmpty()) {
            System.out.println("No donations recorded for this charity.");
            return;
        }

        for (Donation donation : charity.getDonations()) {
            donation.displayInfo();
        }
        System.out.printf("Total: $%.2f%n", charity.getTotalDonations());
    }

    private static void showDonationSummary() {
        if (charities.isEmpty()) {
            System.out.println("No charities or donations to summarize.");
            return;
        }

        double grandTotal = 0;
        int donationCount = 0;

        System.out.println("\\nDonation Summary");
        for (Charity charity : charities) {
            System.out.printf("%s: $%.2f (%d donations)%n",
                    charity.getName(),
                    charity.getTotalDonations(),
                    charity.getDonations().size());
            grandTotal += charity.getTotalDonations();
            donationCount += charity.getDonations().size();
        }

        System.out.println("------------------------------------");
        System.out.println("Number of charities: " + charities.size());
        System.out.println("Number of donations: " + donationCount);
        System.out.printf("Total donated: $%.2f%n", grandTotal);
    }

    private static Charity findCharityById(int id) {
        for (Charity charity : charities) {
            if (charity.getId() == id) {
                return charity;
            }
        }
        return null;
    }

    private static String readText(String prompt) {
        while (true) {
            System.out.print(prompt);
            String value = scanner.nextLine().trim();
            if (!value.isEmpty()) {
                return value;
            }
            System.out.println("This field cannot be empty.");
        }
    }

    private static int readInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid whole number.");
            }
        }
    }

    private static double readAmount(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                double amount = Double.parseDouble(scanner.nextLine().trim());
                if (amount > 0) {
                    return amount;
                }
                System.out.println("Amount must be greater than zero.");
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid amount, such as 25.50.");
            }
        }
    }
}

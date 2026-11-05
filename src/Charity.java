import java.util.ArrayList;
import java.util.List;

public class Charity {
    private int id;
    private String name;
    private String cause;
    private String contactEmail;
    private List<Donation> donations;

    public Charity(int id, String name, String cause, String contactEmail) {
        this.id = id;
        this.name = name;
        this.cause = cause;
        this.contactEmail = contactEmail;
        this.donations = new ArrayList<>();
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public String getCause() { return cause; }
    public String getContactEmail() { return contactEmail; }
    public List<Donation> getDonations() { return donations; }

    public void addDonation(Donation donation) {
        donations.add(donation);
    }

    public double getTotalDonations() {
        double total = 0;
        for (Donation donation : donations) {
            total += donation.getAmount();
        }
        return total;
    }

    public void displayInfo() {
        System.out.println("ID: " + id);
        System.out.println("Charity: " + name);
        System.out.println("Cause: " + cause);
        System.out.println("Contact: " + contactEmail);
        System.out.printf("Total donations: $%.2f%n", getTotalDonations());
    }
}

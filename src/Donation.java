import java.time.LocalDate;

public class Donation {
    private String donorName;
    private double amount;
    private LocalDate date;

    public Donation(String donorName, double amount) {
        this.donorName = donorName;
        this.amount = amount;
        this.date = LocalDate.now();
    }

    public String getDonorName() { return donorName; }
    public double getAmount() { return amount; }
    public LocalDate getDate() { return date; }

    public void displayInfo() {
        System.out.printf("Donor: %s | Amount: $%.2f | Date: %s%n",
                donorName, amount, date);
    }
}

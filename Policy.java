/**
 * The Policy class represents an insurance policy.
 */
public class Policy {
    private String policyNumber;
    private String providerName;
    private PolicyHolder policyHolder;
    private static int policyCount = 0;

    /**
     * Constructor to initialize a Policy object.
     */
    public Policy(String policyNumber, String providerName, PolicyHolder policyHolder) {
        this.policyNumber = policyNumber;
        this.providerName = providerName;
        this.policyHolder = policyHolder;
        policyCount++;
    }

    /**
     * Calculates and returns the price of the policy.
     */
    public double getPrice() {
        double basePrice = 600.0;
        double ageSurcharge = policyHolder.getAge() > 50 ? 75.0 : 0.0;
        double smokerSurcharge = policyHolder.getSmokingStatus().equalsIgnoreCase("smoker") ? 100.0 : 0.0;
        double bmiSurcharge = (policyHolder.getBMI() - 35.0) * 20.0;

        if (bmiSurcharge < 0) {
            bmiSurcharge = 0.0;
        }

        return basePrice + ageSurcharge + smokerSurcharge + bmiSurcharge;
    }

    /**
     * Returns the number of Policy objects created.
     */
    public static int getPolicyCount() {
        return policyCount;
    }

    /**
     * Overrides the toString method to provide string representation of a Policy object.
     */
    @Override
    public String toString() {
        return String.format(
            "Policy Number: %s%nProvider Name: %s%n%sPolicy Price: $%.2f",
            policyNumber, providerName, policyHolder.toString(), getPrice()
        );
    }
}

/**
 * The PolicyHolder class represents the individual associated with an insurance policy.
 */
public class PolicyHolder {
    private String firstName;
    private String lastName;
    private int age;
    private String smokingStatus; // "smoker" or "non-smoker"
    private double height; // in inches
    private double weight; // in pounds

    /**
     * Constructor to initialize a PolicyHolder object.
     */
    public PolicyHolder(String firstName, String lastName, int age, String smokingStatus, double height, double weight) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.smokingStatus = smokingStatus;
        this.height = height;
        this.weight = weight;
    }

    /**
     * Getter for age.
     */
    public int getAge() {
        return age;
    }

    /**
     * Getter for smoking status.
     */
    public String getSmokingStatus() {
        return smokingStatus;
    }

    /**
     * Calculates and returns the BMI (Body Mass Index) of the policyholder.
     */
    public double getBMI() {
        return (weight * 703) / (height * height);
    }

    /**
     * Overrides the toString method to provide string representation of a PolicyHolder object.
     */
    @Override
    public String toString() {
        return String.format(
            "Policyholder's First Name: %s%nPolicyholder's Last Name: %s%nPolicyholder's Age: %d%nPolicyholder's Smoking Status (Y/N): %s%nPolicyholder's Height: %.1f inches%nPolicyholder's Weight: %.1f pounds%nPolicyholder's BMI: %.2f%n",
            firstName, lastName, age, smokingStatus, height, weight, getBMI()
        );
    }
}

/**
 * The Policy class represents an insurance policy with details 
 * about the policyholder and calculations for BMI and policy price.
 */
public class Policy {
    // Fields
    private String policyNumber;
    private String providerName;
    private String firstName;
    private String lastName;
    private int age;
    private String smokingStatus;
    private double height;
    private double weight;

    // Constructors
    /**
     * Default constructor initializing fields to default values.
     */
    public Policy() {
        policyNumber = "";
        providerName = "";
        firstName = "";
        lastName = "";
        age = 0;
        smokingStatus = "";
        height = 0;
        weight = 0;
    }

    /**
     * Constructor to initialize all fields with specified values.
     *
     * @param pNumber Policy number
     * @param pName Provider name
     * @param fName First name
     * @param lName Last name
     * @param a Age
     * @param sStatus Smoking status ("smoker" or "non-smoker")
     * @param h Height in inches
     * @param w Weight in pounds
     */
    public Policy(String pNumber, String pName, String fName, String lName, int a, String sStatus, double h, double w) {
        policyNumber = pNumber;
        providerName = pName;
        firstName = fName;
        lastName = lName;
        age = a;
        smokingStatus = sStatus;
        height = h;
        weight = w;
    }

    // Getters and Setters

    /**
     * @return Policy number.
     */
    public String getPolicyNumber() {
        return policyNumber;
    }

    // (Additional getters and setters follow the same format; omitted here for brevity.)

    // Calculations
    /**
     * Calculates and returns the policyholder's BMI.
     *
     * @return BMI as a double.
     */
    public double getBMI() {
        final double CONVFACTOR = 703;
        return (weight * CONVFACTOR) / (height * height);
    }

    /**
     * Calculates and returns the policy price based on age, smoking status, and BMI.
     *
     * @return Policy price as a double.
     */
    public double getPrice() {
        final double BASE_PRICE = 600;
        final double ADDITIONAL_FEE_AGE = 75;
        final double ADDITIONAL_FEE_SMOKING = 100;
        final double ADDITIONAL_FEE_PER_BMI = 20;

        final int AGE_THRESHOLD = 50;
        final int BMI_THRESHOLD = 35;

        double price = BASE_PRICE;

        if (age > AGE_THRESHOLD) 
            price += ADDITIONAL_FEE_AGE;
        if (smokingStatus.equalsIgnoreCase("smoker")) 
            price += ADDITIONAL_FEE_SMOKING;
        if (getBMI() > BMI_THRESHOLD) 
            price += ((getBMI() - BMI_THRESHOLD) * ADDITIONAL_FEE_PER_BMI);

        return price;
    }
}

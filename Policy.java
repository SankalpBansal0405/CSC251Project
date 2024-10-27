public class Policy {
    private int policyNumber;
    private String providerName;
    private String firstName;
    private String lastName;
    private int age;
    private String smokingStatus;
    private double height;
    private double weight;

    // constructor incase user doesnt enter anything
    public Policy() {
        policyNumber = 0;
        providerName = "Unknown";
        firstName = "Unknown";
        lastName = "Unknown";
        age = 0;
        smokingStatus = "non-smoker";
        height = 0.0;
        weight = 0.0;
    }

    // constructor if user enters stuff
    public Policy(int policyNumber, String providerName, String firstName, String lastName, int age, String smokingStatus, double height, double weight) {
        policyNumber = policyNumber;
        providerName = providerName;
        firstName = firstName;
        lastName = lastName;
        age = age;
        smokingStatus = smokingStatus;
        height = height;
        weight = weight;
    }

    // Getters and setters for each variable
    public int getPolicyNumber() { return policyNumber; }
    public void setPolicyNumber(int policyNumber) { policyNumber = policyNumber; }

    public String getProviderName() { return providerName; }
    public void setProviderName(String providerName) { providerName = providerName; }

    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { firstName = firstName; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { lastName = lastName; }

    public int getAge() { return age; }
    public void setAge(int age) { age = age; }

    public String getSmokingStatus() { return smokingStatus; }
    public void setSmokingStatus(String smokingStatus) { smokingStatus = smokingStatus; }

    public double getHeight() { return height; }
    public void setHeight(double height) { height = height; }

    public double getWeight() { return weight; }
    public void setWeight(double weight) { weight = weight; }

    // Calculate BMI
    public double calculateBMI() {
        return (weight * 703) / (height * height);
    }

    // Calculate the price of the policy
    public double calculatePolicyPrice() {
        double baseFee = 600.0;
        double additionalFee = 0.0;

        if (age > 50) {
            additionalFee += 75.0;
        }
        if (smokingStatus.equalsIgnoreCase("smoker")) {
            additionalFee += 100.0;
        }

        double bmi = calculateBMI();
        if (bmi > 35) {
            additionalFee += (bmi - 35) * 20;
        }

        return baseFee + additionalFee;
    }
}

import java.util.*;
import java.io.*;

public class Demo {

    public static void main(String[] args) {
        ArrayList<Policy> policies = new ArrayList<>();
        int smokerCount = 0, nonSmokerCount = 0;

        try {
            File file = new File("PolicyInformation.txt");
            Scanner inputFile = new Scanner(file);

            while (inputFile.hasNext()) {
                String policyNumber = inputFile.nextLine();
                String providerName = inputFile.nextLine();
                String firstName = inputFile.nextLine();
                String lastName = inputFile.nextLine();
                int age = Integer.parseInt(inputFile.nextLine());
                String smokingStatus = inputFile.nextLine();
                double height = Double.parseDouble(inputFile.nextLine());
                double weight = Double.parseDouble(inputFile.nextLine());

                if (inputFile.hasNext()) { 
                    inputFile.nextLine(); 
                }

                Policy policy = new Policy(policyNumber, providerName, firstName, lastName, age, smokingStatus, height, weight);
                policies.add(policy);

                if (smokingStatus.equalsIgnoreCase("smoker")) {
                    smokerCount++;
                } else {
                    nonSmokerCount++;
                }
            }

            inputFile.close();

        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }

        // Display all policy information
        for (Policy policy : policies) {
            System.out.println("Policy Number: " + policy.getPolicyNumber());
            System.out.println("Provider Name: " + policy.getProviderName());
            System.out.println("Policyholder's First Name: " + policy.getFirstName());
            System.out.println("Policyholder's Last Name: " + policy.getLastName());
            System.out.println("Policyholder's Age: " + policy.getAge());
            System.out.println("Policyholder's Smoking Status (smoker/non-smoker): " + policy.getSmokingStatus());
            System.out.println("Policyholder's Height: " + policy.getHeight() + " inches");
            System.out.println("Policyholder's Weight: " + policy.getWeight() + " pounds");
            System.out.printf("Policyholder's BMI: %.2f\n", policy.getBMI());
            System.out.printf("Policy Price: $%.2f\n\n", policy.getPrice());
        }

        // Display smoker/non-smoker counts
        System.out.println("The number of policies with a smoker is: " + smokerCount);
        System.out.println("The number of policies with a non-smoker is: " + nonSmokerCount);
    }
}

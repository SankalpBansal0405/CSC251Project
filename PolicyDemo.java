import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class PolicyDemo {
    public static void main(String[] args) throws IOException {
        // File containing policy data
        File file = new File("PolicyInformation.txt");
        Scanner inputFile = new Scanner(file);

        // Count the number of lines to determine the number of policies
        int policyCount = countPolicies(file);

        // Create an array to store Policy objects
        Policy[] policies = new Policy[policyCount];

        // Read data from the file and populate the array
        int index = 0;
        int numSmokers = 0;
        int numNonSmokers = 0;

        while (inputFile.hasNext()) {
            String policyNumber = inputFile.nextLine();
            String providerName = inputFile.nextLine();
            String firstName = inputFile.nextLine();
            String lastName = inputFile.nextLine();
            int age = inputFile.nextInt();
            inputFile.nextLine(); // Consume the newline character
            String smokingStatus = inputFile.nextLine();
            double height = inputFile.nextDouble();
            double weight = inputFile.nextDouble();
            if (inputFile.hasNext()) inputFile.nextLine(); // Skip blank line

            // Create PolicyHolder and Policy objects
            PolicyHolder holder = new PolicyHolder(firstName, lastName, age, smokingStatus, height, weight);
            Policy policy = new Policy(policyNumber, providerName, holder);

            // Add the Policy to the array
            policies[index] = policy;
            index++;

            // Count smokers and non-smokers
            if (smokingStatus.equalsIgnoreCase("smoker")) {
                numSmokers++;
            } else {
                numNonSmokers++;
            }
        }
        inputFile.close();

        // Display all policies
        for (int i = 0; i < policyCount; i++) {
            System.out.println(policies[i]);
            System.out.println();
        }

        // Display summary
        System.out.printf("There were %d Policy objects created.%n", Policy.getPolicyCount());
        System.out.printf("The number of policies with a smoker is: %d%n", numSmokers);
        System.out.printf("The number of policies with a non-smoker is: %d%n", numNonSmokers);
    }

    /**
     * Helper method to count the number of policies in the file.
     * Assumes each policy consists of 8 lines, including a blank line at the end.
     *
     * @param file The file containing policy data.
     * @return The number of policies in the file.
     * @throws IOException If an I/O error occurs.
     */
    private static int countPolicies(File file) throws IOException {
        Scanner scanner = new Scanner(file);
        int lineCount = 0;

        while (scanner.hasNextLine()) {
            scanner.nextLine();
            lineCount++;
        }
        scanner.close();

        // Each policy is 8 lines including the blank line.
        return lineCount / 8;
    }
}

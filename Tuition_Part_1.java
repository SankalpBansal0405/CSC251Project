import java.util.*; 
import java.io.*;

public class Tuition_Part_1 {

   public static void main(String[] args) {                            
      try {
         File file = new File("tuition.txt");
         Scanner inputFile = new Scanner(file);
      
         String courseNumber = "", courseName = "";
         double contactHours = 0.0, creditHours = 0.0, totalTuitionCost = 0.0;
         ArrayList<Course> courses = new ArrayList<Course>();
      
         while(inputFile.hasNext()) {         
            courseNumber = inputFile.nextLine();  
            courseName = inputFile.nextLine();
            contactHours = inputFile.nextDouble();
            creditHours = inputFile.nextDouble();
         
            if(inputFile.hasNext()) { 
               inputFile.nextLine();
               inputFile.nextLine();
            }
         
            Course c = new Course(courseNumber, courseName, contactHours ,creditHours);
            courses.add(c); 
         } 
      
         inputFile.close();
      
         for(int i = 0; i < courses.size(); i++) { 
            System.out.println("Course Name: " + courses.get(i).getCourseName());
            System.out.println("Course Number: " + courses.get(i).getCourseNumber());
            System.out.println("Contact Hours: " + courses.get(i).getContactHours());
            System.out.println("Credit Hours: " + courses.get(i).getCreditHours());
            System.out.printf("Tuition Cost: $%.2f \n", courses.get(i).getTuitionCost());
            System.out.println();
         
            totalTuitionCost += courses.get(i).getTuitionCost();
         }  
           
         System.out.printf("Total Tuition Cost: $%,.2f \n", totalTuitionCost);
      
      } catch(IOException ex) {
         System.out.println("Something went wrong reading the file: " + ex.getMessage());
      }
   }
}

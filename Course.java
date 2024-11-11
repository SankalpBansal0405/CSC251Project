public class Course {

   // Fields
   private String courseNumber, courseName; 
   private double contactHours, creditHours;
   private final double COST_PER_HR = 72; 
   
   // Constructor
   public Course(String cNum, String cName, double contHrs, double credHrs) {
      courseNumber = cNum;
      courseName = cName;
      contactHours = contHrs;
      creditHours = credHrs;
   }

   // Setter methods
   public void setCourseNumber(String cNum) { courseNumber = cNum; }
   public void setCourseName(String cName) { courseName = cName; }
   public void setContactHours(double cHours) { contactHours = cHours; }
   public void setCreditHours(double cHours) { creditHours = cHours; }

   // Getter methods
   public String getCourseNumber() { return courseNumber; }
   public String getCourseName() { return courseName; }
   public double getContactHours() { return contactHours; }
   public double getCreditHours() { return creditHours; }

   // Method to calculate tuition cost
   public double getTuitionCost() {
      return creditHours * COST_PER_HR;
   }
}

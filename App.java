public class App {
    public class Main {
        public static void main(String[] args) {
            CollegeManager collegeManager = new CollegeManager();
    
            collegeManager.addStudent("Yash Kandhare", "yashkandhare74@gmail.com", "9359155287", "Kothrud, Pune-38");
            collegeManager.addStudent("Ashutosh Pawar", "ashutoshpawar7@gmail.com", "7219104591", "Bavdhan, Pune-38");
            collegeManager.addStudent("Ajinkya Wankhede", "ajinkya7859@gmail.com", "8010772400", "Warje, Pune-38");
    
            collegeManager.addCourse("Python", "Neha Mam", 3, 2);
            collegeManager.addCourse("Java", "Vishwanath Sir", 4, 3);
            collegeManager.addCourse("OOSE", "Prajakta Mam", 3, 1);
    
            collegeManager.enrollStudent(1, 1, "2023-010-01");
            collegeManager.enrollStudent(1, 2, "2023-10-02");
            collegeManager.enrollStudent(2, 2, "2023-10-03");
            collegeManager.enrollStudent(3, 3, "2023-10-04");
    
            collegeManager.displayEnrolledStudents(2);
            collegeManager.displayEnrolledCourses(1);
        }
    }
}

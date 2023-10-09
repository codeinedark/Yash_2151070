
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Student {
    private String name;
    private String email;
    private String phoneNumber;
    private String address;

    public Student(String name, String email, String phoneNumber, String address) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}

class Course {
    private int courseID;
    private String courseName;
    private String instructor;
    private int credits;
    private int maxCapacity;
    private List<Student> enrolledStudents;

    public Course(int courseID, String courseName, String instructor, int credits, int maxCapacity) {
        this.courseID = courseID;
        this.courseName = courseName;
        this.instructor = instructor;
        this.credits = credits;
        this.maxCapacity = maxCapacity;
        this.enrolledStudents = new ArrayList<>();
    }

    public int getCourseID() {
        return courseID;
    }

    public void setCourseID(int courseID) {
        this.courseID = courseID;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getInstructor() {
        return instructor;
    }

    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public void setMaxCapacity(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    public List<Student> getEnrolledStudents() {
        return enrolledStudents;
    }

    public void addStudent(Student student) {
        if (enrolledStudents.size() < maxCapacity) {
            enrolledStudents.add(student);
        } else {
            System.out.println("Course is full, cannot enroll student.");
        }
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseID=" + courseID +
                ", courseName='" + courseName + '\'' +
                ", instructor='" + instructor + '\'' +
                ", credits=" + credits +
                ", maxCapacity=" + maxCapacity +
                ", enrolledStudents=" + enrolledStudents +
                '}';
    }
}

class Enrollment {
    private int enrollmentID;
    private Student student;
    private Course course;
    private String enrollmentDate;

    public Enrollment(int enrollmentID, Student student, Course course, String enrollmentDate) {
        this.enrollmentID = enrollmentID;
        this.student = student;
        this.course = course;
        this.enrollmentDate = enrollmentDate;
    }

    public int getEnrollmentID() {
        return enrollmentID;
    }

    public void setEnrollmentID(int enrollmentID) {
        this.enrollmentID = enrollmentID;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public String getEnrollmentDate() {
        return enrollmentDate;
    }

    public void setEnrollmentDate(String enrollmentDate) {
        this.enrollmentDate = enrollmentDate;
    }

    @Override
    public String toString() {
        return "Enrollment{" +
                "enrollmentID=" + enrollmentID +
                ", student=" + student +
                ", course=" + course +
                ", enrollmentDate='" + enrollmentDate + '\'' +
                '}';
    }
}

class CollegeManager {
    private int studentCounter;
    private int courseCounter;
    private int enrollmentCounter;
    private HashMap<Integer, Student> students;
    private HashMap<Integer, Course> courses;
    private HashMap<Integer, Enrollment> enrollments;

    public CollegeManager() {
        this.studentCounter = 0;
        this.courseCounter = 0;
        this.enrollmentCounter = 0;
        this.students = new HashMap<>();
        this.courses = new HashMap<>();
        this.enrollments = new HashMap<>();
    }

    public void addStudent(String name, String email, String phoneNumber, String address) {
        Student student = new Student(name, email, phoneNumber, address);
        int studentID = generateStudentID();
        students.put(studentID, student);
        System.out.println("Student added with ID: " + studentID);
    }

    public void addCourse(String courseName, String instructor, int credits, int maxCapacity) {
        Course course = new Course(generateCourseID(), courseName, instructor, credits, maxCapacity);
        courses.put(course.getCourseID(), course);
        System.out.println("Course added with ID: " + course.getCourseID());
    }

    public void enrollStudent(int studentID, int courseID, String enrollmentDate) {
        if (students.containsKey(studentID) && courses.containsKey(courseID)) {
            Student student = students.get(studentID);
            Course course = courses.get(courseID);
            Enrollment enrollment = new Enrollment(generateEnrollmentID(), student, course, enrollmentDate);
            enrollments.put(enrollment.getEnrollmentID(), enrollment);
            course.addStudent(student);
            System.out.println("Student enrolled in course.");
        } else {
            System.out.println("Invalid student or course ID.");
        }
    }

    public void displayEnrolledStudents(int courseID) {
        if (courses.containsKey(courseID)) {
            Course course = courses.get(courseID);
            List<Student> enrolledStudents = course.getEnrolledStudents();
            System.out.println("Enrolled students in course " + courseID + ":");
            for (Student student : enrolledStudents) {
                System.out.println(student);
            }
        } else {
            System.out.println("Invalid course ID.");
        }
    }

    public void displayEnrolledCourses(int studentID) {
        if (students.containsKey(studentID)) {
            Student student = students.get(studentID);
            System.out.println("Enrolled courses for student " + studentID + ":");
            for (Enrollment enrollment : enrollments.values()) {
                if (enrollment.getStudent().equals(student)) {
                    System.out.println(enrollment.getCourse());
                }
            }
        } else {
            System.out.println("Invalid student ID.");
        }
    }

    private int generateStudentID() {
        return ++studentCounter;
    }

    private int generateCourseID() {
        return ++courseCounter;
    }

    private int generateEnrollmentID() {
        return ++enrollmentCounter;
    }
}




import java.sql.Connection;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        Student student1 = new Student(101, "Alice", 22, 3.8);

        Instructor instructor1 = new Instructor(
                201, "John", 35, "Computer Science", 150000
        );
        Course course1 = new Course(1, "Java Programming", "CS101", 4);
        UndergraduateStudent undergrad = new UndergraduateStudent(
                102, "Peter", 23, 3.8
        );

        GraduateStudent graduate = new GraduateStudent(
                103, "Mary", 25, 3.8
        );

        System.out.println(student1);
        System.out.println(instructor1);
        System.out.println(course1);
        System.out.println("Undergraduate GPA: " + undergrad.calculateGPA());
        System.out.println("Graduate GPA: " + graduate.calculateGPA());

        List<Student> students = new ArrayList<>();

        students.add(student1);
        students.add(undergrad);
        students.add(graduate);

        Set<String> courseCodes = new HashSet<>();

        courseCodes.add("CS101");
        courseCodes.add("LAW101");
        courseCodes.add("CS101");

        System.out.println("Course Codes:");
        System.out.println(courseCodes);

        Map<Integer, String> studentNames = new HashMap<>();

        studentNames.put(101, "Alice");
        studentNames.put(102, "Peter");
        studentNames.put(103, "Mary");

        System.out.println("Student Names:");
        System.out.println(studentNames);

        System.out.println("List of Students:");
        for (Student student : students) {
            System.out.println(student);
        }
        StudentDAO studentDAO = new StudentDAO();
        CourseDAO courseDAO = new CourseDAO();
        EnrollmentDAO enrollmentDAO = new EnrollmentDAO();

        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n===== UNIVERSITY MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Delete Student");
            System.out.println("4. Add Course");
            System.out.println("5. View All Courses");
            System.out.println("6. Delete Course");
            System.out.println("7. Enroll Student");
            System.out.println("8. Update Enrollment");
            System.out.println("9. View Students with Courses");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");

            try {
                choice = scanner.nextInt();

                switch (choice) {

                    case 1:
                        System.out.print("Enter student ID: ");
                        int studentId = scanner.nextInt();

                        scanner.nextLine();
                        System.out.print("Enter student name: ");
                        String name = scanner.nextLine();

                        System.out.print("Enter age: ");
                        int age = scanner.nextInt();

                        System.out.print("Enter GPA: ");
                        double gpa = scanner.nextDouble();

                        studentDAO.insertStudent(studentId, name, age, gpa);
                        break;

                    case 2:
                        studentDAO.getAllStudents();
                        break;

                    case 3:
                        System.out.print("Enter student ID to delete: ");
                        studentDAO.deleteStudent(scanner.nextInt());
                        break;

                    case 4:
                        System.out.print("Enter course ID: ");
                        int courseId = scanner.nextInt();

                        scanner.nextLine();
                        System.out.print("Enter course name: ");
                        String courseName = scanner.nextLine();

                        System.out.print("Enter course code: ");
                        String courseCode = scanner.nextLine();

                        System.out.print("Enter credit hours: ");
                        int credits = scanner.nextInt();

                        courseDAO.addCourse(courseId, courseName, courseCode, credits);
                        break;

                    case 5:
                        courseDAO.getAllCourses();
                        break;

                    case 6:
                        System.out.print("Enter course ID to delete: ");
                        courseDAO.deleteCourse(scanner.nextInt());
                        break;

                    case 7:
                        System.out.print("Enter enrollment ID: ");
                        int enrollmentId = scanner.nextInt();

                        System.out.print("Enter student ID: ");
                        int enrollStudentId = scanner.nextInt();

                        System.out.print("Enter course ID: ");
                        int enrollCourseId = scanner.nextInt();

                        enrollmentDAO.enrollStudent(
                                enrollmentId, enrollStudentId, enrollCourseId);
                        break;

                    case 8:
                        System.out.print("Enter enrollment ID: ");
                        int updateId = scanner.nextInt();

                        System.out.print("Enter new course ID: ");
                        int newCourseId = scanner.nextInt();

                        enrollmentDAO.updateEnrollment(updateId, newCourseId);
                        break;

                    case 9:
                        enrollmentDAO.getStudentsWithCourses();
                        break;

                    case 0:
                        System.out.println("Thank you for using the system!");
                        break;

                    default:
                        System.out.println("Invalid choice. Try again.");
                }

            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter the correct data type.");
                scanner.nextLine();
                choice = -1;
            }

        } while (choice != 0);

        scanner.close();
    }
        }
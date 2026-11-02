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
    }

}
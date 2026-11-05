import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EnrollmentDAO {

    // Enroll a student in a course
    public void enrollStudent(int enrollmentId, int studentId, int courseId) {

        String sql = "INSERT INTO enrollments (enrollment_id, student_id, course_id) VALUES (?, ?, ?)";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, enrollmentId);
            statement.setInt(2, studentId);
            statement.setInt(3, courseId);

            statement.executeUpdate();
            System.out.println("Student enrolled successfully!");

        } catch (SQLException e) {
            System.out.println("Error enrolling student: " + e.getMessage());
        }
    }

    // Update a student's course enrollment
    public void updateEnrollment(int enrollmentId, int newCourseId) {

        String sql = "UPDATE enrollments SET course_id = ? WHERE enrollment_id = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, newCourseId);
            statement.setInt(2, enrollmentId);

            int rowsUpdated = statement.executeUpdate();

            if (rowsUpdated > 0) {
                System.out.println("Enrollment updated successfully!");
            } else {
                System.out.println("Enrollment not found!");
            }

        } catch (SQLException e) {
            System.out.println("Error updating enrollment: " + e.getMessage());
        }
    }

    // Display students and their enrolled courses
    public void getStudentsWithCourses() {

        String sql = "SELECT s.student_id, s.name, c.course_name, c.course_code " +
                "FROM students s " +
                "JOIN enrollments e ON s.student_id = e.student_id " +
                "JOIN courses c ON e.course_id = c.course_id";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                System.out.println("Student ID: " + resultSet.getInt("student_id"));
                System.out.println("Student Name: " + resultSet.getString("name"));
                System.out.println("Course: " + resultSet.getString("course_name"));
                System.out.println("Course Code: " + resultSet.getString("course_code"));
                System.out.println("-------------------");
            }

        } catch (SQLException e) {
            System.out.println("Error retrieving enrollments: " + e.getMessage());
        }
    }
}
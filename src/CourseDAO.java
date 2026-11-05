
    import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

    public class CourseDAO {

        // Add a new course
        public void addCourse(int courseId, String courseName,
                              String courseCode, int creditHours) {

            String sql = "INSERT INTO courses (course_id, course_name, course_code, credit_hours) VALUES (?, ?, ?, ?)";

            try (Connection connection = DatabaseConnection.getConnection();
                 PreparedStatement statement = connection.prepareStatement(sql)) {

                statement.setInt(1, courseId);
                statement.setString(2, courseName);
                statement.setString(3, courseCode);
                statement.setInt(4, creditHours);

                statement.executeUpdate();
                System.out.println("Course added successfully!");

            } catch (SQLException e) {
                System.out.println("Error adding course: " + e.getMessage());
            }
        }

        // Display all courses
        public void getAllCourses() {

            String sql = "SELECT * FROM courses";

            try (Connection connection = DatabaseConnection.getConnection();
                 PreparedStatement statement = connection.prepareStatement(sql);
                 ResultSet resultSet = statement.executeQuery()) {

                while (resultSet.next()) {

                    int id = resultSet.getInt("course_id");
                    String name = resultSet.getString("course_name");
                    String code = resultSet.getString("course_code");
                    int credits = resultSet.getInt("credit_hours");

                    System.out.println("Course ID: " + id);
                    System.out.println("Course Name: " + name);
                    System.out.println("Course Code: " + code);
                    System.out.println("Credit Hours: " + credits);
                    System.out.println("-------------------");
                }

            } catch (SQLException e) {
                System.out.println("Error retrieving courses: " + e.getMessage());
            }
        }

        // Delete a course
        public void deleteCourse(int courseId) {

            String sql = "DELETE FROM courses WHERE course_id = ?";

            try (Connection connection = DatabaseConnection.getConnection();
                 PreparedStatement statement = connection.prepareStatement(sql)) {

                statement.setInt(1, courseId);

                int rowsDeleted = statement.executeUpdate();

                if (rowsDeleted > 0) {
                    System.out.println("Course deleted successfully!");
                } else {
                    System.out.println("Course not found!");
                }

            } catch (SQLException e) {
                System.out.println("Error deleting course: " + e.getMessage());
            }
        }
    }


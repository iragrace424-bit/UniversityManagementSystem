
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class StudentDAO {

    public void insertStudent(int studentId, String name, int age, double gpa) {

        String sql = "INSERT INTO students (student_id, name, age, gpa) VALUES (?, ?, ?, ?)";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, studentId);
            statement.setString(2, name);
            statement.setInt(3, age);
            statement.setDouble(4, gpa);

            statement.executeUpdate();

            System.out.println("Student added successfully!");

        } catch (SQLException e) {
            System.out.println("Error inserting student: " + e.getMessage());
        }
    }

    public void getAllStudents() {

        String sql = "SELECT * FROM students";

        try (Connection connection = DatabaseConnection.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {

            while (resultSet.next()) {

                int id = resultSet.getInt("student_id");
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                double gpa = resultSet.getDouble("gpa");

                System.out.println("ID: " + id);
                System.out.println("Name: " + name);
                System.out.println("Age: " + age);
                System.out.println("GPA: " + gpa);
                System.out.println("-------------------");
            }

        } catch (SQLException e) {
            System.out.println("Error retrieving students: " + e.getMessage());
        }
    }

    public void updateStudent(int studentId, String newName, int newAge, double newGpa) {

        String sql = "UPDATE students SET name = ?, age = ?, gpa = ? WHERE student_id = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, newName);
            statement.setInt(2, newAge);
            statement.setDouble(3, newGpa);
            statement.setInt(4, studentId);

            int rowsUpdated = statement.executeUpdate();

            if (rowsUpdated > 0) {
                System.out.println("Student updated successfully!");
            } else {
                System.out.println("Student not found!");
            }

        } catch (SQLException e) {
            System.out.println("Error updating student: " + e.getMessage());
        }
        }
        public void deleteStudent(int studentId) {

            String sql = "DELETE FROM students WHERE student_id = ?";

            try (Connection connection = DatabaseConnection.getConnection();
                 PreparedStatement statement = connection.prepareStatement(sql)) {

                statement.setInt(1, studentId);

                int rowsDeleted = statement.executeUpdate();

                if (rowsDeleted > 0) {
                    System.out.println("Student deleted successfully!");
                } else {
                    System.out.println("Student not found!");
                }

            } catch (SQLException e) {
                System.out.println("Error deleting student: " + e.getMessage());
            }
        }
    }

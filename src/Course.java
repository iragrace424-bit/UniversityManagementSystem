public class Course {
    private int courseId;
    private String courseName;
    private String courseCode;
    private int creditHours;

    public Course(int courseId, String courseName, String courseCode, int creditHours) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.courseCode = courseCode;
        this.creditHours = creditHours;
    }
    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCreditHours(int creditHours) {
        this.creditHours = creditHours;
    }

    public int getCreditHours() {
        return creditHours;
    }
    @Override
    public String toString() {
        return "Course ID: " + courseId +
                ", Course Name: " + courseName +
                ", Course Code: " + courseCode +
                ", Credit Hours: " + creditHours;
    }
}

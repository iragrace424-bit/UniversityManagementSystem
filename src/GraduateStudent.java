public class GraduateStudent extends Student {

    public GraduateStudent(int studentId, String name, int age, double gpa) {
        super(studentId, name, age, gpa);
    }

    @Override
    public double calculateGPA() {
        return getGpa() * 0.9;
    }
}
public class UndergraduateStudent extends Student {

    public UndergraduateStudent(int studentId, String name, int age, double gpa) {
        super(studentId, name, age, gpa);
    }

    @Override
    public double calculateGPA() {
        return getGpa();
    }
}
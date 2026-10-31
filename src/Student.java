public class Student extends Person {
    private double gpa;


    public Student(int studentId, String name, int age, double gpa) {
        super(studentId, name, age);
        this.gpa = gpa;
    }


    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    public double getGpa() {
        return gpa;
    }
    @Override
    public String toString() {
        return "Student ID: " + getId() +
                ", Name: " + getName() +
                ", Age: " + getAge() +
                ", GPA: " + gpa;
    }
}

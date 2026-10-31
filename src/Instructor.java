public class Instructor extends Person {
    private String department;
    private double salary;

    public Instructor(int id, String name, int age, String department, double salary) {
        super(id, name, age);
        this.department = department;
        this.salary = salary;
    }
    public void setDepartment(String department) {
        this.department = department;
    }

    public String getDepartment() {
        return department;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }
    @Override
    public String toString() {
        return "Instructor ID: " + getId() +
                ", Name: " + getName() +
                ", Age: " + getAge() +
                ", Department: " + department +
                ", Salary: " + salary;
    }
}

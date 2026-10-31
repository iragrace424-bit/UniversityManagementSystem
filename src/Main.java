public class Main {
    public static void main(String[] args) {

        Student student1 = new Student(101, "Alice", 22, 3.8);

        Instructor instructor1 = new Instructor(
                201, "John", 35, "Computer Science", 150000
        );

        System.out.println(student1);
        System.out.println(instructor1);
    }
}
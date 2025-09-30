import java.util.*;
import java.util.stream.*;

class Student {
    String name;
    double marks;

    Student(String name, double marks) {
        this.name = name;
        this.marks = marks;
    }
}

public class StudentStreamExample {
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
                new Student("Ravi", 80),
                new Student("Sita", 60),
                new Student("Aman", 90),
                new Student("Pooja", 70)
        );

        System.out.println("Students scoring above 75% sorted by marks:");

        students.stream()
                .filter(s -> s.marks > 75) // filtering
                .sorted((s1, s2) -> Double.compare(s1.marks, s2.marks)) // sorting by marks
                .map(s -> s.name) // extract names
                .forEach(System.out::println); // display
    }
}

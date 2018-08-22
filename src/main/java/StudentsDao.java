import java.util.ArrayList;
import java.util.List;

public class StudentsDao implements iStudents {
    private List<Student> students;

    public List<Student> getAllStudents() {
        if (students == null) {
            students = new ArrayList<>();
            students.add(new Student("Matt", "rich", 19));
            students.add(new Student("Marty", "lot", 28));
            students.add(new Student("Matt", "rich", 19));
            students.add(new Student("Marty", "lot", 28));
            students.add(new Student("Matt", "rich", 19));
            students.add(new Student("Marty", "lot", 28));
            students.add(new Student("Matt", "rich", 19));
            students.add(new Student("Marty", "lot", 28));
        }
        return students;
    }
}

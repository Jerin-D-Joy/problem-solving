package learn;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StudentProcessor {

    private List<Student> students;

    public StudentProcessor(List<Student> students) {
        this.students = students;
    }

    public String getStudentNamesAsString() {
        return this.students.stream().map(Student::getName).collect(Collectors.joining(", "));
    }

    public int getTotalMarkOfStudent(Student student) {
        return student.marks.stream().collect(Collectors.summingInt(mark ->  mark));
    }

    public Map<String, List<Student>> groupStudentsByDepartment() {
        return students.stream().collect(Collectors.groupingBy(Student::getDepartment));
    }

    public Map<String, Integer> computeSumOfMarksByDepartment() {
        return students.stream().collect(Collectors.groupingBy(Student::getDepartment,
                Collectors.summingInt(student -> student.getMarks().stream()
                        .reduce(0, Integer::sum))));
    }

    public Map<Boolean, List<Student>> getPassedAndFailedStudents() {
        return students.stream().collect(Collectors.partitioningBy(student ->
                student.getMarks().stream().reduce(0, Integer::sum) > 45));
    }
}

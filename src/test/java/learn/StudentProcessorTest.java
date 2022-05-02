package learn;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StudentProcessorTest {

    private List<Student> students;
    private StudentProcessor studentProcessor;

    @Before
    public void setUp() {
        students = new ArrayList<>();
        students.add(new Student(1, "Abhijith", "CSE", Arrays.asList(10, 15, 30)));
        students.add(new Student(2, "Adhi", "ECE", Arrays.asList(98, 37, 58)));
        students.add(new Student(3, "Prince", "ME", Arrays.asList(14, 56, 78)));
        students.add(new Student(4, "Rakesh", "CSE", Arrays.asList(89,76,34)));
        students.add(new Student(5, "Deepika", "CSE", Arrays.asList(1, 2,3)));
        this.studentProcessor = new StudentProcessor(students);
    }

    @Test
    public void getStudentNamesAsStringTest() {
        Assert.assertEquals("Abhijith, Adhi, Prince, Rakesh, Deepika", studentProcessor.getStudentNamesAsString());
    }

    @Test
    public void getTotalMarkOfStudentTest() {
        Assert.assertEquals(55, studentProcessor.getTotalMarkOfStudent(students.get(0)));
        Assert.assertEquals(193, studentProcessor.getTotalMarkOfStudent(students.get(1)));
        Assert.assertEquals(148, studentProcessor.getTotalMarkOfStudent(students.get(2)));
        Assert.assertEquals(199, studentProcessor.getTotalMarkOfStudent(students.get(3)));
        Assert.assertEquals(6, studentProcessor.getTotalMarkOfStudent(students.get(4)));
    }

    @Test
    public void groupStudentsByDepartmentTest() {
        Map<String, List<Student>> studentsByDepartment = studentProcessor.groupStudentsByDepartment();
        Assert.assertThat(studentsByDepartment, Matchers.hasEntry(Matchers.is("CSE"),
                Matchers.hasSize(3)));
        Assert.assertThat(studentsByDepartment, Matchers.hasEntry(Matchers.is("ECE"),
                Matchers.hasSize(1)));
        Assert.assertThat(studentsByDepartment, Matchers.hasEntry(Matchers.is("ME"),
                Matchers.hasSize(1)));
    }

    @Test
    public void computeSumOfMarksByDepartmentTest() {
        Map<String, Integer> studentByMarks = studentProcessor.computeSumOfMarksByDepartment();
        Assert.assertThat(studentByMarks, Matchers.hasEntry(Matchers.is("CSE"), Matchers.is(260)));
        Assert.assertThat(studentByMarks, Matchers.hasEntry(Matchers.is("ECE"), Matchers.is(193)));
        Assert.assertThat(studentByMarks, Matchers.hasEntry(Matchers.is("ME"), Matchers.is(148)));
    }

    @Test
    public void getPassedAndFailedStudentsTest() {
        Map<Boolean, List<Student>> studentsResults = studentProcessor.getPassedAndFailedStudents();
        Assert.assertThat(studentsResults, Matchers.hasEntry(Matchers.is(Boolean.FALSE),
                Matchers.containsInAnyOrder(students.get(4))));
        Assert.assertThat(studentsResults, Matchers.hasEntry(Matchers.is(Boolean.TRUE),
                Matchers.containsInAnyOrder(students.get(0), students.get(1), students.get(2), students.get(3))));

    }

}

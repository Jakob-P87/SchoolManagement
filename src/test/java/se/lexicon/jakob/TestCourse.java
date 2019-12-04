package se.lexicon.jakob;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import se.lexicon.jakob.data_access.StudentDaoList;
import se.lexicon.jakob.models.Course;
import se.lexicon.jakob.models.Student;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TestCourse
{
    private Course course;
    private final String name = "Unfortunate Event";
    private LocalDate date;

    private StudentDaoList students;
    private Student student;
    private Student student2;


    @Before
    public void initCourse()
    {
        date = LocalDate.of(2019,12,20);
        course = new Course(name, date, 3);

        students = new StudentDaoList();

        student = new Student("Count Olaf", "abc@abc.123", "Not here");
        students.saveStudent(student);
        student2 = new Student("Violet Baudelaiere", "def@abc.123", "Over there");
        students.saveStudent(student2);
    }

    @After
    public void reset()
    {
        Course course = null;
        LocalDate date = null;

        StudentDaoList students = null;
        Student student = null;
        Student student2 = null;
    }

    @Test
    public void testId()
    {
        assertTrue(course.getId() > 0);
    }

    @Test
    public void testName()
    {
        assertEquals(name, course.getCourseName());
    }

    @Test
    public void testDate()
    {
        assertEquals(date, course.getStartDate());
    }

    @Test
    public void testDuration()
    {
        assertEquals(3, course.getWeekDuration());
    }

    @Test
    public void testRegisterStudent()
    {
        //Act
        course.register(student);
        course.register(student2);

        //Assert
        assertEquals(2, course.getStudents().size());
    }

    @Test
    public void testUnregisterStudent()
    {
        //Act
        course.register(student);
        course.register(student2);

        course.unregister(student);

        //Assert
        assertEquals(1, course.getStudents().size());
    }
}

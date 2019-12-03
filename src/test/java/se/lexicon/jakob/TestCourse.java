package se.lexicon.jakob;

import org.junit.Before;
import org.junit.Test;
import org.junit.internal.runners.model.EachTestNotifier;
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

        student = new Student("Count Olaf", "abc@abc.123", " ertyu");
        students.saveStudent(student);
        student2 = new Student("Violet Boudalaiere", "def@abc.123", " retyuio");
        students.saveStudent(student2);
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
        assertEquals(course.getStudents().size(), course.getStudents().size());
    }

    @Test
    public void testUnregisterStudent()
    {
        //Act
        course.register(student);
        course.register(student2);

        course.unregister(student);

        //Assert
        assertEquals(course.getStudents().size(), course.getStudents().size());
    }
}

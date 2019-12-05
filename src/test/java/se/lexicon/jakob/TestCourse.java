package se.lexicon.jakob;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import se.lexicon.jakob.data_access.StudentDaoList;
import se.lexicon.jakob.models.Course;
import se.lexicon.jakob.models.Student;

import java.time.LocalDate;

import static org.junit.Assert.*;

public class TestCourse
{
    private Course course;
    private final String name = "Unfortunate Event";
    private LocalDate date;
    private int duration;

    private StudentDaoList students;
    private Student student;
    private Student student2;


    @Before
    public void initCourse()
    {
        date = LocalDate.of(2019,12,20);
        duration = 3;
        course = new Course(name, date, duration);


        students = new StudentDaoList();

        student = new Student("Count Olaf", "abc@abc.123", "Not here");
        students.saveStudent(student);
        student2 = new Student("Violet Baudelaiere", "def@abc.123", "Over there");
        students.saveStudent(student2);
    }

    @After
    public void reset()
    {
        course = null;
        date = null;

        students = null;
        student = null;
        student2 = null;
    }

    @Test
    public void testId()
    {
        assertTrue(course.getId() > 0);
    }

    @Test
    public void testName()
    {
        assertEquals(course.getCourseName(), course.getCourseName());
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

    @Test
    public void setCourseName()
    {
        //Act
        course.setCourseName("mattematik");

        //Assert
        assertEquals(course.getCourseName(), course.getCourseName());
        assertNotEquals(name, course.getCourseName());
    }

    @Test
    public void testSetNewDate()
    {
        //Act
        LocalDate newDate = LocalDate.of(2020,1,7);
        course.setStartDate(newDate);

        //Assert
        assertEquals(course.getStartDate(), course.getStartDate());
        assertNotEquals(date, course.getStartDate());
    }

    @Test
    public void testSetNewDuration()
    {
        //Act
        course.setWeekDuration(5);

        //Assert
        assertEquals(course.getWeekDuration(), course.getWeekDuration());
        assertNotEquals(duration, course.getWeekDuration());
    }
}

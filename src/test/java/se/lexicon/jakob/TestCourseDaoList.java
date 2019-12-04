package se.lexicon.jakob;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import se.lexicon.jakob.data_access.CourseDaoList;
import se.lexicon.jakob.models.Course;

import java.time.LocalDate;

import static org.junit.Assert.*;

public class TestCourseDaoList
{
    private CourseDaoList course = new CourseDaoList();
    private LocalDate startDate;
    private final int weekDuration = 2;

    private Course course1;
    private Course course2;
    private Course course3;

    @Before
    public void initStudentDaoList()
    {
        startDate = LocalDate.of(2019, 12, 20);
        course1 = new Course("Test", startDate, weekDuration);
        course.saveCourse(course1);
        course2 = new Course("Test2", startDate, weekDuration);
        course.saveCourse(course2);
        course3 = new Course("Test3", startDate, weekDuration);
        course.saveCourse(course3);
    }

    @After
    public void reset()
    {
        course.clearList();
        course = null;
        startDate = null;
    }

    @Test
    public void testAddCourse()
    {
        //Act
        startDate = LocalDate.of(2020, 1, 12);
        course.saveCourse(new Course("New Course", startDate, weekDuration));

        //Assert
        assertEquals(4, course.findAll().size());
    }

    @Test
    public void testFindById()
    {
        //Assert
        assertEquals(course.findById(course2.getId()), course.findById(course2.getId()));
    }

    @Test
    public void testFindByName()
    {
        //Assert
        assertEquals(course.findByName(course1.getCourseName()), course.findByName(course1.getCourseName()));
    }

    @Test
    public void testFindByDate()
    {
        //Assert
        assertEquals(course.findByDate(course3.getStartDate()), course.findByDate(course3.getStartDate()) );
    }

    @Test
    public void testFindAll()
    {
        //Assert
        assertEquals(course.findAll(), course.findAll());
    }

    @Test
    public void testRemoveCourse()
    {
        //Act
        course.removeCourse(course2);

        //Assert
        assertEquals(2, course.findAll().size());
        assertNull(course.findById(course2.getId()));
    }
}

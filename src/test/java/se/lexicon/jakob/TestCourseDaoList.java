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
    private CourseDaoList course;
    private LocalDate startDate;
    private final int weekDuration = 2;

    @Before
    public void initStudentDaoList()
    {
        startDate = LocalDate.of(2019,12,20);
        course.saveCourse(new Course("", startDate, weekDuration));
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
        startDate = LocalDate.of(2020,1,12);
        course.saveCourse(new Course("",startDate, weekDuration));
    }
}

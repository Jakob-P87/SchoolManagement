package se.lexicon.jakob.data_access;

import se.lexicon.jakob.models.Course;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CourseDaoList implements CourseDao
{
    private static List<Course> courses = new ArrayList<>();

    @Override
    public Course saveCourse(Course course)
    {
        courses.add(course);
        return course;
    }

    @Override
    public Course findById(int id)
    {
        Iterator<Course> itr = courses.iterator(); //Have to be initialized in method where it is used, to update correctly

        Course course;

        while (itr.hasNext())
        {
            course = itr.next();
            if (course.getId() == id)
            {
                return course;
            }
        }
        return null;
    }

    @Override
    public List<Course> findByName(String name)
    {
        List<Course> findCourse = new ArrayList<>();

        for (Course course : courses)
        {
            if (course.getCourseName().equalsIgnoreCase(name))
            {
                findCourse.add(course);
            }
        }
        return findCourse;
    }

    @Override
    public List<Course> findByDate(LocalDate date)
    {
        List<Course> findCourseDate = new ArrayList<>();

        for (Course course : courses)
        {
            if (course.getStartDate().equals(date))
            {
                findCourseDate.add(course);
            }
        }
        return findCourseDate;
    }

    @Override
    public List<Course> findAll()
    {
        for (Course course : courses)
        {
            System.out.println("[" + course.getId() + "]" + course.getCourseName());
            System.out.println("Start: " + course.getStartDate());
            System.out.println("Duration: " + course.getWeekDuration());
            System.out.println("==========================");
        }
        return courses;
    }

    @Override
    public void clearList()
    {
        courses.clear();
    }

    @Override
    public boolean removeCourse(Course course)
    {
        return courses.remove(course);
    }
}

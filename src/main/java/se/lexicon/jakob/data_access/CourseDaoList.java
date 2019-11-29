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

        for (int i = 0; i < courses.size(); i++)
        {
            if (courses.get(i).getCourseName().equals(name))
            {
                findCourse.add(courses.get(i));
            }
        }
        return findCourse;
    }

    @Override
    public List<Course> findByDate(LocalDate date)
    {
        List<Course> findCourseDate = new ArrayList<>();

        for (int i = 0; i < courses.size(); i++)
        {
            if (courses.get(i).getStartDate().equals(date))
            {
                findCourseDate.add(courses.get(i));

            }
        }
        return findCourseDate;
    }

    @Override
    public List<Course> findAll()
    {
        for (Course course : courses)
        {
            System.out.println("[" + course.getId() + "]" + course.getCourseName() + "\nStart Date[" + course.getStartDate() + "]\nDuration: " + course.getWeekDuration() + " Weeks");
        }
        return courses;
    }

    @Override
    public boolean removeCourse(Course course)
    {
        return courses.remove(course);
    }
}

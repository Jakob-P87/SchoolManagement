package se.lexicon.jakob.data_access;

import se.lexicon.jakob.models.Course;

import java.time.LocalDate;
import java.util.List;

public interface CourseDao
{
    Course saveCourse(Course course);
    Course findById(int id);
    List<Course> findByName(String name);
    List<Course> findByDate(LocalDate date);
    List<Course> findAll();
    void clearList();
    boolean removeCourse(Course course);
}

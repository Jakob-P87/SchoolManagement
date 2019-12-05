package se.lexicon.jakob.models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Course
{
    private int id;
    private String courseName;
    private LocalDate startDate;
    private int weekDuration;
    private List<Student> students = new ArrayList<>();

    private static int counter;

    public Course(String courseName, LocalDate startDate, int weekDuration)
    {
        this.id = ++counter;
        this.courseName = courseName;
        this.startDate = startDate;
        this.weekDuration = weekDuration;
    }

    public int getId()
    {
        return id;
    }

    public String getCourseName()
    {
        return courseName.substring(0,1).toUpperCase() + courseName.substring(1).toLowerCase();
    }

    public LocalDate getStartDate()
    {
        return startDate;
    }

    public int getWeekDuration()
    {
        return weekDuration;
    }

    public List<Student> getStudents()
    {
        return students;
    }

    public void register(Student student)
    {
        students.add(student);
    }

    public void unregister(Student student)
    {
        students.remove(student);
    }

    public void setCourseName(String courseName)
    {
        this.courseName = courseName;
    }

    public void setStartDate(LocalDate startDate)
    {
        this.startDate = startDate;
    }

    public void setWeekDuration(int weekDuration)
    {
        this.weekDuration = weekDuration;
    }
}

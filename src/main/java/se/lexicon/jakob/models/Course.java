package se.lexicon.jakob.models;

import java.time.LocalDate;
import java.util.List;

public class Course
{
    private int id;
    private String courseName;
    private LocalDate startDate;
    private int weekDuration;
    private List<Student> students;

    private static int counter;

    public Course(String courseName, LocalDate startDate, int weekDuration, List<Student> students)
    {
        this.id = ++counter;
        this.courseName = courseName;
        this.startDate = startDate;
        this.weekDuration = weekDuration;
        this.students = students;
    }

    public int getId()
    {
        return id;
    }

    public String getCourseName()
    {
        return courseName;
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

    public void setStudents(List<Student> students)
    {
        this.students = students;
    }
}

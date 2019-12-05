package se.lexicon.jakob.data_access;

import se.lexicon.jakob.models.Student;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class StudentDaoList implements StudentDao
{
    private static List<Student> students = new ArrayList<>();

    @Override
    public Student saveStudent(Student student)
    {
        students.add(student);
        return student;
    }

    @Override
    public Student findByEmail(String email)
    {
        Iterator<Student> itr = students.iterator(); //Have to be initialized in method where it is used, to update correctly

        Student student;

        while (itr.hasNext())
        {
            student = itr.next();
            if (student.getEmail().equals(email))
            {
                return student;
            }
        }
        return null;
    }

    @Override
    public List<Student> findByName(String name)
    {
        List<Student> findStudent = new ArrayList<>();

        for (Student student : students)
        {
            if (student.getName().equalsIgnoreCase(name))
            {
                findStudent.add(student);
            }
        }
        return findStudent;
    }

    @Override
    public Student findById(int id)
    {
        for (Student student : students)
        {
            if (student.getId() == id)
            {
                return student;
            }
        }
        return null;
    }

    @Override
    public List<Student> findAll()
    {
        for (Student student : students)
        {
            System.out.println("[" + student.getId() + "] " + student.getName());
            System.out.println("Address: " + student.getAddress());
            System.out.println("Email: " + student.getEmail());
            System.out.println("==========================");
        }
        return students;
    }

    @Override
    public void clearList()
    {
        students.clear();
    }

    @Override
    public boolean deleteStudent(Student student)
    {
        return students.remove(student);
    }
}

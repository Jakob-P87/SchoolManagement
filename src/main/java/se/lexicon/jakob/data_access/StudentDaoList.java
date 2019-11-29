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

        for (int i = 0; i < students.size(); i++)
        {
            if (students.get(i).getName().equals(name))
            {
                findStudent.add(students.get(i));

            }
        }
        return findStudent;
    }

    @Override
    public Student findById(int id)
    {
        for (int i = 0; i < students.size(); i++)
        {
            if (students.get(i).getId() == id)
            {
                return students.get(i);
            }
        }
        return null;
    }

    @Override
    public List<Student> findAll()
    {
        for (Student student : students)
        {
            System.out.println("[" + student.getId() + "]" + student.getName() + student.getAddress() + "\n\t" + student.getEmail());
        }
        return students;
    }

    @Override
    public boolean deleteStudent(Student student)
    {
        return students.remove(student);
    }
}

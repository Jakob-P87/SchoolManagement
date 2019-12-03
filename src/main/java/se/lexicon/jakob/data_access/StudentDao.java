package se.lexicon.jakob.data_access;

import se.lexicon.jakob.models.Student;

import java.util.List;

public interface StudentDao
{
    Student saveStudent(Student student);
    Student findByEmail(String email);
    List<Student> findByName(String name);
    Student findById(int id);
    List<Student> findAll();
    void clearList();
    boolean deleteStudent(Student student);
}

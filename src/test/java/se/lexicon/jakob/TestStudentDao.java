package se.lexicon.jakob;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import se.lexicon.jakob.data_access.StudentDaoList;
import se.lexicon.jakob.models.Student;

public class TestStudentDao
{
    private StudentDaoList students;
    private Student student;

    @Before
    public void initStudentDao()
    {
        students  = new StudentDaoList();

        Student newStudent = new Student("Count Olaf", "abc@abc.123"," ertyu");
        students.saveStudent(newStudent);
        Student newStudent2 = new Student("Violet Boudalaiere", "def@abc.123"," retyuio");
        students.saveStudent(newStudent2);
        Student newStudent3 = new Student("Klaus Boudalaiere", "ghi@abc.123"," retyuio");
        students.saveStudent(newStudent3);
    }

    @Test
    public void testAddStudent()
    {
        //Assert
        assertNotNull("Object does not exist", students.findById(2));
    }

    @After
    public void reset()
    {
        Student.setCounter();
    }

    @Test
    public void removeStudent()
    {
        //Assert
        assertEquals(3, students.findAll().size());
        assertTrue(students.deleteStudent(students.findById(1)));
        assertEquals(2, students.findAll().size());
        assertNull(students.findById(1));
        assertNotNull(students.findById(2));
    }

    @Test
    public void testFindByEmail()
    {
        //Assert
        assertNotNull(students.findByEmail(student.getEmail()));
    }

}

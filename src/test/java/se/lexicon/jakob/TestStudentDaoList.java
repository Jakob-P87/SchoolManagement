package se.lexicon.jakob;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import se.lexicon.jakob.data_access.StudentDaoList;
import se.lexicon.jakob.models.Student;

public class TestStudentDaoList
{
    private StudentDaoList students;
    private Student student;
    private Student student2;
    private Student student3;

    @Before
    public void initStudentDao()
    {
        students = new StudentDaoList();

        student = new Student("Count Olaf", "abc@abc.123", " ertyu");
        students.saveStudent(student);
        student2 = new Student("Violet Boudalaiere", "def@abc.123", " retyuio");
        students.saveStudent(student2);
        student3 = new Student("Klaus Boudalaiere", "ghi@abc.123", " retyuio");
        students.saveStudent(student3);
    }

    @After
    public void reset()
    {
        students.clearList();
        students = null;
        student = null;
        student2 = null;
        student3 = null;
    }

    @Test
    public void addStudent()
    {
        //Act
        Student student4 = new Student("kalle", "kalle@email.com", "valhall");
        students.saveStudent(student4);

        //Assert
        assertEquals(4, students.findAll().size());
    }


    @Test
    public void testRemoveStudent()
    {
        //Assert
        assertEquals(3, students.findAll().size());
        assertTrue(students.deleteStudent(students.findById(student3.getId())));
        assertEquals(2, students.findAll().size());
        assertNull(students.findById(student3.getId()));
    }

    @Test
    public void testRemoveNonExistent()
    {
        //Assert
        assertEquals(3, students.findAll().size());
        assertFalse(students.deleteStudent(students.findById(4)));
        assertEquals(3, students.findAll().size());
    }

    @Test
    public void testFindStudentId()
    {
        //Assert
        assertEquals(students.findById(student2.getId()), students.findById(student2.getId()));
    }

    @Test
    public void testFindByEmail()
    {
        //Assert
        assertEquals(students.findByEmail(student2.getEmail()), students.findByEmail(student2.getEmail()));
        assertNotNull(students.findByEmail(student2.getEmail()));
    }

    @Test
    public void testFindByName()
    {
        //Assert
        assertEquals(students.findByName(student3.getName()), students.findByName(student3.getName()));
    }

    @Test
    public void testFindAllStudents()
    {
        //Assert
        assertEquals(students.findAll(), students.findAll());
    }
}

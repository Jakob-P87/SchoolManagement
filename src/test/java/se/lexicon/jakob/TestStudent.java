package se.lexicon.jakob;

import org.junit.Before;
import org.junit.Test;
import se.lexicon.jakob.models.Student;

import static org.junit.Assert.*;

public class TestStudent
{
    private Student student;
    private final String name = "Bernt";
    private final String email = "bernt@abc.com";
    private final String address = "Villovägar 22";

    @Before
    public void initStudent()
    {
        student = new Student(name,email,address);
    }

    @Test
    public void testId()
    {
        assertTrue(student.getId() > 0);
    }

    @Test
    public void testName()
    {
        assertEquals(name, student.getName());
    }

    @Test
    public void testEmail()
    {
        assertEquals(email, student.getEmail());
    }

    @Test
    public void testAddress()
    {
        assertEquals(address, student.getAddress());
    }

    @Test
    public void testSetName()
    {
        //Act
        student.setName("lasse");

        //Assert
        assertEquals(student.getName(), student.getName());
        assertNotEquals(name, student.getName());
    }

    @Test
    public void testSetEmail()
    {
        //Act
        student.setEmail("lasse@abc.com");

        //Assert
        assertEquals(student.getEmail(), student.getEmail());
        assertNotEquals(email, student.getEmail());
    }

    @Test
    public void testSetAddress()
    {
        //Act
        student.setAddress("valhall");

        //Assert
        assertEquals(student.getAddress(), student.getAddress());
        assertNotEquals(address, student.getAddress());
    }
}

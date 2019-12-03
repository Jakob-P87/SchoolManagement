package se.lexicon.jakob;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import se.lexicon.jakob.models.Student;

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
}

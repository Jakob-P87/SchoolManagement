package se.lexicon.jakob.models;

public class Student
{
    private int id;
    private String name;
    private String email;
    private String address;

    private static int counter;

    public Student(String name, String email, String address)
    {
        this.id = ++counter;
        this.name = name;
        this.email = email;
        this.address = address;
    }

    public int getId()
    {
        return id;
    }

    public String getName()
    {
        return name;
    }

    public String getEmail()
    {
        return email;
    }

    public String getAddress()
    {
        return address;
    }
}

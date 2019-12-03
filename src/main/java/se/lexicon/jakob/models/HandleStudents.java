package se.lexicon.jakob.models;

import se.lexicon.jakob.data_access.StudentDaoList;
import se.lexicon.jakob.interfaces.IScanner;

public class HandleStudents implements IScanner
{
    private static StudentDaoList students = new StudentDaoList();

    public static void students()
    {
        boolean runStudentMenu = true;

        while (runStudentMenu)
        {
            /**--------------------------------------*/
            System.out.println("[1]Add New Student");
            System.out.println("[2]Find All Students");
            System.out.println("[3]Delete Student");
            System.out.println("[4]Back To Menu");
            /**--------------------------------------*/

            int choice = Integer.parseInt(scan.nextLine());

            switch (choice)
            {
                case 1:
                    addStudent();
                    break;
                case 2:
                    students.findAll();
                    break;
                case 3:
                    removeStudent();
                    break;
                case 4:
                    runStudentMenu = false;
                    break;
                default:
            }
        }
    }

    private static void addStudent()
    {
        System.out.print("Enter Name: ");
        String name = scan.nextLine();

        System.out.print("Enter Email: ");
        String email = scan.nextLine();

        System.out.println("Enter Address: ");
        String address = scan.nextLine();

        StudentDaoList newStudent = new StudentDaoList();
        newStudent.saveStudent(new Student(name, email, address));
    }

    private static void removeStudent()
    {
        System.out.print("Student ID: ");
        int studentId = Integer.parseInt(scan.nextLine());

        students.deleteStudent(students.findById(studentId));
    }
}

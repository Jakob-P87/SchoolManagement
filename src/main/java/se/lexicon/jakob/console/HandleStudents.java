package se.lexicon.jakob.console;

import se.lexicon.jakob.data_access.StudentDaoList;
import se.lexicon.jakob.interfaces.IScanner;
import se.lexicon.jakob.models.Student;

import java.util.List;

public class HandleStudents implements IScanner
{
    private static StudentDaoList students = new StudentDaoList();
    private static Student student;

    public static void studentsMainMenu()
    {
        boolean runStudentMenu = true;

        while (runStudentMenu)
        {
            /**--------------------------------------*/
            System.out.println("[1]Add New Student");
            System.out.println("[2]See All Students");
            System.out.println("[3]Find Student");
            System.out.println("[4]Edit Student Information");
            System.out.println("[5]Delete Student");
            System.out.println("[6]Back");
            System.out.println("==========================");
            /**--------------------------------------*/

            try
            {
                int choice = Integer.parseInt(scan.nextLine());

                switch (choice)
                {
                    case 1:
                        addNewStudent();
                        break;
                    case 2:
                        students.findAll();
                        break;
                    case 3:
                        findStudent();
                        break;
                    case 4:
                        editStudentInformation();
                        break;
                    case 5:
                        removeStudentFromSystem();
                        break;
                    case 6:
                        runStudentMenu = false;
                        break;
                    default:
                }
            }catch(NumberFormatException e)
            {
                System.out.println("Invalid Input!");
            }
        }
    }

    private static void addNewStudent()
    {
        System.out.print("Enter Name: ");
        String name = scan.nextLine();

        System.out.print("Enter Email: ");
        String email = scan.nextLine();

        System.out.print("Enter Address: ");
        String address = scan.nextLine();

        StudentDaoList newStudent = new StudentDaoList();
        newStudent.saveStudent(new Student(name, email, address));
    }

    private static void findStudent()
    {
        boolean keepSearching = true;

        while(keepSearching)
        {
            /**--------------------------------------*/
            System.out.println("[1]Search by Id");
            System.out.println("[2]Search by Name");
            System.out.println("[3]Search by Email");
            System.out.println("[4]Back");
            System.out.println("==========================");
            /**--------------------------------------*/

            try
            {
                int choice = Integer.parseInt(scan.nextLine());
                switch (choice)
                {
                    case 1:
                        System.out.print("ID: ");
                        int searchId = Integer.parseInt(scan.nextLine());
                        student = students.findById(searchId);
                        printStudentInfo(student);
                        break;
                    case 2:
                        List<Student> studentList;

                        System.out.print("Name: ");
                        String searchName = scan.nextLine();
                        studentList = students.findByName(searchName);

                        for (Student tempStudent : studentList)
                        {
                            printStudentInfo(tempStudent);
                        }

                        break;
                    case 3:
                        System.out.print("Email: ");
                        String searchEmail = scan.nextLine();
                        student = students.findByEmail(searchEmail);
                        printStudentInfo(student);
                        break;
                    case 4:
                        keepSearching = false;
                        break;
                    default:
                }
            }catch(NumberFormatException e)
            {
                System.out.println("Invalid Input!");
            }
        }
    }

    private static void editStudentInformation()
    {
        boolean keepCustomizing = true;

        System.out.print("Student ID:");
        try
        {
            int studentId = Integer.parseInt(scan.nextLine());

            while(keepCustomizing)
            {
                student = students.findById(studentId);
                System.out.println("====== Edit Course =======");
                printStudentInfo(student);

                /**--------------------------------------*/
                System.out.println("[1]Student Name");
                System.out.println("[2]Student Email Address");
                System.out.println("[3]Student Address");
                System.out.println("[6]Done");
                System.out.println("==========================");
                /**--------------------------------------*/

                try
                {
                    int choice = Integer.parseInt(scan.nextLine());

                    switch(choice)
                    {
                        case 1:
                            String newName = scan.nextLine();
                            student.setName(newName);
                            break;
                        case 2:
                            String email = scan.nextLine();
                            student.setEmail(email);
                            break;
                        case 3:
                            String address = scan.nextLine();
                            student.setAddress(address);
                            break;
                        case 4:
                            keepCustomizing = false;
                            break;
                        default:
                    }
                }catch(NumberFormatException input)
                {
                    System.out.println("Invalid Input!");
                }
            }
        }catch(NumberFormatException input)
        {
            System.out.println("Invalid Input!");
        }
    }

    private static void removeStudentFromSystem()
    {
        System.out.print("Student ID: ");
        try
        {
            int studentId = Integer.parseInt(scan.nextLine());

            students.deleteStudent(students.findById(studentId));
        }catch(NumberFormatException e)
        {
            System.out.println("Invalid Input!");
        }
    }

    private static void printStudentInfo(Student student)
    {
        System.out.println("[" + student.getId() + "] " + student.getName());
        System.out.println("Address: " + student.getAddress());
        System.out.println("Email: " + student.getEmail());
        System.out.println("__________________________");
    }
}

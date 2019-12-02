package se.lexicon.jakob.graphics;

import se.lexicon.jakob.data_access.CourseDaoList;
import se.lexicon.jakob.interfaces.IScanner;
import se.lexicon.jakob.models.Course;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class MainMenu implements IScanner
{
    public static void main(String[] args)
    {
        menu();
    }

    private static CourseDaoList courses = new CourseDaoList();

    public static void menu()
    {
        boolean keepRunning = true;

        while(keepRunning)
        {
            System.out.println("School Management System");
            System.out.println("Menu");
            System.out.print("[C]ourses" + "\n" + "[S]tudents" + "\n" +"[E]xit");
            char choice = scan.nextLine().toUpperCase().charAt(0);

            switch(choice)
            {
                case 'C':
                    courses();
                    break;
                case 'S':
                    students();
                    break;
                case 'E':
                    keepRunning = false;
                    break;
                default:
            }
        }
    }

    public static void courses()
    {
        boolean runCourseMenu = true;

        while(runCourseMenu)
        {
            System.out.println("[1]Add New Course" + "[2]Delete Course" + "[3]All Courses" + "[4]Back To Menu");
            int choice = Integer.parseInt(scan.nextLine());
            switch (choice)
            {
                case 1:
                    addCourse();
                    break;
                case 2:
                    //courses.removeCourse(1);
                    break;
                case 3:
                    courses.findAll();
                    break;
                case 4:
                    runCourseMenu = false;
                    break;
                default:
            }
        }
    }

    public static void students()
    {

    }

    private static LocalDate dateInput(String userInput)
    {
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        return LocalDate.parse(userInput, dateFormat);
    }

    private static void addCourse()
    {
        System.out.print("Course name: ");
        String name = scan.nextLine();

        System.out.print("Start date (YYYY-MM-DD):");
        LocalDate date = dateInput(scan.nextLine());

        System.out.print("Duration in weeks: ");
        int weeks = Integer.parseInt(scan.nextLine());

        CourseDaoList newCourse = new CourseDaoList();
        newCourse.saveCourse(new Course(name, date, weeks));
    }

    private static void addStudent()
    {

    }
}

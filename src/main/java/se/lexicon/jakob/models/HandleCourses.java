package se.lexicon.jakob.models;

import se.lexicon.jakob.data_access.CourseDaoList;
import se.lexicon.jakob.interfaces.IScanner;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class HandleCourses implements IScanner
{
    private static CourseDaoList courses = new CourseDaoList();

    public static void courses()
    {
        boolean runCourseMenu = true;

        while (runCourseMenu)
        {
            /**--------------------------------------*/
            System.out.println("[1]Add New Course");
            System.out.println("[2]All Courses");
            System.out.println("[3]Add Student to course");
            System.out.println("[4]Delete Course");
            System.out.println("[5]Back To Menu");
            /**--------------------------------------*/

            int choice = Integer.parseInt(scan.nextLine());

            switch (choice)
            {
                case 1:
                    addCourse();
                    break;
                case 2:
                    courses.findAll();
                    break;
                case 3:
                    addStudentToCourse();
                    break;
                case 4:
                    removeCourse();
                    break;
                case 5:
                    runCourseMenu = false;
                    break;
                default:
            }
        }
    }

    private static LocalDate dateInput(String userInput)
    {

        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        try
        {
            return LocalDate.parse(userInput, dateFormat);
        }catch(Exception a)
        {
            System.out.println("Not correct date format");
            return null;
        }
    }

    private static void addCourse()
    {
        boolean correctDateFormat = false;
        LocalDate date = null;

        System.out.print("Course name: ");
        String name = scan.nextLine();

        while(!correctDateFormat)
        {
            System.out.print("Start date (YYYY-MM-DD):");
            date = dateInput(scan.nextLine());
            correctDateFormat = date != null;
        }

        System.out.print("Duration in weeks: ");
        int weeks = Integer.parseInt(scan.nextLine());

        CourseDaoList newCourse = new CourseDaoList();
        newCourse.saveCourse(new Course(name, date, weeks));
    }

    private static void removeCourse()
    {
        System.out.print("Course ID: ");
        int courseId = Integer.parseInt(scan.nextLine());

        courses.removeCourse(courses.findById(courseId));
    }

    private static void addStudentToCourse()
    {

    }
}

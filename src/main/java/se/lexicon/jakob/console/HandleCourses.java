package se.lexicon.jakob.console;

import se.lexicon.jakob.data_access.CourseDaoList;
import se.lexicon.jakob.data_access.StudentDaoList;
import se.lexicon.jakob.interfaces.IScanner;
import se.lexicon.jakob.models.Course;
import se.lexicon.jakob.models.Student;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class HandleCourses implements IScanner
{
    private static CourseDaoList courses = new CourseDaoList();
    private static Course course;
    private static StudentDaoList studentList = new StudentDaoList();
    private static Student student;

    public static void coursesMainMenu()
    {
        boolean runCourseMenu = true;

        while (runCourseMenu)
        {
            /**--------------------------------------*/
            System.out.println("========= Courses ========");
            System.out.println("[1]Add New Course");
            System.out.println("[2]All Courses");
            System.out.println("[3]Find Course");
            System.out.println("[4]Edit Course");
            System.out.println("[5]Delete Course");
            System.out.println("[6]Back To Menu");
            /**--------------------------------------*/

            try
            {
                int choice = Integer.parseInt(scan.nextLine());

                switch (choice)
                {
                    case 1:
                        addNewCourse();
                        break;
                    case 2:
                        courses.findAll();
                        break;
                    case 3:
                        findCourse();
                        break;
                    case 4:
                        editCourseInformation();
                        break;
                    case 5:
                        removeCourseFromSystem();
                        break;
                    case 6:
                        runCourseMenu = false;
                        break;
                    default:
                }
            }catch(NumberFormatException a)
            {
                System.out.println("Invalid Input!");
            }
        }
    }

    private static LocalDate dateInput(String userInput)
    {

        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-M-d");

        try
        {
            return LocalDate.parse(userInput, dateFormat);
        } catch (Exception a)
        {
            System.out.println("Not correct date format");
            return null;
        }
    }

    private static void addNewCourse()
    {
        boolean correctDateFormat = false;
        LocalDate date = null;

        System.out.print("Course name: ");
        String name = scan.nextLine();

        while (!correctDateFormat)
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

    private static void findCourse()
    {
        boolean keepSearching = true;

        while (keepSearching)
        {
            /**--------------------------------------*/
            System.out.println("[1]Search by Id");
            System.out.println("[2]Search by Name");
            System.out.println("[3]Search by Date");
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
                        course = courses.findById(searchId);
                        printCourseInfo(course);
                        break;
                    case 2:
                        List<Course> courseList;

                        System.out.print("Name: ");
                        String searchName = scan.nextLine();
                        courseList = courses.findByName(searchName);

                        for (Course tempCourse : courseList)
                        {
                            printCourseInfo(tempCourse);
                        }
                        break;
                    case 3:
                        List<Course> dateList;

                        boolean correctDateFormat = false;
                        LocalDate date = null;

                        while (!correctDateFormat)
                        {
                            System.out.print("Search date (YYYY-MM-DD):");
                            date = dateInput(scan.nextLine());
                            correctDateFormat = date != null;
                        }

                        dateList = courses.findByDate(date);

                        for (Course tempList : dateList)
                        {
                            printCourseInfo(tempList);
                        }

                        break;
                    case 4:
                        keepSearching = false;
                        break;
                    default:
                }
            }catch(NumberFormatException input)
            {
                System.out.println("Invalid Input!");
            }
        }
    }

    private static void removeCourseFromSystem()
    {
        System.out.print("Course ID: ");
        int courseId = Integer.parseInt(scan.nextLine());

        courses.removeCourse(courses.findById(courseId));
    }

    private static void printCourseInfo(Course course)
    {

        System.out.println("[" + course.getId() + "]" + course.getCourseName());
        System.out.println("Start: " + course.getStartDate());
        System.out.println("Duration: " + course.getWeekDuration());
        System.out.println("Students in Course:");
        for (Student student : course.getStudents())
        {
            System.out.println("[" + student.getId() + "]" + student.getName());
        }
        System.out.println("__________________________");
    }

    private static void editCourseInformation()
    {
        boolean keepCustomizing = true;


        System.out.print("Select Course ID:");
        try
        {
            int courseId = Integer.parseInt(scan.nextLine());

            while (keepCustomizing)
            {
                course = courses.findById(courseId);
                System.out.println("====== Edit Course =======");
                printCourseInfo(course);

                /**--------------------------------------*/
                System.out.println("[1]Rename Course");
                System.out.println("[2]Change Start Date");
                System.out.println("[3]Change Duration");
                System.out.println("[4]Add Student");
                System.out.println("[5]Remove Student");
                System.out.println("[6]Done");
                System.out.println("==========================");
                /**--------------------------------------*/

                try
                {
                    int choice = Integer.parseInt(scan.nextLine());

                    switch (choice)
                    {
                        case 1:
                            System.out.print("New Name: ");
                            String newName = scan.nextLine();
                            course.setCourseName(newName);
                            break;
                        case 2:
                            boolean correctDateFormat = false;
                            LocalDate date = null;

                            while (!correctDateFormat)
                            {
                                System.out.print("New Date (YYYY-MM-DD):");
                                date = dateInput(scan.nextLine());
                                correctDateFormat = date != null;
                            }

                            course.setStartDate(date);
                            break;
                        case 3:
                            System.out.print("New duration: ");
                            int newDuration = Integer.parseInt(scan.nextLine());
                            course.setWeekDuration(newDuration);
                            break;
                        case 4:
                            System.out.print("Student ID:");
                            int addStudent = Integer.parseInt(scan.nextLine());

                            student = studentList.findById(addStudent);

                            course.register(student);
                            break;
                        case 5:
                            System.out.print("Student ID:");
                            int removeStudent = Integer.parseInt(scan.nextLine());

                            student = studentList.findById(removeStudent);

                            course.unregister(student);
                            break;
                        case 6:
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
}
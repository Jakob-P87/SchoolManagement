package se.lexicon.jakob.console;

import se.lexicon.jakob.interfaces.IScanner;

public class MainMenu implements IScanner
{
    public static void main(String[] args)
    {
        menu();
    }

    private static void menu()
    {
        boolean keepRunning = true;

        while (keepRunning)
        {
            System.out.println("=School Management System=");
            System.out.println("========== Menu ==========");
            System.out.println("[C]ourses");
            System.out.println("[S]tudents");
            System.out.println("[E]xit");
            System.out.println("==========================");

            char choice = scan.nextLine().toUpperCase().charAt(0);

            switch (choice)
            {
                case 'C':
                    HandleCourses.coursesMainMenu();
                    break;
                case 'S':
                    HandleStudents.studentsMainMenu();
                    break;
                case 'E':
                    keepRunning = false;
                    break;
                default:
            }
        }
    }
}

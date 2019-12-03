package se.lexicon.jakob.graphics;

import se.lexicon.jakob.interfaces.IScanner;
import se.lexicon.jakob.models.HandleCourses;
import se.lexicon.jakob.models.HandleStudents;

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
            System.out.println("School Management System");
            System.out.println("Menu");
            System.out.print("[C]ourses" + "\n" + "[S]tudents" + "\n" + "[E]xit");
            char choice = scan.nextLine().toUpperCase().charAt(0);

            switch (choice)
            {
                case 'C':
                    HandleCourses.courses();
                    break;
                case 'S':
                    HandleStudents.students();
                    break;
                case 'E':
                    keepRunning = false;
                    break;
                default:
            }
        }
    }
}

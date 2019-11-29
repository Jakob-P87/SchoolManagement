package se.lexicon.jakob.graphics;

import se.lexicon.jakob.interfaces.IScanner;

public class MainMenu implements IScanner
{
    public static void main(String[] args)
    {
        menu();
    }

    public static void menu()
    {
        System.out.println("School Management System");
        System.out.println("Menu");
        System.out.print("[C]ourses" + "\n" + "[S]tudents" + "\n" +"[E]xit");

        boolean keepRunning = true;

        while(keepRunning)
        {
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
        //int choice = Integer.parseInt(scan.nextLine());
    }

    public static void students()
    {

    }
}
